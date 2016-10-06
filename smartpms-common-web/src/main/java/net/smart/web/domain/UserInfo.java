package net.smart.web.domain;

import java.util.List;

import net.smart.common.domain.Common;

public class UserInfo extends Common {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6594395545960017191L;
	
	private String userId;
	private String userPassword;
	private String ip;
	private String userName;
	private String emailAddress;
	private String team;
	private String active;
	private List<String> roles;
	private String accessYn;
	private boolean access;
	private String searchValue;
	
	
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public boolean isAccess() {
		return access;
	}
	public void setAccess(boolean access) {
		this.access = access;
	}
	public String getAccessYn() {
		return accessYn;
	}
	public void setAccessYn(String accessYn) {
		this.accessYn = accessYn;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
