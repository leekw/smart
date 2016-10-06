package net.smart.web.role.dao;

import java.util.List;

import net.smart.web.domain.resource.Resource;
import net.smart.web.domain.resource.ResourceRole;
import net.smart.web.domain.role.Role;

public interface RoleDao {
	
	public List<Role> getRoleList(Role param);
	
	public void removeRole(List<Role> params);
	
	public void modifyRole(Role param);
	
	public void addRole(Role param);
	
	public List<ResourceRole> getResourceRoleList();
	
	public List<Role> getRoleInUserList(Role param);
	
	public List<Resource> getRoleAuthList(Resource param);
	
	public List<Resource> getServiceAuthList(Resource param);
	
	public void mergeAuth(List<Resource> params);
	
	public void removeAuth(List<Resource> params);
	
	public void removeRoleUser(List<Role> params);
	
	public void saveRoleUser(Role param);

}
