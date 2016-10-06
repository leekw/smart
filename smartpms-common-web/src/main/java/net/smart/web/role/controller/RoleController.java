package net.smart.web.role.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.smart.common.annotation.IntegrationRequest;
import net.smart.common.annotation.IntegrationResponse;
import net.smart.web.domain.resource.Resource;
import net.smart.web.domain.role.Role;
import net.smart.web.role.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/role/list/get.{metadataType}", method = RequestMethod.POST)
	@IntegrationResponse(key="roles")
	public List<Role> getRoleList(@IntegrationRequest Role param) {	
		return roleService.getRoleList(param);
	}
	@RequestMapping(value = "/role/save.{metadataType}", method = RequestMethod.POST)
	public void saveRole(@IntegrationRequest Role param) {
		roleService.saveRole(param);
	}
	
	@RequestMapping(value = "/role/remove.{metadataType}", method = RequestMethod.POST)
	public void removeRole(@IntegrationRequest Role param) {
		roleService.removeRole(param);
	}

	
	@RequestMapping(value = "/role/user/list/get.{metadataType}", method = RequestMethod.POST)
	@IntegrationResponse(key="data")
	public Map<String, Object> getRoleUserList(@IntegrationRequest Role param) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Role> users =  roleService.getRoleInUserList(param);
		if (users != null && !users.isEmpty()) {
			result.put("users", users);
			result.put("total", users.get(0).getTotal());
		}
		return result;
	}
	
	@RequestMapping(value = "/role/auth/list/get.{metadataType}", method = RequestMethod.POST)
	@IntegrationResponse(key="resources")
	public List<Resource> getRoleAuthList(@IntegrationRequest Resource param) {	
		return roleService.getRoleAuthList(param);
	}
	
	@RequestMapping(value = "/service/auth/list/get.{metadataType}", method = RequestMethod.POST)
	@IntegrationResponse(key="resources")
	public List<Resource> getServiceAuthList(@IntegrationRequest Resource param) {	
		return roleService.getServiceAuthList(param);
	}
	
	@RequestMapping(value = "/role/auth/save.{metadataType}", method = RequestMethod.POST)
	public void saveAuth(@IntegrationRequest List<Resource> params) {
		roleService.saveAuth(params);
	}
	
	@RequestMapping(value = "/role/user/remove.{metadataType}", method = RequestMethod.POST)
	public void removeRoleUser(@IntegrationRequest List<Role> params) {
		roleService.removeRoleUser(params);
	}
	
	@RequestMapping(value = "/role/user/save.{metadataType}", method = RequestMethod.POST)
	public void saveRoleUser(@IntegrationRequest Role param) {
		roleService.saveRoleUser(param);
	}
	
	
}
