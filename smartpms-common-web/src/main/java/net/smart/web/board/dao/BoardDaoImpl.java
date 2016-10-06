package net.smart.web.board.dao;

import java.util.List;

import net.smart.common.support.dao.IntegrationSqlSessionDaoSupport;
import net.smart.web.domain.CommonCode;
import net.smart.web.domain.board.Board;

import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDaoImpl extends IntegrationSqlSessionDaoSupport  implements BoardDao {

	@Override
	public List<Board> getBoardList(Board param) {
		return getSqlSession().selectList("board.selectBoardList", param);
	}

	@Override
	public void addBoard(Board param) {
		if (param.getBoardId() == 0) {
			param.setBoardId(this.getNextBoarId());
		}
		getSqlSession().insert("board.insertBoard", param);
	}

	@Override
	public void modifyBoard(Board param) {
		getSqlSession().update("board.updateBoard", param);
	}

	@Override
	public void removeBoard(Board param) {
		getSqlSession().delete("board.deleteBoard", param);
	}

	@Override
	public List<CommonCode> getTeamList() {
		return getSqlSession().selectList("board.selectTeamList") ;
	}

	@Override
	public Integer getNextBoarId() {
		return getSqlSession().selectOne("board.selectNextBoardId") ;
	}

}