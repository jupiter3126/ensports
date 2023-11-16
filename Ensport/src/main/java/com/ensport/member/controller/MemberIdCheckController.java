package com.ensport.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.member.model.service.MemberService;

/**
 * Servlet implementation class MemberIdCheckController
 */
@WebServlet("/idDuplCheck.me")
public class MemberIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkId = request.getParameter("checkId");
		
		System.out.println("넘어오나 보자: " + checkId);
		
		int count = new MemberService().idDuplCheck(checkId);
		
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
