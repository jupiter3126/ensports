package com.ensport.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDelete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userPwd = request.getParameter("password");
		
		System.out.println(userNo);
		System.out.println(userPwd);
		
		int result = new MemberService().deleteMember(userNo, userPwd);
		
		
		if(result > 0) {	//성공
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "Ensport 탈퇴가 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/login.do");
			session.invalidate();
			
		}else {	//실패
			request.setAttribute("errorMsg", "회원 탈퇴에 실패하였습니다. 비밀번호를 확인하세요.");
			request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
