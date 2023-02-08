package com.iu.s1.bankBook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		System.out.println(ar.size()>0);
			
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getBankBookDetailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(111L);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		
		assertNull(bankBookDTO);
	
	}
	@Test	
	public void setBankBookAddTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1111L);
		bankBookDTO.setBookName("부자통장2");
		bankBookDTO.setBookRate(5.70);
		bankBookDTO.setBookSale(0);
		bankBookDTO.setBookDetail("부자되세요");
		
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		assertEquals(1, result);
		
	}
//	@Test
//	public void setBankBookDeleteTest() throws Exception{
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.getBookNumber();
//		
//		int result = bankBookDAO.setBankBookDelete(bankBookDTO);
//		
//		assertEquals(1, result);
//	}
		
}

