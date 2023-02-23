package com.iu.s1.bankBook;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BankBookCommentDAOTest extends MyTestCase{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	//list
	@Test
	public void getBoardListTest()throws Exception{
		Pager pager = new Pager();
		
		pager.setBookNumber(421L);
//		pager.setKind("writer");
//		pager.setSearch("석주");
		pager.makeRow();
//		long count = bankBookCommentDAO.getTotalCount(pager);
		
		List<BbsDTO> ar=bankBookCommentDAO.getBoardList(pager);
		
		//단정문 assert count 값이 0이 아니면 좋겠다
//		assertNotEquals(0, count);
		assertNotEquals(0, ar.size());
		
	}

}
