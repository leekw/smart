package net.smart.common.dao;

import java.util.List;

import net.smart.common.domain.based.BasedResource;
import net.smart.common.domain.based.BasedResourceRole;
import net.smart.common.domain.based.Role;

public interface RoleDao {
	
	public List<Role> getRoleList(Role param);
	
	public void removeRole(List<Role> params);
	
	public void modifyRole(Role param);
	
	public void addRole(Role param);
	
	public List<BasedResourceRole> getResourceRoleList();
	
	public List<Role> getRoleInUserList(Role param);
	
	public List<BasedResource> getRoleAuthList(BasedResource param);
	
	public List<BasedResource> getServiceAuthList(BasedResource param);
	
	public void mergeAuth(List<BasedResource> params);
	
	public void removeAuth(List<BasedResource> params);
	
	public void removeRoleUser(List<Role> params);
	
	public void saveRoleUser(Role param);

}
