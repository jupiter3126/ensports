package com.ensport.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.common.model.vo.PageInfo;
import com.ensport.member.model.vo.Member;
import com.ensport.reservation.model.service.ReservationService;
import com.ensport.reservation.model.vo.Reservation;

/**
 * Servlet implementation class MyPageReservationController
 */
@WebServlet("/myPageReservation.me")
public class MyPageReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//userNo, userId 세션에서 추출하기
		HttpSession session = request.getSession();
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();			
		String userId = ((Member)session.getAttribute("loginUser")).getUserId();			

		
		int reservationListCount; // 총 게시글 개수
		int currentPage; // 현재 페이지
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 개수
		int myPageReservationLimit; // 한페이지에 보여질 게시글 개수

		int maxPage; // 가장 마지막 페이징바가 몇번인지 (총 페이지수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수
		
		reservationListCount = new ReservationService().reservationListCount(userNo); // 게시글 개수 조회해오기
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		myPageReservationLimit = 5;
		maxPage = (int) Math.ceil((double) reservationListCount / myPageReservationLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(reservationListCount, currentPage, pageLimit, myPageReservationLimit, maxPage, startPage, endPage);
		
		
		ArrayList<Reservation> selectMyReservationList = new ReservationService().selectMyReservationList(pi, userNo);
		

		
		request.setAttribute("pi", pi);
		request.setAttribute("rvList", selectMyReservationList);
		
		request.getRequestDispatcher("views/member/myPageReservation.jsp").forward(request, response);
	}


    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
