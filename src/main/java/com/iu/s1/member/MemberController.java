package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDTO memberDTO;
	
	@RequestMapping(value = "memberJoin")
	public String setMemberJoin() throws Exception {
		memberService.memberJoin(memberDTO);
		
		System.out.println("JOIN");
		
		return "member/memberJoin";
	}
	
	@RequestMapping(value = "memberLogin")
	public void setMemberLogin() {
		
	}
	
	@RequestMapping(value = "memberPage")
	public ModelAndView setMemberPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		
		return mv;
		
	}
}
