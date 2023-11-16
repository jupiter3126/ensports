package com.ensport.admin.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.admin.model.service.AdminService;
import com.ensport.admin.model.vo.QA;
import com.ensport.admin.model.service.AdminService;
import com.ensport.admin.model.vo.QA;

/**
 * Servlet implementation class QADetailController
 */
@WebServlet("/qaDetail.qa")
public class QADetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QADetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qa_no = Integer.parseInt(request.getParameter("qno"));
		
		QA qa = new AdminService().selectOneQA(qa_no);
		
		request.setAttribute("qa", qa);
		request.getRequestDispatcher("views/admin/qaView/qaDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
