package com.ensport.matching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.matching.model.service.BaseballMatchingService;
import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.review.model.vo.Review;
import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxBaseballStarReviewController
 */
@WebServlet("/ajax.starba")
public class AjaxBaseballStarReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBaseballStarReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int placeNo = Integer.parseInt(request.getParameter("pno"));
		
		ArrayList<Review> slist = new BaseballMatchingService().selectStarReview(placeNo);
		

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("slist", slist);
		Gson gson = new Gson();
		String json = gson.toJson(responseData);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
