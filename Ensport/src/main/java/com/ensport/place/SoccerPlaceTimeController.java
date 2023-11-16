package com.ensport.place;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ensport.place.model.service.SoccerPlaceService;

/**
 * Servlet implementation class SoccerPlaceTimeController
 */
@WebServlet("/soccerTimeChk.time")
public class SoccerPlaceTimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoccerPlaceTimeController() {
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
		
		int count = new SoccerPlaceService().soccerTimeChk(pno, selectTime, placeDate);
		
		
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
