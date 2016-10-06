package net.smart.web.notice.dao;

import java.util.List;

import net.smart.common.support.dao.IntegrationSqlSessionDaoSupport;
import net.smart.web.domain.MailGroup;
import net.smart.web.domain.MailQueue;
import net.smart.web.domain.notice.Notice;

import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDaoImpl  extends IntegrationSqlSessionDaoSupport  implements NoticeDao {

	@Override
	public List<Notice> getNoticeList(Notice param) {
		return getSqlSession().selectList("notice.selectNoticeList", param);
	}

	@Override
	public void addNotice(Notice param) {
		getSqlSession().insert("notice.insertNotice", param);
	}

	@Override
	public List<MailGroup> getMailGroupList() {
		return getSqlSession().selectList("notice.selectMailGroupList");
	}

	@Override
	public void modifyNotice(Notice param) {
		getSqlSession().update("notice.updateNotice", param);
	}

	@Override
	public void addMailQueue(MailQueue param) {
		getSqlSession().insert("notice.insertMailQueue", param);
	}

	@Override
	public List<MailQueue> getMailQueueList() {
		return getSqlSession().selectList("notice.selectMailQueueList");
	}

	@Override
	public void mofityMailQueue(MailQueue param) {
		getSqlSession().update("notice.updateMailQueue", param);
	}

	@Override
	public void modifyMailGroup(MailGroup param) {
		getSqlSession().update("notice.updateMailGroup", param);
	}

	@Override
	public void removeNotice(List<Notice> params) {
		for (Notice param : params) {
			getSqlSession().delete("notice.deleteNotice", param);
		}
	}

}
