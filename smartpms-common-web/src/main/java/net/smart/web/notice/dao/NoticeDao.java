package net.smart.web.notice.dao;

import java.util.List;

import net.smart.web.domain.MailGroup;
import net.smart.web.domain.MailQueue;
import net.smart.web.domain.notice.Notice;

public interface NoticeDao {
	
	public List<Notice> getNoticeList(Notice param);
	
	public void addNotice(Notice param);
	
	public void modifyNotice(Notice param);
	
	public void removeNotice(List<Notice> params);
	
	public List<MailGroup> getMailGroupList();
	
	public void addMailQueue(MailQueue param);
	
	public List<MailQueue> getMailQueueList();
	
	public void mofityMailQueue(MailQueue param);
	
	public void modifyMailGroup(MailGroup param);

}
