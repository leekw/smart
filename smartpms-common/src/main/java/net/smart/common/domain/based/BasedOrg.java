package net.smart.common.domain.based;

import net.smart.common.domain.Common;

public class BasedOrg extends Common {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1582545533339929628L;
	
	private String orgId;
	private String orgName;
	private String orgType;
	private String orgDetailType;
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getOrgDetailType() {
		return orgDetailType;
	}
	public void setOrgDetailType(String orgDetailType) {
		this.orgDetailType = orgDetailType;
	}

}
