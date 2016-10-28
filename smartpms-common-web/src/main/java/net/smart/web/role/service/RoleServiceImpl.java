package net.smart.web.role.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import net.smart.web.domain.resource.Resource;
import net.smart.web.domain.resource.ResourceRole;
import net.smart.web.domain.role.Role;
import net.smart.web.resource.service.ResourceService;
import net.smart.web.role.dao.RoleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ResourceService resourceService;
	
	private Map<String, Map<String, ResourceRole>> resourceRoleData;
	
	private AtomicInteger sync = new AtomicInteger(0);
	
	@PostConstruct
	public void init(){
		if (resourceRoleData == null) {
			resourceRoleData = new HashMap<String, Map<String, ResourceRole>>();
			synchronized(sync){
				resourceRoleData = this.getCacheResourceRole();
			}
		}
	}
	
	@Override
//	@Scheduled(cron="0 0/1 * * * ? ")
	public void modifyCacheResourceRole() {
		synchronized(sync){
			resourceRoleData.clear();
			resourceRoleData = this.getCacheResourceRole();
		}
	}
	
	private Map<String, Map<String, ResourceRole>> getCacheResourceRole() {
		Map<String, Map<String, ResourceRole>> result = new HashMap<String, Map<String, ResourceRole>>();
		List<ResourceRole> temps = roleDao.getResourceRoleList();
		for (ResourceRole obj : temps) {
			String key = this.getResourceKey(obj);
			Map<String, ResourceRole> resource = result.get(obj.getRoleId());
			if (resource == null) {
				resource = new HashMap<String, ResourceRole>();
				result.put(obj.getRoleId(), resource);
			}
			resource.put(key, obj);
		}
		return result;
	}
	
	private String getResourceKey(ResourceRole param) {
		if (param.getResourceType().equals("MENU")
				|| param.getResourceType().equals("IMAGE")) {
			return param.getResourceId();
		} else if(param.getResourceType().equals("PAGE")) {
			return param.getUrl();
		} else if (param.getResourceType().equals("CONTENT")) {
			return param.getUrl();
		}
		return null;
	}

	@Override
	public List<Role> getRoleList(Role param) {
		return roleDao.getRoleList(param);
	}

	@Override
	@Transactional
	public void saveRole(Role param) {
		if (param.getMode() != null && param.getMode().equals("R")) {
			roleDao.modifyRole(param);
		} else {
			roleDao.addRole(param);
			ResourceRole defaultRole = new ResourceRole();
			defaultRole.setRoleId(param.getRoleId());
			defaultRole.setResourceId("RE_00013");
			defaultRole.setIncludeYn("Y");
			resourceService.addResourceRole(defaultRole);
			defaultRole = new ResourceRole();
			defaultRole.setRoleId(param.getRoleId());
			defaultRole.setResourceId("RE_00014");
			defaultRole.setIncludeYn("Y");
			resourceService.addResourceRole(defaultRole);
		}
	}

	@Override
	public void removeRole(Role param) {
		List<Role> params = new ArrayList<Role>();
		params.add(param);
		roleDao.removeRole(params);
	}

	@Override
	public List<ResourceRole> getInlcudeResourceRoleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceRole> getExcludeResourceRoleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPermitResource(String roleId, String checkData) {
		Map<String, ResourceRole> data = resourceRoleData.get(roleId);
		if (data == null || data.isEmpty()) return false;
		ResourceRole result = data.get(checkData);
		return data != null && !data.isEmpty() ?  (result == null ? false : (result.isExclude() ? false : true)) : false ;
	}

	@Override
	public boolean isPermitResource(List<String> roles, String checkData) {
		boolean isPermit = false;
		for (String role : roles ) {
			isPermit = this.isPermitResource(role, checkData);
			if (isPermit) return true; 
		}
		return isPermit;
	}

	@Override
	public List<Role> getRoleInUserList(Role param) {
		return roleDao.getRoleInUserList(param);
	}

	@Override
	public List<Resource> getRoleAuthList(Resource param) {
		param.setParentResourceId("TOP");
		List<Resource> results = roleDao.getRoleAuthList(param);
		param.setParentResourceId("TOP2");
		List<Resource> temps = roleDao.getRoleAuthList(param);
		results.addAll(temps);		
		return results;
	}

	@Override
	public List<Resource> getServiceAuthList(Resource param) {
		return roleDao.getServiceAuthList(param);
	}

	@Override
	@Transactional
	public void saveAuth(List<Resource> params) {
		List<Resource> delList = new ArrayList<Resource>();
		List<Resource> modList = new ArrayList<Resource>();
		for (Resource obj : params) {
			if (!obj.isExclude() && !obj.isInclude()) {
				delList.add(obj);
			} else {
				if (obj.isExclude()) {
					obj.setIncludeYn("N");
				} else {
					obj.setIncludeYn("Y");
				}
				modList.add(obj);
			}
		}
		
		roleDao.mergeAuth(modList);
		roleDao.removeAuth(delList);
		
	}

	@Override
	@Transactional
	public void removeRoleUser(List<Role> params) {
		roleDao.removeRoleUser(params);
	}

	@Override
	public void saveRoleUser(Role param) {
		roleDao.saveRoleUser(param);
	}

}
