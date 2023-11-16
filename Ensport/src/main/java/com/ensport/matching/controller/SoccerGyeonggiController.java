package com.ensport.matching.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.common.model.vo.PageInfo;
import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.matching.model.vo.SoccerMatching;

/**
 * Servlet implementation class SoccerSeoulController
 */
@WebServlet("/sc.gyeonggi")
public class SoccerGyeonggiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SoccerGyeonggiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String localName = request.getParameter("localName");

		// 페이징처리

		int PlaceAllListCount; // 총 게시글 개수
		int currentPage; // 현재 페이지
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 개수
		int myPageSoccerPlaceLimit; // 한페이지에 보여질 게시글 개수

		int maxPage; // 가장 마지막 페이징바가 몇번인지 (총 페이지수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수

		PlaceAllListCount = new SoccerMatchingService().allGyeonggiListCount();

		currentPage = Integer.parseInt(request.getParameter("currentPage"));

		pageLimit = 5;

		myPageSoccerPlaceLimit = 9;

		maxPage = (int) Math.ceil((double) PlaceAllListCount / myPageSoccerPlaceLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(PlaceAllListCount, currentPage, pageLimit, myPageSoccerPlaceLimit, maxPage,
				startPage, endPage);

		ArrayList<SoccerMatching> list = new SoccerMatchingService().selectAllGyeonggiSoccerMatchingList(localName,pi);

		for (SoccerMatching sm : list) {
			System.out.println(sm);
		}

		request.setAttribute("slist", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/matching/soccerGyeonggi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
