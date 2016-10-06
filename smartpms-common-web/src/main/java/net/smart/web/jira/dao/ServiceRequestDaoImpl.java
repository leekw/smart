package net.smart.web.jira.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.smart.common.support.dao.PmssRealSqlSessionDaoSupport;
import net.smart.web.domain.jira.ServiceRequest;

@Repository
public class ServiceRequestDaoImpl extends PmssRealSqlSessionDaoSupport implements ServiceRequestDao {

	@Override
	public List<ServiceRequest> getServiceRequestList(ServiceRequest param) {
		return getSqlSession().selectList("jira.selectServiceRequestProgramList", param);
	}

}
