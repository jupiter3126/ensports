package com.ensport.place.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.admin.model.vo.Attachment;
import com.ensport.place.model.service.BaseballPlaceService;
import com.ensport.place.model.service.SoccerPlaceService;
import com.ensport.place.model.vo.Place;
import com.ensport.place.model.vo.SoccerPlace;

/**
 * Servlet implementation class BaseballPlaceDetailController
 */
@WebServlet("/baseballdetail.bo")
public class BaseballPlaceDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseballPlaceDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//==================================
		//soccer 디테일
		//==================================
		
		//시간선택 값 보내주기 
		String placeDate = request.getParameter("date");
		
		//시간선택 값 보내주기
		String placeTime = request.getParameter("time");
		
		//경기장 번호 으로 게시글 정보와 첨부파일 정보 조회
		int placeNo = Integer.parseInt(request.getParameter("sno"));
		
		//서비스 선언
		BaseballPlaceService bps = new BaseballPlaceService();
				
		//조회수 증가 처리 
		int result = bps.increaseBaseballCount(placeNo);
		
		HttpSession session = request.getSession();
		
		//조회수 증가가 성공적으로 되었다면 게시글 첨부파일 정보 조회하기 
		if(result>0) {
			
			Place bp = bps.selectBaseballPlace(placeNo);	
			
			ArrayList<Attachment> list = bps.selectBaseballAttachmentlist(placeNo);
			
			request.setAttribute("placeDate", placeDate);
			request.setAttribute("placeTime", placeTime);
			
			request.setAttribute("bp", bp);
			request.setAttribute("list", list);
			
			
			request.getRequestDispatcher("views/information/baseballPlaceInfo.jsp").forward(request, response);
		}else {
			session.setAttribute("alertMsg", "조회하신 경기장은 준비중 입니다.");
			//이전페이지로 
			response.sendRedirect(request.getHeader("referer"));
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
