package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	@RequestMapping("/member/**")
	public class MemberController {
		
		@Autowired
		private MemberService memberService;
		
		//회원가입
		@RequestMapping(value = "memberAdd", method = RequestMethod.GET)
		public ModelAndView setMemberAdd()throws Exception{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/member/memberAdd");
			return mv;
		}
		
		//회원가입 홈으로 리다이렉트
		@RequestMapping(value = "memberAdd", method = RequestMethod.POST)
		public ModelAndView setMemberAdd(MemberDTO memberDTO)throws Exception{
			ModelAndView mv = new ModelAndView();
			int result = memberService.setMemberAdd(memberDTO);
			mv.setViewName("redirect:../");
			return mv;
		}
		
		//로그인
		@RequestMapping(value="memberLogin", method = RequestMethod.GET)
		public ModelAndView getMemberLogin() throws Exception{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("member/memberLogin");
			return mv;
		}
		//로그인 리다이렉트
		@RequestMapping(value="memberLogin", method = RequestMethod.POST)
		public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request) throws Exception{
			ModelAndView mv = new ModelAndView();
			memberDTO = memberService.getMemberLogin(memberDTO);
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
			return mv;
		
		}
		
		//로그아웃
		@RequestMapping(value="memberLogout", method=RequestMethod.GET)
		public ModelAndView getMemberLogout(HttpSession session)throws Exception{
			ModelAndView mv = new ModelAndView();
			session.invalidate();
			mv.setViewName("redirect:../");
			return mv;
		}
		
		//마이페이지
		@RequestMapping(value="memberPage", method=RequestMethod.GET)
		public ModelAndView getMemberPage()throws Exception{
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("member/memberPage");
			return mv;
		}
		
		//정보수정
		@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
		public ModelAndView setMemberUpdate() throws Exception{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("member/memberUpdate");
			return mv;
		}
		
		//정보수정 리다이렉트
		@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
		public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
			ModelAndView mv = new ModelAndView();
			
			MemberDTO sessionMemberDTO =(MemberDTO)session.getAttribute("member");
			memberDTO.setId(sessionMemberDTO.getId());
			int result = memberService.setMemberUpdate(memberDTO); //업데이트 성공여부 확인
			if(result>0) {
				session.setAttribute("member", memberDTO);
			}
			mv.setViewName("redirect:./memberPage");
		
			return mv;
		}

	} 