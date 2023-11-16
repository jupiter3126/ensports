package com.ensport.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ensport.member.model.service.MemberService;
import com.ensport.qa.model.service.QaService;
import com.ensport.reply.model.service.ReplyService;
import com.ensport.reservation.model.service.ReservationService;
import com.ensport.review.model.service.ReviewService;

/**
 * Servlet implementation class MyPageProfileController
 */
@WebServlet("/myPageProfile.me")
public class MyPageProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userId = request.getParameter("userId");
		
		
		int boardCount = new MemberService().boardListCount(userNo);
		int replyCount = new ReplyService().replyListCount(userId);
		int qaCount = new QaService().qalistCount(userNo);
		int reviewCount = new ReviewService().reviewListCount(userNo);
		int reservationCount = new ReservationService().reservationListCount(userNo);
		
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("boardCount", boardCount);
		jObj.put("replyCount", replyCount);
		jObj.put("qaCount", qaCount);
		jObj.put("reviewCount", reviewCount);
		jObj.put("reservationCount", reservationCount);
		
		response.getWriter().print(jObj);

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
