package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.bankBook.BankBookDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberJoin(MemberDTO memeberDTO) throws Exception{
		return memberDAO.setMemberJoin(memeberDTO);
	}
	
	
}
