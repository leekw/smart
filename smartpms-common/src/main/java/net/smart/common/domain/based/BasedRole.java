package net.smart.common.domain.based;

import net.smart.common.domain.Common;

public class BasedRole extends Common {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8911031757592427760L;
	private String targetId;
	private String roleId;
	private String relationType;
	
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
