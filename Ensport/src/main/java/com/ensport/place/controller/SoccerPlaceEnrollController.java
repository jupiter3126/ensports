package com.ensport.place.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.vo.Member;
import com.ensport.place.model.service.SoccerPlaceService;
import com.ensport.reservation.model.vo.Player;
import com.ensport.reservation.model.vo.Reservation;
import com.google.gson.Gson;

/**
 * Servlet implementation class SoccerPlaceEnrollController
 */
@WebServlet("/placeEnrollForm.so")
public class SoccerPlaceEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoccerPlaceEnrollController() {
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
	
		//TIME_NO, PLACE_NO, RESERVATION_DATE : 서브쿼리 SELECT 절에서 RESERVATION_NO 를 가지고 오는 조건절에 쓰는 VALUE
		String timeNo = request.getParameter("timeNo");
		String placeNo = request.getParameter("placeNo");
		String reservationDate = request.getParameter("reservationDate");

		
		
//		//현재 구장에 예약된 인원
		int currentPlayerCount =  new SoccerPlaceService().reservationPlayer(timeNo, placeNo, reservationDate);
		
		
//		//현재 구장에 예약된 인원이 0명일 때
		if(currentPlayerCount == 0) {
			
			//insert(예약처리)
			int result = new SoccerPlaceService().SoccerPlaceReservation(userNo, timeNo, placeNo, reservationDate);
			
			if(result > 0) {
				//예약 성공
				//System.out.println("예약 성공~~~~~~");
				
				session.setAttribute("alertMsg", "예약이 확정되었습니다.");
				response.sendRedirect(request.getContextPath() + "/myPageReservation.me?currentPage=1");
			}else {
				//예약 실패
				//System.out.println("예약 실패~~~~~~~~~~!");
				
				session.setAttribute("alertMsg", "예약에 실패하였습니다.");
				response.sendRedirect(request.getHeader("referer"));		
			}
			
		}
		
		
//		if( currentPlayerCount > 0) {
//			session.setAttribute("alertMsg", "예약 마감되었습니다.");
//			response.sendRedirect(request.getHeader("referer"));
//			
//		}else {
//			
//			//중복 개수
//			int duplicate = new SoccerPlaceService().SoccerPlaceDuplicate(userNo,timeNo, placeNo, reservationDate);
//			
//			if(duplicate>0) {
//				session.setAttribute("alertMsg", "중복예약입니다.");
//				response.sendRedirect(request.getHeader("referer"));
//			}else {
//				
//				if(result > 0) {
//
//					response.sendRedirect(request.getHeader("referer"));
//				}else {
//					request.setAttribute("errorMsg", "예약이 처리되지 않았습니다. 다시 시도해주세요.");
//					response.sendRedirect(request.getHeader("referer"));
//					
//				}
//				
//			}			
//			
//		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
