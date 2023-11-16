package com.ensport.matching.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.member.model.vo.Member;
import com.ensport.place.model.service.SoccerPlaceService;
import com.ensport.reservation.model.service.ReservationService;

/**
 * Servlet implementation class SoccerMatchingEnrollController
 */
@WebServlet("/matching.en")
public class SoccerMatchingEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoccerMatchingEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//session에서 userNo 뽑아주기(PLAYER TABLE에 INSERT될 친구)
		HttpSession session = request.getSession();
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		
		System.out.println("유저넘버:" + userNo);
		
		
		//TIME_NO, PLACE_NO, RESERVATION_DATE : 서브쿼리 SELECT 절에서 RESERVATION_NO 를 가지고 오는 조건절에 쓰는 VALUE
		int timeNo = Integer.parseInt(request.getParameter("timeNo"));
		int placeNo = Integer.parseInt(request.getParameter("placeNo"));
		String reservationDate = request.getParameter("reservationDate");
		
		int total = new ReservationService().selectAll(placeNo, reservationDate, timeNo );
		int player = new ReservationService().selectPlayer(placeNo, reservationDate, timeNo );
		
		if(player>=total) {
			session.setAttribute("alertMsg", "인원마감되었습니다.");
			response.sendRedirect(request.getHeader("referer"));
		}else {
			int duplicate = new SoccerMatchingService().SoccerMatchingDuplicate(userNo,timeNo, placeNo, reservationDate);
			
			
			if(duplicate>0) {
				session.setAttribute("alertMsg", "중복예약입니다.");
				response.sendRedirect(request.getHeader("referer"));
			}else {
				
				
				int result = new SoccerMatchingService().SoccerMatchingReservation(userNo, timeNo, placeNo, reservationDate);
				
				if(result > 0) {
					session.setAttribute("alertMsg", "예약이 확정되었습니다.");
					response.sendRedirect(request.getHeader("referer"));
				}else {
					request.setAttribute("errorMsg", "예약이 처리되지 않았습니다. 다시 시도해주세요.");
					response.sendRedirect(request.getHeader("referer"));
					
				}
				
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
