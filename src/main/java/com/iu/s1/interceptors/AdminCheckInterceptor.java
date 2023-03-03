package com.iu.s1.interceptors;

import java.net.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	//Role이 Admin이면 통과 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		MemberDTO memberDTO =(MemberDTO)request.getSession().getAttribute("member");
	
		
		if(memberDTO!=null) {
			if(memberDTO.getRoleDTO().getRoleName().equals("ADMIN")) {
				return true;
			}
	}	
		System.out.println("로그인 안함");
		//로그인X, ADMIN이 아닌 경우
		request.setAttribute("result", "권한이 없다");
		request.setAttribute("url", "../../../../../");
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
		return false;
	}
	
}
