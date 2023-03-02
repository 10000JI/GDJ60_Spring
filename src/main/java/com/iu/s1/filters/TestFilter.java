package com.iu.s1.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter
 */
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 해당 필터 객체가 소멸 시 실행되는 메서드
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("TestFilter In");
		
		HttpServletRequest req = (HttpServletRequest) request;
		Object obj = req.getSession().getAttribute("member");
		
		req.getRequestURI(); // /qna/list
		
		if(obj!=null) {
			//다음 필터가 있으면 다음 필터로 이동하고, 없으면 DispatcherServlet으로 이동
			chain.doFilter(request, response);			
		}else {
			//redirect 방식
			//HttpServletResponse res = (HttpServletResponse) response;
			//res.sendRedirect("../member/memberLogin");
			
			//foward 방식
			request.setAttribute("result", "권한이 없습니다.");
			request.setAttribute("url", "../member/memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		
		//응답 시 실행 되는 영역
		System.out.println("TestFilter Out");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Filter 객체가 생성 시 실행되는 메서드
	}

}
