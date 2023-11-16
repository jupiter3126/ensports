package com.ensport.review.controller;

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
 * Servlet implementation class BaseballMatchingReviewListController
 */
@WebServlet("/review.ba")
public class BaseballMatchingReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseballMatchingReviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int placeNo = Integer.parseInt(request.getParameter("pno"));
		int sum = new BaseballMatchingService().selectReviewSum(placeNo);
		int count = new BaseballMatchingService().selectReviewCount(placeNo);
		int fiveStar = new BaseballMatchingService().selectfiveStar(placeNo);
		int fourStar = new BaseballMatchingService().selectfourStar(placeNo);
		int threeStar = new BaseballMatchingService().selectthreeStar(placeNo);
		int twoStar = new BaseballMatchingService().selectTwoStar(placeNo);
		int oneStar = new BaseballMatchingService().selectOneStar(placeNo);
		
		

		ArrayList<Review> rlist = new BaseballMatchingService().selectReviewList(placeNo);

		

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("sum", sum);
		responseData.put("count", count);
		responseData.put("fiveStar", fiveStar);
		responseData.put("fourStar", fourStar);
		responseData.put("threeStar", threeStar);
		responseData.put("twoStar", twoStar);
		responseData.put("oneStar", oneStar);
		responseData.put("rlist", rlist);

		Gson gson = new Gson();
		String json = gson.toJson(responseData);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

//		System.out.println("수 : " + count);
//		System.out.println("총점 : " + sum);		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
