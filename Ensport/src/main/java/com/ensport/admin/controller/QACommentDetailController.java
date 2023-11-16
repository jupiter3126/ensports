package com.ensport.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.admin.model.service.AdminService;
import com.ensport.admin.model.vo.QAComment;
import com.google.gson.Gson;

/**
 * Servlet implementation class QACommentDetailController
 */
@WebServlet("/qaCommentDetail.qa")
public class QACommentDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QACommentDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int qa_answer_no = Integer.parseInt(request.getParameter("qa_answer_no"));
		
		
		QAComment qac = new AdminService().selectOneQAComment(qa_answer_no);
		
		
		response.setContentType("json/application; charset=UTF-8");
		new Gson().toJson(qac,response.getWriter());
	}

}
