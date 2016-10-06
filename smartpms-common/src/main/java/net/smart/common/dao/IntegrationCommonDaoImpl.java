package net.smart.common.dao;

import java.util.List;
import java.util.Map;

import net.smart.common.domain.DataSyncInfo;
import net.smart.common.support.dao.IntegrationSqlSessionDaoSupport;

import org.springframework.stereotype.Repository;

@Repository("integrationCommonDao")
public class IntegrationCommonDaoImpl extends IntegrationSqlSessionDaoSupport  implements IntegrationCommonDao {

	@Override
	public Integer getLimitConnectionCount() {
		return getSqlSession().selectOne("int.selectLimitConnectionCount");
	}

	@Override
	public Map<String, String> getMainResourceInfo() {
		return getSqlSession().selectOne("int.selectMainResourceInfo");
	}

	@Override
	public DataSyncInfo getDataSyncInfo(DataSyncInfo param) {
		return getSqlSession().selectOne("int.selecDataSyncInfo", param);
	}

	@Override
	public void modifyDataSyncInfo(DataSyncInfo param) {
		getSqlSession().update("int.updateDataSyncInfo", param);
	}

	@Override
	public void addDataSyncInfo(DataSyncInfo param) {
		getSqlSession().insert("int.insertDataSyncInfo", param);
	}

	@Override
	public DataSyncInfo getInterfaceDateInfo() {
		return getSqlSession().selectOne("int.selectInterfaceDateInfo");
	}

}
