package com.ensport.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.service.MemberService;
import com.ensport.member.model.vo.Member;

/**
 * Servlet implementation class ChangePwdController
 */
//비밀번호 변경
@WebServlet("/changePwd.me")
public class ChangePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));	//회원번호
		String userPwd = request.getParameter("userPassword");		//기존 비밀번호
		String newPwd = request.getParameter("newUserPassword");	//새 비밀번호

		
		Member updateMember = new MemberService().chagePwd(userNo, userPwd, newPwd);
		
		
		HttpSession session = request.getSession();
		
		//처리된 회원정보를 토대로 응답페이지 선택하기
		if(updateMember != null) {	//성공페이지
			
			session.setAttribute("loginUser", updateMember);
			session.setAttribute("alertMsg", "비밀번호 변경 성공");
			
			//갱신후 mypage로 재요청보내기
			response.sendRedirect(request.getContextPath() + "/myPage.me");	// == /jsp + /myPage.me
			
		}else {	//실패 페이지
			//errorPage에 메시지 담아서 전달하기
			session.setAttribute("alertMsg", "비밀번호 수정에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		}
	}

}
