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
 * Servlet implementation class QAEnrollController
 */
@WebServlet("/qaEnroll.qa")
public class QAEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QAEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("views/admin/qaView/qaEnrollView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		int result = new AdminService().insertQA(userNo,subject,message);
		
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("alertMsg", "문의사항을 성공적으로 등록하였습니다");
			
			response.sendRedirect(request.getContextPath());
		}else {
			session.setAttribute("alertMsg", "문의사항을 등록 실패하였습니다");
			
			response.sendRedirect(request.getContextPath());
		}
	}

}
