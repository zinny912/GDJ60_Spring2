package com.iu.s1.board.notice;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase {
	
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void getNoticeListTest()throws Exception{
		Pager pager = new Pager();
		
		pager.setKind("writer");
	
		pager.setSearch("흐어엉");
		
		long count = noticeDAO.getTotalCount(pager);
		
		assertNotEquals(0, count);
	}
	
}
