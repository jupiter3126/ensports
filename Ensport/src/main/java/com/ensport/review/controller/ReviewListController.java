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

import org.json.simple.JSONObject;

import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.review.model.vo.Review;
import com.google.gson.Gson;

/**
 * Servlet implementation class ReviewListController
 */
@WebServlet("/review.li")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int placeNo = Integer.parseInt(request.getParameter("pno"));
		int sum = new SoccerMatchingService().selectReviewSum(placeNo);
		int count = new SoccerMatchingService().selectReviewCount(placeNo);
		int fiveStar = new SoccerMatchingService().selectfiveStar(placeNo);
		int fourStar = new SoccerMatchingService().selectfourStar(placeNo);
		int threeStar = new SoccerMatchingService().selectthreeStar(placeNo);
		int twoStar = new SoccerMatchingService().selectTwoStar(placeNo);
		int oneStar = new SoccerMatchingService().selectOneStar(placeNo);
		
		

		ArrayList<Review> rlist = new SoccerMatchingService().selectReviewList(placeNo);
		
		System.out.println("rlist 출력하기");
		for(Review r : rlist) {
			System.out.println(r);
		}

		

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
//		System.out.println("총점 : " + sum);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
