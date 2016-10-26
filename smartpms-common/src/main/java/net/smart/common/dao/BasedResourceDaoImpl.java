package net.smart.common.dao;

import java.util.List;

import net.smart.common.domain.based.BasedOrg;
import net.smart.common.domain.based.BasedOrgRel;
import net.smart.common.domain.based.BasedRole;
import net.smart.common.domain.based.BasedUser;
import net.smart.common.support.dao.BasedSqlSessionDaoSupport;

import org.springframework.stereotype.Repository;

@Repository
public class BasedResourceDaoImpl extends BasedSqlSessionDaoSupport implements BasedResourceDao {

	@Override
	public List<BasedUser> getUserList(BasedUser param) {
		return getSqlSession().selectList("based.selectUserList", param);
	}

	@Override
	public List<BasedRole> getRoleList(BasedRole param) {
		return getSqlSession().selectList("based.selectRoleList", param);
	}

	@Override
	public List<BasedOrg> getOrgList(BasedOrg param) {
		return getSqlSession().selectList("based.selectOrgList", param);
	}

	@Override
	public List<BasedOrgRel> getOrgRelationList(BasedOrgRel param) {
		return getSqlSession().selectList("based.selectOrgRelationList", param);
	}

}
