package com.ensport.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.vo.Member;
import com.ensport.reservation.model.dao.ReservationDao;
import com.ensport.reservation.model.service.ReservationService;

/**
 * Servlet implementation class ReservationCancelController
 */
@WebServlet("/reservationCancel.rv")
public class ReservationCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCancelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session 추출
		HttpSession session = request.getSession();
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();			
		String userId = ((Member)session.getAttribute("loginUser")).getUserId();	
		
		int rvNo = Integer.parseInt(request.getParameter("rvNo"));
		
		
		
		int result = new ReservationService().reservationCancel(rvNo, userNo);
		
		
		
		if(result > 0) {
			session.setAttribute("alertMsg", "예약 취소가 완료되었습니다.");
		}else {
			session.setAttribute("alertMsg", "오류가 발생했습니다.");
		}

		response.sendRedirect(request.getContextPath() + "/myPageReservation.me?currentPage=1");
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
