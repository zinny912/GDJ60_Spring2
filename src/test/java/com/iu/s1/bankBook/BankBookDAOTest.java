package com.iu.s1.bankBook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.getBankBookList(null);
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
		
		for(int i=0; i<30; i++) {
			Random r = new Random();
			double d = r.nextDouble();//0.1234
			int num =(int)d*1000;//123
			d=num/100.0;
		
		r.nextDouble();
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("부자은행"+i);
		bankBookDTO.setBookRate(d);
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("부자부자부자"+i);
			
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		}
		//assertEquals(1, result);
		
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

