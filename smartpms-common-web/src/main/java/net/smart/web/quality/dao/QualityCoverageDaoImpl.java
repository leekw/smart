package net.smart.web.quality.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.smart.common.support.dao.CoverageSqlSessionDaoSupport;
import net.smart.web.domain.quality.QualityCoverage;

@Repository
public class QualityCoverageDaoImpl extends CoverageSqlSessionDaoSupport implements QualityCoverageDao  {

	@Override
	public List<QualityCoverage> getCodeCoverageDataAll(QualityCoverage param) {
		return getSqlSession().selectList("quality.selectQulaityOperationCoverageList", param);
	}

}
