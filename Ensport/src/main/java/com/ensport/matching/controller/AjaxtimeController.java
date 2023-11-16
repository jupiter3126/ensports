package com.ensport.matching.controller;

import java.io.IOException;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.matching.model.vo.SoccerMatching;
import com.ensport.reservation.model.service.ReservationService;
import com.ensport.reservation.model.vo.Reservation;
import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxtimeController
 */
@WebServlet("/ajax.time")
public class AjaxtimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxtimeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int timeNo = Integer.parseInt(request.getParameter("tno"));
		int placeNo = Integer.parseInt(request.getParameter("pno"));
		System.out.println("pno: " + placeNo);
		System.out.println("tno:" + timeNo);

		
		//Date
		String reservationDate = request.getParameter("matchingDate");
	    
		System.out.println("matchingDate: "+ reservationDate);
		
		
		int total = new ReservationService().selectAll(placeNo, reservationDate, timeNo );
		int player = new ReservationService().selectPlayer(placeNo, reservationDate, timeNo );
		
		Map<String, Integer> responseData = new HashMap<>();
		responseData.put("total", total);
		responseData.put("player", player);
		
		Gson gson = new Gson();
        String json = gson.toJson(responseData);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        
        System.out.println(total);
        System.out.println(player);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
