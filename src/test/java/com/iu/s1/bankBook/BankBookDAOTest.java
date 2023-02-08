package com.iu.s1.bankBook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
			
		assertEquals(0, ar.size());
	}
	
	@Test
	public void getBankBookDetailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1L);
		bankBookDTO= bankBookDAO.getBankBookDetail(bankBookDTO);
		
		assertNotNull(bankBookDTO);
	}
	@Test	
	public void setBankBookAddTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(120L);
		bankBookDTO.setBookName("부자통장");
		bankBookDTO.setBookRate(4.1);
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("부자되세요");
		
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		assertEquals(1, result);
		
	}
		
}

