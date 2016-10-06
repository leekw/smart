package net.smart.web.role.service;

import java.util.List;

import net.smart.web.domain.resource.Resource;
import net.smart.web.domain.resource.ResourceRole;
import net.smart.web.domain.role.Role;


public interface RoleService {
	
	public List<Role> getRoleList(Role param);
	
	public void saveRole(Role param);
	
	public void removeRole(Role param);
	
	public void modifyCacheResourceRole();
	
	public List<ResourceRole> getInlcudeResourceRoleList();
	
	public List<ResourceRole> getExcludeResourceRoleList();
	
	public boolean isPermitResource(List<String> roles, String checkData);
	
	public boolean isPermitResource(String roleId, String checkData);
	
	public List<Role> getRoleInUserList(Role param);
	
	public List<Resource> getRoleAuthList(Resource param);
	
	public List<Resource> getServiceAuthList(Resource param);
	
	public void saveAuth(List<Resource> params);
	
	public void removeRoleUser(List<Role> params);
	
	public void saveRoleUser(Role param);

}
