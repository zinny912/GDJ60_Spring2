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
		
		@RequestMapping(value = "memberAgree", method=RequestMethod.GET)
		public void setMemberAgree()throws Exception{
			
		}
		
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
			if(memberDTO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDTO);
			}

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
		
		//controller에 있는 메서드를 호출하는 DS
		//마이페이지
		@RequestMapping(value="memberPage", method=RequestMethod.GET)
		public ModelAndView getMemberPage(HttpSession session)throws Exception{
			ModelAndView mv = new ModelAndView();
			//Object여서 다형성으로 형변환 진행해줘야함
			MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
			//DTO에 새로운 주소가 들어오는 거지 memberService.getMemberPage의 정보가 들어가는게 아님
			memberDTO=memberService.getMemberPage(memberDTO);
			mv.addObject("dto",memberDTO);
			mv.setViewName("member/memberPage");
			return mv;
		}
		
		//정보수정
		@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
		public ModelAndView getMemberUpdate(HttpSession session) throws Exception{
			ModelAndView mv = new ModelAndView();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			
			memberDTO = memberService.getMemberPage(memberDTO);
			mv.addObject("dto",memberDTO);
			mv.setViewName("member/memberUpdate");
			return mv;
		}
		
		//정보수정 리다이렉트
		@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
		public ModelAndView getMemberUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
			ModelAndView mv = new ModelAndView();
			
			MemberDTO sessionMemberDTO =(MemberDTO)session.getAttribute("member");
			memberDTO.setId(sessionMemberDTO.getId());
			int result = memberService.setMemberUpdate(memberDTO); //업데이트 성공여부 확인
//			if(result>0) {
//				session.setAttribute("member", memberDTO);
//			}
			
			mv.setViewName("redirect:./memberPage");
		
			return mv;
		}

	} 