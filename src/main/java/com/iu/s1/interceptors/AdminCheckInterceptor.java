package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;


public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	//ROLE이 Admin이면 통과
	//그외 나머지는 home.jsp로 보낸다
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		MemberDTO memberDTO =(MemberDTO)request.getSession().getAttribute("member");
		if(memberDTO != null) {
			if(memberDTO.getRoleDTOs().getRoleName().equals("ADMIN")) {
				return true;
			}	
		}
		//로그인 x
		//Admin이 아닌 경우
		request.setAttribute("result", "권한이 충분하지 않아요");
		request.setAttribute("url", "../../../../");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
