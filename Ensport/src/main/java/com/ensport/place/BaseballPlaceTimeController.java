package com.ensport.place;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ensport.place.model.service.BaseballPlaceService;
import com.ensport.place.model.service.SoccerPlaceService;

/**
 * Servlet implementation class BaseballPlaceTimeController
 */
@WebServlet("/baseballTimeChk.time")
public class BaseballPlaceTimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseballPlaceTimeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String selectTime = request.getParameter("selectTime");
		String placeDate = request.getParameter("placeDate");					
		
		int count = new BaseballPlaceService().baseballTimeChk(pno, selectTime, placeDate);
		
		System.out.println("몇명이 예약했나요:" + count);
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("reservationChk", count);
		
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
