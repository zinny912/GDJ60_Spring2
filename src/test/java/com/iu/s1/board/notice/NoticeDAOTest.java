package com.iu.s1.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase {
	
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void setBoardAddTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Title1");
		noticeDTO.setWriter("writer1");
		noticeDTO.setContents("contents1");
		int result = noticeDAO.setBoardAdd(noticeDTO);
		assertEquals(1, result);
	}
	
	
	
	public void getNoticeListTest()throws Exception{
		Pager pager = new Pager();
		
		long count = noticeDAO.getTotalCount(pager);	
		pager.setKind("writer");
	
		pager.setSearch("흐어엉");
		
		
		
		assertNotEquals(0, count);
	}
	
}
