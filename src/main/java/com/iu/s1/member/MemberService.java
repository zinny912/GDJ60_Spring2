package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  

@Service
public class MemberService {
   
   @Autowired
   private MemberDAO memberDAO;
   
   public int setMemberAdd(MemberDTO memberDTO) throws Exception {
      
      int result = memberDAO.setMemberAdd(memberDTO);
      result = memberDAO.setMemberRoleAdd(memberDTO);
      return result;
   }
   //로그인
   public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
	   return memberDAO.getMemberLogin(memberDTO);

   }
   //마이페이지
   public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception{
	   
	   return memberDAO.getMemberPage(memberDTO);
   }
   
   //정보수정
   public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
	   int result = memberDAO.setMemberUpdate(memberDTO);
	   return result; 
   }

}

