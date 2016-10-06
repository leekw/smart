package net.smart.web.code.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import net.smart.web.code.dao.CodeDao;
import net.smart.web.domain.CommonCode;
import net.smart.web.domain.jira.JiraComponent;
import net.smart.web.domain.jira.JiraOption;
import net.smart.web.jira.service.JiraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("codeServiceImpl")
public class CodeServiceImpl implements CodeService {
	
	private Map<String, List<CommonCode>> codeData;
	
	@Autowired
	private JiraService jiraService;
	
	@Autowired
	private CodeDao codeDao;
	
	private AtomicInteger sync = new AtomicInteger(0);
	
	@PostConstruct
	private void init() {
		codeData = new HashMap<String, List<CommonCode>>();
		codeData = this.getAllCodes();
	}
	
	private Map<String, List<CommonCode>> getAllCodes() {
		Map<String, List<CommonCode>> result = new HashMap<String, List<CommonCode>>();
		List<CommonCode> temps = codeDao.getCodeList(new CommonCode());
		for (CommonCode code : temps) {
			List<CommonCode> codes = result.get(code.getCommonCodeType());
			if(codes == null) {
				codes = new ArrayList<CommonCode>();
				result.put(code.getCommonCodeType(), codes);
			}
			codes.add(code);
		}
		return result;
	}

	@Override
//	@Scheduled(cron="0 0/30 * * * ? ")
	public void addCodeByJiraOption() {
		final String jiraUnSync = System.getProperty("jiraUnSync");
		if (jiraUnSync == null || jiraUnSync.equals("N")) {
			List<CommonCode> codes = new ArrayList<CommonCode>();
			List<JiraOption> options = jiraService.getJiraOptionList(new JiraOption());
			for (JiraOption option : options) {
				CommonCode code = new CommonCode();
				code.setCommonCodeType(String.valueOf(option.getCustomfield()));
				code.setCommonCode(String.valueOf(option.getId()));
				code.setCommonCodeName(option.getCustomvalue());
				code.setSortNo(option.getSequence());
				codes.add(code);
			}
			List<JiraComponent> components = jiraService.getComponentList(new JiraComponent());
			for (JiraComponent obj : components) {
				CommonCode code = new CommonCode();
				code.setCommonCodeType(String.valueOf(obj.getProject()));
				code.setCommonCode(String.valueOf(obj.getId()));
				code.setCommonCodeName(obj.getCname());
				code.setSortNo(0);
				codes.add(code);
			}
			this.setCodeByJiraOption(codes);
		}
		synchronized(sync) {
			codeData.clear();
			codeData = this.getAllCodes();
		}
	}
	
	@Transactional
	private void setCodeByJiraOption(List<CommonCode> params) {
		codeDao.addCode(params);
	}

	@Override
	public List<CommonCode> getCodeList(CommonCode param) {
		if (codeData !=null && !codeData.isEmpty()) {
			List<CommonCode> temps = codeData.get(param.getCommonCodeType());
			List<CommonCode> results = new ArrayList<CommonCode>();
			for (CommonCode code : temps) {
				if (param.getRefValue1() != null
						&& !code.getRefValue1().equals(param.getRefValue1())) {
					continue;
				}
				if (param.getRefValue2() != null
						&& !code.getRefValue2().equals(param.getRefValue2())) {
					continue;
				}
				results.add(code);
			}
			return results;
		} else {
			return codeDao.getCodeList(param);
		}
	}

	@Override
	public String getCodeName(String type, String code) {
		CommonCode param = new CommonCode();
		param.setCommonCodeType(type);
		for (CommonCode obj : this.getCodeList(param)) {
			if (obj.getCommonCode().equals(code)) 
				return obj.getCommonCodeName();
		}
		return null;
	}

}
