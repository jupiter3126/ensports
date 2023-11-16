package com.ensport.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.ensport.review.model.service.ReviewService;

/**
 * Servlet implementation class MyPageDeleteReviewController
 */
@WebServlet("/deleteMyReview.me")
public class MyPageDeleteReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDeleteReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		int result = new ReviewService().deleteMyReview(reviewNo);

		HttpSession session = request.getSession();
		
		
		if(result > 0) {
			session.setAttribute("alertMsg", "리뷰 삭제가 완료되었습니다.");
		}else {
			session.setAttribute("alertMsg", "리뷰 삭제 실패하였습니다.");
		}
		
		response.sendRedirect(request.getContextPath()+"/myPageReview.me?currentPage=1");
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
