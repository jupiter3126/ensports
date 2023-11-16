package com.ensport.place.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.vo.Member;
import com.ensport.place.model.service.BaseballPlaceService;
import com.ensport.place.model.service.SoccerPlaceService;

/**
 * Servlet implementation class BaseballPlaceEnrollController
 */
@WebServlet("/placeEnrollForm.ba")
public class BaseballPlaceEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseballPlaceEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//session에서 userNo 뽑아주기(PLAYER TABLE에 INSERT될 친구)
		HttpSession session = request.getSession();
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
	
		//TIME_NO, PLACE_NO, RESERVATION_DATE : 서브쿼리 SELECT 절에서 RESERVATION_NO 를 가지고 오는 조건절에 쓰는 VALUE
		String timeNo = request.getParameter("timeNo");
		String placeNo = request.getParameter("placeNo");
		String reservationDate = request.getParameter("reservationDate");
	
		
		int currentPlayerCount =  new BaseballPlaceService().baseballreservationPlayer(timeNo, placeNo, reservationDate);
		
		if( currentPlayerCount == 0) {
						
			int result = new BaseballPlaceService().baseballPlaceReservation(userNo, timeNo, placeNo, reservationDate);
			
			if(result>0) {
				
				session.setAttribute("alertMsg", "예약이 확정되었습니다.");
				response.sendRedirect(request.getContextPath() + "/myPageReservation.me?currentPage=1");
		
			}else {
				
				session.setAttribute("alertMsg", "예약에 실패하였습니다.");
				response.sendRedirect(request.getHeader("referer"));	
					
			}			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
