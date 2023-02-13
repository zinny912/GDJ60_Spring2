package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	

	@Autowired
	private MemberService memberService;


	
	@RequestMapping (value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) {
		System.out.println("member join 입니다");
		try {
			memberService.memberJoin(memberDTO);
			System.out.println("불러오기 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "member/memberJoin";
	}
	
	
	@RequestMapping (value = "memberJoin", method = RequestMethod.GET)
	public void memberJoin() {
		System.out.println("member join입니다");
		
	}
	
	
	
	
	@RequestMapping(value = "memberLogin")
	public void memberLogin() {
		System.out.println("member login 입니다");
	}
	
	@RequestMapping(value = "page")
	public ModelAndView memberPage() {
		ModelAndView mv = new ModelAndView();
		System.out.println("member page 입니다");
		mv.setViewName("member/memberPage");
		return mv;
	}
}
