package com.ensport.place.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.common.model.vo.PageInfo;
import com.ensport.place.model.service.SoccerPlaceService;
import com.ensport.place.model.vo.SoccerPlace;
/**
 * Servlet implementation class SoccerSeoulController
 */
@WebServlet("/seoul.so")
public class SoccerPlaceSeoulController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoccerPlaceSeoulController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//==================================
		//soccer 서울 페이지 가기
		//==================================
				
		String localName = request.getParameter("localName");
		
		int placeSeoulListCount; // 서울지역 게시글 개수
		int currentPage; // 현재 페이지
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 개수
		int seoulPlaceLimit; // 한페이지에 보여질 게시글 개수
		
		int maxPage; // 가장 마지막 페이징바가 몇번인지 (총 페이지수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수
		
		placeSeoulListCount = new SoccerPlaceService().allSeoulListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		
		seoulPlaceLimit = 9;
		
		maxPage = (int) Math.ceil((double) placeSeoulListCount / seoulPlaceLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if (maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(placeSeoulListCount, currentPage, pageLimit, seoulPlaceLimit, maxPage, startPage, endPage);
		
		ArrayList<SoccerPlace> list = new SoccerPlaceService().selectAllseoulPlaceList(localName,pi);
		
		request.setAttribute("list",list);
		
		request.setAttribute("pi",pi);
		
		request.getRequestDispatcher("views/place/soccerplaceseoul.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}