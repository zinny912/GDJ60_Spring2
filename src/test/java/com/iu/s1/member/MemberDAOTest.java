package com.iu.s1.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	@Test
	public void setMemberAdd() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("석구석구");
		memberDTO.setPw("1234");
		memberDTO.setName("손석구");
		memberDTO.setAddress("서울");
		memberDTO.setPhone("010-1234-1234");
		memberDTO.setEmail("SeockGu@naver.com");
		
		int result = memberDAO.memberJoin(memberDTO);
		
		assertEquals(1, result);
	}

}
