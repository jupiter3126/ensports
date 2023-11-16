package com.ensport.matching.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.admin.model.vo.Attachment;

import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.place.model.vo.Place;

/**
 * Servlet implementation class SoccerMatchingDetailController
 */
@WebServlet("/detail.so")
public class SoccerMatchingDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoccerMatchingDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matchingDate = request.getParameter("date");
		String matchingTime = request.getParameter("time");
		
		int placeNo = Integer.parseInt(request.getParameter("pno"));
		System.out.println("안 넘어온다면서 넘어오는 pno번호: "+placeNo);
		System.out.println(matchingDate);
		
	
		
		SoccerMatchingService ss = new SoccerMatchingService();
		
		int result = ss.increaseCount(placeNo);
		HttpSession session = request.getSession();
		
		if(result>0) {
			Place p = ss.selectPlace(placeNo);
			ArrayList<Attachment> list = ss.selectAttachmentList(placeNo);
			
			request.setAttribute("time", matchingTime);
			request.setAttribute("pno", placeNo);
			request.setAttribute("p", p);
			request.setAttribute("slist", list);
			request.setAttribute("matchingDate", matchingDate);
			request.getRequestDispatcher("views/information/soccerMatchingInfo.jsp").forward(request, response);
			
		}else {
			session.setAttribute("alertMsg", "상세보기 실패");
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
