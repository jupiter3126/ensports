package com.ensport.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.member.model.service.MemberService;

/**
 * Servlet implementation class MemberPhoneCheckController
 */
@WebServlet("/phoneDuplCheck.me")
public class MemberPhoneCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPhoneCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("checkPhone");
		
		System.out.println("넘어오나 보자: " + phone);
		
		int count = new MemberService().phoneDuplCheck(phone);
		
		if(count > 0) {	//중복인 경우
			//사용 불가 NNNNN
			response.getWriter().print("NNNNN");
			
		}else {	//중복이 아닌 경우
			//사용 가능
			response.getWriter().print("NNNNY");
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
