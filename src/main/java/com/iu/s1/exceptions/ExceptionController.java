package com.iu.s1.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//예외를 전문적으로 처리하는 메서드
@ControllerAdvice
public class ExceptionController {
	//프로젝트 내에서 발생하는 Exception은 전부 여기서 처리

	
		//NullPointException 발생시 처리하는 클래스 - 클라이언트에게 에러메세지 안보이게 하기 위한 목적
		@ExceptionHandler(NullPointerException.class)
		public ModelAndView fixException() {
			ModelAndView mv = new ModelAndView();
			mv.addObject("message", "잘못된 접근입니다. <br> 관리자에게 문의하세요!");
			mv.setViewName("common/error_500");
			return mv;
		}
		
		@ExceptionHandler(Exception.class)
		public ModelAndView fix2Exception() {
			ModelAndView mv = new ModelAndView();
			mv.addObject("message", "잘못된 접근입니다. <br> 관리자에게 문의하세요!");
			mv.setViewName("common/error_500");
			return mv;
		}
		
	
}
