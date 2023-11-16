package com.ensport.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.review.model.service.ReviewService;
import com.ensport.review.model.vo.Review;

/**
 * Servlet implementation class MyPageReviewDetailController
 */
@WebServlet("/myPageReviewDetail.me")
public class MyPageReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReviewDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		
		Review reviewDetail = new ReviewService().selectMyReviewDetail(reviewNo);
		
		
		request.setAttribute("reviewDetail", reviewDetail);
		
		request.getRequestDispatcher("views/review/myPageReview_detail.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//내 리뷰 수정하기(update)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
