package com.ensport.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.review.model.service.ReviewService;

/**
 * Servlet implementation class MyPageUpdateReviewController
 */
@WebServlet("/updateMyReview.me")
public class MyPageUpdateReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUpdateReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int score = Integer.parseInt(request.getParameter("updateReviewScore"));
		String reviewContent = request.getParameter("updateReviewContent");
		
		
		int result = new ReviewService().updateMyReview(reviewNo, score, reviewContent);
		
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("alertMsg", "등록 완료!");
		}else {
			session.setAttribute("alertMsg", "등록 실패!");
		}
		
		response.sendRedirect(request.getContextPath()+"/myPageReviewDetail.me?reviewNo=" + reviewNo);
	}

}
