package net.smart.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import net.smart.common.dao.IntegrationCommonDao;
import net.smart.common.domain.DataSyncInfo;
import net.smart.common.domain.IntUser;
import net.smart.common.domain.UserDetail;
import net.smart.common.support.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("integrationCommonService")
public class IntegrationCommonServiceImpl implements IntegrationCommonService {
	
	@Autowired
	private IntegrationCommonDao integrationCommonDao;
	
	private int limitCount;
	
	private Map<String, String> mainResource;
	
	private Map<String, String> developerData;
	
	private Map<String, String> permitUrls;
	
	private DataSyncInfo interfaceDate;
	
	private AtomicInteger dateSync = new AtomicInteger(0);
	
	private AtomicInteger syncCount = new AtomicInteger(0);
	
	@Value("${system.deploy.version}")
	private String systemDeployVersion;
	
	@Value("${integration.developers}")
	private String developers;
	
	
	public String getDevelopers() {
		return developers;
	}


	public void setDevelopers(String developers) {
		this.developers = developers;
	}


	public String getSystemDeployVersion() {
		return systemDeployVersion;
	}

	
	public int getLimitCount() {
		return this.limitCount;
	}
	
	
	
	@PostConstruct
	public void init() {
		this.limitCount = integrationCommonDao.getLimitConnectionCount();
		this.mainResource = integrationCommonDao.getMainResourceInfo();
		this.interfaceDate = integrationCommonDao.getInterfaceDateInfo();
		this.setDeveloperData();
		this.setExternalPermitUrl();
	}
	
	private void setExternalPermitUrl() {
		this.permitUrls = new HashMap<String, String>();
		this.permitUrls.put("nlayout", "nlayout");
		this.permitUrls.put("nlayoutm", "nlayoutm");
		this.permitUrls.put("ncutoverm", "ncutoverm");
		this.permitUrls.put("stabilizationm", "stabilizationm");
	}
	
	private void setDeveloperData() {
		this.developerData = new HashMap<String, String>();
		for (String dev : developers.split(",")) {
			this.developerData.put(dev, dev);
		}
	}
	
//	@Scheduled(cron="0 0/5 * * * ? ")
	public void setInterfaceDateInfo() {
		DataSyncInfo data = integrationCommonDao.getInterfaceDateInfo();
		synchronized(dateSync) {
			this.interfaceDate = null;
			this.interfaceDate = data;
		}
	}


	@Override
	public boolean isAdmin(String ip) {
		if (this.isSuperAmin()) return true;
		return false;
	}

	@Override
//	@Scheduled(cron="0 0/1 * * * ? ")
	public void setLimitConnectionCount() {
		Integer result = integrationCommonDao.getLimitConnectionCount();
		Map<String, String> mainResource = integrationCommonDao.getMainResourceInfo();
		synchronized(syncCount){
			this.limitCount = result.intValue();
			this.mainResource.clear();
			this.mainResource = mainResource;
		}
	}

	@Override
	public Map<String, String> getMainResourceInfo() {
		return this.mainResource;
	}

	@Override
	public DataSyncInfo getDataSyncInfo(DataSyncInfo param) {
		return integrationCommonDao.getDataSyncInfo(param);
	}

	@Override
	@Transactional
	public void modifyDataSyncInfo(DataSyncInfo param) {
		integrationCommonDao.modifyDataSyncInfo(param);
	}

	@Override
	@Transactional
	public void addDataSyncInfo(DataSyncInfo param) {
		integrationCommonDao.addDataSyncInfo(param);
	}

	@Override
	public void beforeDataSyncInfo(DataSyncInfo param) {
		DataSyncInfo temp = this.getDataSyncInfo(param);
		param.setInsert(temp == null ? true : false); 
		param.setLastSyncDate(temp == null ? DateUtil.getDateByString("20000101", DateUtil.Format.YYYYMMDD.getValue()) : temp.getLastSyncDate());
	}

	@Override
	public void afterDataSyncInfo(DataSyncInfo param) {
		param.setLastSyncDate(DateUtil.getNow());
		if (param.isInsert()) {
			this.addDataSyncInfo(param);
		} else {
			this.modifyDataSyncInfo(param);
		}
	}

	@Override
	public boolean isValidInterfaceDate(String type) {
		Date startDate = null;
		Date endDate = null;
		if ("cutover".equals(type)){
			startDate = DateUtil.getDateByString(this.interfaceDate.getCutoverStartDate(), DateUtil.Format.YYYY_MM_DD.getValue());
			endDate  = DateUtil.getDateByString(this.interfaceDate.getCutoverEndDate(), DateUtil.Format.YYYY_MM_DD.getValue());
		} else {
			startDate = DateUtil.getDateByString(this.interfaceDate.getDefectStartDate(), DateUtil.Format.YYYY_MM_DD.getValue());
			endDate  = DateUtil.getDateByString(this.interfaceDate.getDefectEndDate(), DateUtil.Format.YYYY_MM_DD.getValue());
		}
		
		return DateUtil.isBetweenDate(startDate, endDate, DateUtil.getNow());
	}
	
	private IntUser getIntUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext != null ) {
			Authentication authentication = securityContext.getAuthentication();
			if (authentication != null) {
				if (authentication.getDetails() != null) {
					try {
						UserDetail userDetail = (UserDetail) authentication.getDetails();
						IntUser intUser = userDetail.getIntUser();
						return intUser;
					} catch (Exception e) {
						return null;
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isSuperAmin() {
		IntUser intUser = this.getIntUser();
		if (intUser != null && intUser.getAuthorityList() != null && !intUser.getAuthorityList().isEmpty()) {
			for (GrantedAuthority obj : intUser.getAuthorityList()) {
				if ("ROLE_SUPER".equals(obj.getAuthority())) 
					return true;
			}
		}
		return false;
	}

	@Override
	public String getSessionUserId() {
		IntUser intUser = this.getIntUser();
		if (intUser != null) {
			return intUser.getUserId();
		}
		return null;
	}

	@Override
	public boolean isAccessPossible() {
		IntUser intUser = this.getIntUser();
		if (intUser != null) {
			return intUser.isAccess();
		}
		return false;
	}

	@Override
	public String getSessionUserName() {
		IntUser intUser = this.getIntUser();
		if (intUser != null) {
			return intUser.getUserName();
		}
		return null;
	}

	@Override
	public boolean isAdmin() {
		IntUser intUser = this.getIntUser();
		if (intUser != null && intUser.getAuthorityList() != null && !intUser.getAuthorityList().isEmpty()) {
			for (GrantedAuthority obj : intUser.getAuthorityList()) {
				if ("ROLE_SUPER".equals(obj.getAuthority())
						|| "ROLE_ADMIN".equals(obj.getAuthority())) 
					return true;
			}
		}
		return false;
	}


	@Override
	public DataSyncInfo getInterfaceDate() {
		return this.interfaceDate;
	}


	@Override
	public boolean isIntegrationDeveloper(String id) {
		return developerData.containsKey(id);
	}


	@Override
	public boolean isPermitExternalUrl(String category) {
		return this.permitUrls.containsKey(category);
	}


	@Override
	public boolean isCutOverAdmin() {
		IntUser intUser = this.getIntUser();
		if (intUser != null && intUser.getAuthorityList() != null && !intUser.getAuthorityList().isEmpty()) {
			for (GrantedAuthority obj : intUser.getAuthorityList()) {
				if ("CUTOVER_JIRA_SYNC".equals(obj.getAuthority())) 
					return true;
			}
		}
		return false;
	}


	

}
