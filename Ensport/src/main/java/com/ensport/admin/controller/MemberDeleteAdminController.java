package com.ensport.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.admin.model.service.AdminService;

/**
 * Servlet implementation class MemberDeleteAdminController
 */
@WebServlet("/AdminMemberDelete.me")
public class MemberDeleteAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new AdminService().adminDeleteMember(userNo);
		
		
		if(result > 0) {	//성공
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원 추방 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/memberList.me");
			
		}else {	//실패
			request.setAttribute("errorMsg", "회원 추방에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/memberList.me");
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
