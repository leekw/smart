package net.smart.web.code.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.smart.common.support.dao.SmartSqlSessionDaoSupport;
import net.smart.web.domain.CommonCode;

@Repository
public class CodeDaoImpl extends SmartSqlSessionDaoSupport  implements CodeDao {

	@Override
	public void addCode(List<CommonCode> params) {
		for (CommonCode code : params) {
			getSqlSession().update("code.mergeCode", code);
		}
	}

	@Override
	public List<CommonCode> getCodeList(CommonCode param) {
		return getSqlSession().selectList("code.selectCodeList", param);
	}

}
