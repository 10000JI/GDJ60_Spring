package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(memberDTO.getRoleDTOs().getRoleName() != "ADMIN") {
			return true;
		}
		request.setAttribute("result", "권한이 충분하지 않아요");
		request.setAttribute("url","../../../member/memberLogin");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
		return false;
	}
}
