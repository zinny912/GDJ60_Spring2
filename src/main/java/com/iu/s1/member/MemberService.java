package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
//	
//	public int memberJoin(MemberDTO memberDTO) throws Exception {
//		
//		memberDTO.setId("aaaa");
//		memberDTO.setPw("aaaa");
//		memberDTO.setName("aaaa");
//		memberDTO.setAddress("aaaa");
//		memberDTO.setPhone("aaaa");
//		memberDTO.setEmail("aaaa");
//		
//		int result = memberDAO.memberJoin(memberDTO);
//		
//		if(result>0) {
//			System.out.println(result==1);
//		}
//		
//		return result;	
//		
//	}
	
}


