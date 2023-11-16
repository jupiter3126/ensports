package com.ensport.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.admin.model.service.AdminService;
import com.ensport.admin.model.vo.QAComment;

/**
 * Servlet implementation class QACommentInsertController
 */
@WebServlet("/insertQAComment.qa")
public class QACommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QACommentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qa_answer_no = Integer.parseInt(request.getParameter("qa_no"));
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		String qaAnswer = request.getParameter("qaAnswer");
		
		QAComment qac = new QAComment(qa_answer_no,user_no,qaAnswer);
		
		int result = new AdminService().insertQAComment(qac);
		
		response.getWriter().print(result);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
