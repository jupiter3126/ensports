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
 * Servlet implementation class QACommentUpdateController
 */
@WebServlet("/qaCommentUpdate.qa")
public class QACommentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QACommentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_nickname = request.getParameter("user_nickname");
		String qa_title = request.getParameter("qa_title");
		String qa_content = request.getParameter("qa_content");
		int qa_answer_no = Integer.parseInt(request.getParameter("qa_answer_no"));
		
		request.setAttribute("user_nickname", user_nickname);
		request.setAttribute("qa_title", qa_title);
		request.setAttribute("qa_content", qa_content);
		request.setAttribute("qa_answer_no", qa_answer_no);
		
		request.getRequestDispatcher("views/admin/qaView/qaCommentUpdateView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int qa_answer_no = Integer.parseInt(request.getParameter("qa_answer_no"));
		String qa_answer = request.getParameter("qa_answer");
	
		int result = new AdminService().qaCommentUpdate(qa_answer_no,qa_answer);
		
		response.getWriter().print(qa_answer_no);
		
		
		
	}

}
