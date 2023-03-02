package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//Controller 진입전
		// return이 true라면 다음 Controller로 진행
		// return이 true라면 다음 Controller로 진행 X
		System.out.println("MemberCheck Interceptor");
		
		Object obj=request.getSession().getAttribute("member");
		
		if(obj != null) {
			return true;
		}
		System.out.println("로그인 안한 경우");
//		//1.Forward Jsp
//		request.setAttribute("result", "권한이 없습니다");
//		request.setAttribute("url", "../member/memberLogin");
//		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/view/qna/list");
//		view.forward(request, response);
//		return false;
		
		//2. Redirect
		response.sendRedirect("../../../../../memeber/memberLogin");
		
		return false;
		
//		System.out.println("Controller 진입 전 체크");
//		response.sendRedirect("");
//		return true;
	}
	

	
	

}