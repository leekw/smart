package net.smart.common.dao;

import java.util.List;

import net.smart.common.domain.based.BasedOrg;
import net.smart.common.domain.based.BasedOrgRel;
import net.smart.common.domain.based.BasedRole;
import net.smart.common.domain.based.BasedUser;

public interface BasedResourceDao {
	
	public List<BasedUser> getUserList(BasedUser param);
	
	public List<BasedRole> getRoleList(BasedRole param);
	
	public List<BasedOrg> getOrgList(BasedOrg param);

	public List<BasedOrgRel> getOrgRelationList(BasedOrgRel param);
}
