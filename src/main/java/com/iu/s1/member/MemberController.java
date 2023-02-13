package com.iu.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankBook.BankBookDTO;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	
	//add form 이동
	@RequestMapping(value = "Join", method = RequestMethod.GET)
	public ModelAndView setMemberJoin(ModelAndView mv) throws Exception{
		mv.setViewName("memeber/memberJoin");
		return mv;
	}
		
	//add DB Insert
	@RequestMapping(value = "Join", method = RequestMethod.POST)
	public ModelAndView setMemberJoin(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
					
		mv.setViewName("redirect:./list");
			
		return mv;
	}

}
