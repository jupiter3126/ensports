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
import com.ensport.matching.model.service.BaseballMatchingService;
import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.place.model.vo.Place;

/**
 * Servlet implementation class BaseballMatchingDetailController
 */
@WebServlet("/detail.ba")
public class BaseballMatchingDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseballMatchingDetailController() {
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
		
	
		
		 BaseballMatchingService bs = new  BaseballMatchingService();
		
		int result = bs.increaseCount(placeNo);
		HttpSession session = request.getSession();
		
		if(result>0) {
			Place p = bs.selectPlace(placeNo);
			ArrayList<Attachment> list = bs.selectAttachmentList(placeNo);
			
			request.setAttribute("time", matchingTime);
			request.setAttribute("pno", placeNo);
			request.setAttribute("p", p);
			request.setAttribute("slist", list);
			request.setAttribute("matchingDate", matchingDate);
			request.getRequestDispatcher("views/information/baseballMatchingInfo.jsp").forward(request, response);
			
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
