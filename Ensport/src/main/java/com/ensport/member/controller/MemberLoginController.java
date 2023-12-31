package com.ensport.member.controller;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.service.MemberService;
import com.ensport.member.model.vo.Member;

@WebServlet("/login.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/member/memberLoginForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//post 타입으로 요청되었을 때에는 넘어 오는 데이터가 한글이 포함되어있다면 encoding 처리를 먼저 해주어야 한다.
		
		//1)인코딩 설정하기(UTF-8)
		
		//2)요청시 전달된 데이터를 추출하기(request 객체의 parameter 영역에 있는 값을 추출하기)
		//request.getParameter("키값");
		//request.getParameterValues("키값");
		
		//아이디/비밀번호 추출하기 (키값: view 페이지의 name 값)
		String userId = request.getParameter("loginId");
		String userPwd = request.getParameter("loginPassword");
		
		
		
		//==============================================================
		
		//++ 편의기능 추가: 체크박스 아이디 저장기능
		//아이디저장 체크박스 값 추출하기(체크 안 하면 null 체크하면 on)
		String saveId = request.getParameter("saveId");
		
		//만약 체크가 되어 넘어왔다면 쿠키에 해당 userId를 저장하고 보내기
		//쿠키: 키와 밸류값으로 이루어진 데이터 파일
		//로컬디스크에 저장이 되며 사용자가 요청하지 않아도 브라우저가 request시에 header 추가하여 서버로 전송한다.
		Cookie cookie = null;
		
		//만약 체크가 되어 넘어왔다면
		if(saveId != null && saveId.equals("on")) {
			//쿠키의 이름과 값을 넣어서 생성하기
			cookie = new Cookie("userId", userId);
			
			//쿠키의 수명을 정해서 추가하기
			cookie.setMaxAge(60*60*24);			//하루: 60*60*24(초단위)
			
			//응답객체인 response에 쿠키 추가하기
			response.addCookie(cookie);
		}else {	//체크가 되지 않았다면
				//쿠키 지워주기
			cookie = new Cookie("userId", null);
			
			//수명을 0으로 만들어주기
			cookie.setMaxAge(0);
			
			//작업을 마친 쿠키를 addCookie해주기
			response.addCookie(cookie);
		}

		//3)데이터를 가공 처리하고 service에게 요청 전달
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		//4)처리된 결과를 가지고 사용자에게 보여줄 화면을 지정
		
		
		
		
		/*
		  
		응답페이지에 전달할 값이 있을 경우 값을 어딘가에 담아야 한다.
		담아줄 수 있는 Servlet scope(내장객체) 4가지
		1) application: application에 담은 데이터는 웹 애플리케이션 전역에서 접근할 수 있다.
		2) session: session에 담은 데이터는 모든 jsp와 servlet에서 접근 가능함
					한번 담은 데이터는 직접 지우기 전까지, 서버가 멈추기 전까지, 브라우저가 종료되기 전까지는 접근 가능하다.
		3) request: request에 담은 데이터는 해당 request를 포워딩(위임)한 응답 jsp에서만 꺼내서 쓸 수 있다.
		4) page: 해당 jsp 페이지 내에서만 꺼내서 쓸 수 있다.

		공통적으로 데이터를 담고자 할 때에는 .setAttribute("키", "밸류");
		데이터를 꺼내고자 할 땐 .getAttribute("키");
		데이터를 지우고자 할 땐 .removeAttribute("키");
		
		메소드를 사용한다.
		
		*/
		
		
		HttpSession session = request.getSession();

		//로그인 후 전 페이지 돌아가기(referer)
		String before = request.getHeader("referer");
		
		if(loginUser == null) {//로그인 실패	
			
			//로그인 작업이 처리된 후 이전 페이지로 다시 돌아가기 요청하기
			session.setAttribute("alertMsg", "아이디 또는 비밀번호를 확인하세요.");
			response.sendRedirect(before);
		
		}else {	//로그인 성공

			session.setAttribute("loginUser", loginUser);	//로그인 회원정보 담기
			session.setAttribute("alertMsg", loginUser.getUserNickname() + "님 환영합니다.");

			if(before.contains(request.getContextPath() + "/login.do")) {	//이전페이지가 로그인 페이지면
				response.sendRedirect(request.getContextPath());	//메인 화면으로 redirect
			}else {
				response.sendRedirect(before);
			}
		}
	}
}
