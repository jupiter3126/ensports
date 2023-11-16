package com.ensport.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.vo.Member;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter({"/myPage.me", "/update.me", "/delete.me"})
//@WebFilter("*.bo")	// 뒤에 .bo가 붙은 모든 url 필터링
@WebFilter("*.me")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//HttpServletRequest로 다운캐스팅하기
		HttpSession session = ((HttpServletRequest/*다운캐스팅을 해서 getSession()으로 세션 가져오기*/)request).getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(loginUser != null) {	//로그인이 되어있다면
			//요청을 그대로 유지함
			chain.doFilter(request, response);	//chain: 요청의 흐름을 그대로 유지시켜주는 객체
			
		}else {	//로그인이 되어있지 않다면
			//흐름을 바꿔주는 작업처리
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다. 로그인 후 이용해 주세요");
			
			//request, response 다운캐스팅하여 sendRedirect
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/login.do");
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
