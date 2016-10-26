package net.smart.web.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.smart.common.support.dao.SmartSqlSessionDaoSupport;
import net.smart.web.domain.resource.Resource;
import net.smart.web.domain.resource.ResourceRole;
import net.smart.web.domain.role.Role;

@Repository
public class RoleDaoImpl extends SmartSqlSessionDaoSupport implements RoleDao {

	@Override
	public List<Role> getRoleList(Role param) {
		return getSqlSession().selectList("resource.selecteRoleList", param);
	}

	@Override
	public void removeRole(List<Role> params) {
		for (Role param : params) {
			getSqlSession().delete("resource.deleteRole", param);
		}
	}

	@Override
	public void modifyRole(Role param) {
		getSqlSession().update("resource.updateRole", param);
	}

	@Override
	public void addRole(Role param) {
		getSqlSession().update("resource.insertRole", param);
	}

	@Override
	public List<ResourceRole> getResourceRoleList() {
		return getSqlSession().selectList("resource.selectResourceRoleList", new ResourceRole());
	}

	@Override
	public List<Role> getRoleInUserList(Role param) {
		return getSqlSession().selectList("resource.selectRoleInUserList", param);
	}

	@Override
	public List<Resource> getRoleAuthList(Resource param) {
		return getSqlSession().selectList("resource.selectRoleAuthList", param);
	}

	@Override
	public List<Resource> getServiceAuthList(Resource param) {
		return getSqlSession().selectList("resource.selectServiceAuthList", param);
	}

	@Override
	public void mergeAuth(List<Resource> params) {
		for (Resource param : params) {
			getSqlSession().update("resource.mergeAuth", param);
		}
	}

	@Override
	public void removeAuth(List<Resource> params) {
		for (Resource param : params) {
			getSqlSession().delete("resource.deleteAuth", param);
		}
	}

	@Override
	public void removeRoleUser(List<Role> params) {
		for (Role param : params) {
			getSqlSession().delete("resource.deleteRoleUser", param);
		}
	}

	@Override
	public void saveRoleUser(Role param) {
		getSqlSession().insert("resource.insertRoleUser", param);
	}

}
