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
import com.google.gson.Gson;

/**
 * Servlet implementation class MyPageInsertReviewController
 */
@WebServlet("/insertMyReview.me")
public class MyPageInsertReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageInsertReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int playerNo = Integer.parseInt(request.getParameter("playerNo"));
		
		request.setAttribute("playerNo", playerNo);
		request.getRequestDispatcher("views/review/myPageReview_insert.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int playerNo = Integer.parseInt(request.getParameter("playerNo"));
		int score = Integer.parseInt(request.getParameter("reviewScore"));
		
		String reviewContent = request.getParameter("reviewContent");
		
		
		int result = new ReviewService().insertMyReview(score, reviewContent, playerNo);
		
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			//리뷰 등록 성공시
			
			//REVIEW_NO 조회하기
			int reviewNo = new ReviewService().selectMyReviewNo(score, reviewContent, playerNo);
			
			//REVIEW_NO로 review 조회하기
			Review reviewDetail = new ReviewService().selectMyReviewDetail(reviewNo);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(reviewDetail, response.getWriter());
			
		}else {
			//리뷰 등록 실패시
			session.setAttribute("alertMsg", "리뷰 등록에 실패하였습니다!");
			response.sendRedirect(request.getContextPath()+"/insertMyReview.me?playerNo=" + playerNo);
		}
		
	}

}
