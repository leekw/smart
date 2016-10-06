package net.smart.common.service;

import java.util.Map;

import net.smart.common.domain.DataSyncInfo;


public interface IntegrationCommonService {
		
	public boolean isAdmin(String ip);
	
	public boolean isAdmin();
	
	public boolean isCutOverAdmin();
	
	public void setLimitConnectionCount();
	
	public int getLimitCount();
	
	public Map<String, String> getMainResourceInfo();
	
	public DataSyncInfo getInterfaceDate();
	
	public DataSyncInfo getDataSyncInfo(DataSyncInfo param);
	
	public void modifyDataSyncInfo(DataSyncInfo param);
	
	public void addDataSyncInfo(DataSyncInfo param);
	
	public void beforeDataSyncInfo(DataSyncInfo param);
	
	public void afterDataSyncInfo(DataSyncInfo param);
	
	public boolean isValidInterfaceDate(String type);
	
	public boolean isSuperAmin();
	
	public String getSessionUserId();
	
	public String getSessionUserName();
	
	public boolean isAccessPossible();
	
	public String getSystemDeployVersion();
	
	public boolean isIntegrationDeveloper(String id);
	
	public boolean isPermitExternalUrl(String category);
	
}
