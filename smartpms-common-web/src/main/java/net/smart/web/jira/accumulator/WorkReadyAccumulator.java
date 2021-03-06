package net.smart.web.jira.accumulator;

import org.springframework.stereotype.Service;

import net.smart.common.support.util.DateUtil;
import net.smart.web.domain.jira.Cutover;
import net.smart.web.domain.jira.CutoverDashboard;

@Service("workReadyAccumulator")
public class WorkReadyAccumulator extends AbstratAccumulator {

	@Override
	public boolean isVaild(Cutover param) {
		super.setTaskDateRange(param);
		if (param.getJiraStatus() != null 
				&& !"".equals(param.getJiraStatus()) 
				&& param.getJiraStatus().equals("작업대기")) {
			if (param.getStartDate().compareTo(DateUtil.getNow()) != -1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void accumulate(Cutover param, CutoverDashboard data) {
		data.setWorkReadyCount(data.getWorkReadyCount() + 1);
	}

	@Override
	public boolean isValidFilter(Cutover param, CutoverDashboard data) {
		super.setTaskDateRange(param);
		if (param.getJiraStatus() != null 
				&& !"".equals(param.getJiraStatus()) 
				&& param.getJiraStatus().equals("작업대기")
				&& (data.getMode() != null && "작업대기".equals(data.getMode()))) {
			if (param.getStartDate().compareTo(DateUtil.getNow()) != -1) {
				return true;
			}
		}
		return false;
	}

}
