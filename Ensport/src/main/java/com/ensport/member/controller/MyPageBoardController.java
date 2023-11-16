package com.ensport.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.board.model.service.BoardService;
import com.ensport.board.model.vo.Board;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.member.model.service.MemberService;
import com.ensport.member.model.vo.Member;
import com.ensport.qa.model.service.QaService;
import com.ensport.qa.model.vo.Qa;

/**
 * Servlet implementation class MyPageBoardController
 */
@WebServlet("/myPageBoard.me")
public class MyPageBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//userNo 세션에서 추출하기
		HttpSession session = request.getSession();
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();			

		int boardListCount; // 총 게시글 개수
		int currentPage; // 현재 페이지
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 개수
		int myPageBoardLimit; // 한페이지에 보여질 게시글 개수

		int maxPage; // 가장 마지막 페이징바가 몇번인지 (총 페이지수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수

		
		// listCount 현재 게시글 개수
		boardListCount = new MemberService().boardListCount(userNo); // 게시글 개수 조회해오기
		// 현재페이지 정보(번호)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		// 페이지 하단에 보여질 페이징바 개수
		pageLimit = 5;
		
		// 한 페이지에 보여질 게시글 개수
		myPageBoardLimit = 5;

		maxPage = (int) Math.ceil((double) boardListCount / myPageBoardLimit);

		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(boardListCount, currentPage, pageLimit, myPageBoardLimit, maxPage, startPage, endPage);
		
		
		//myPage Board List
		ArrayList<Board> selectMyBoardList = new MemberService().selectMyBoardList(pi, userNo);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("bList", selectMyBoardList);
		
		
		request.getRequestDispatcher("views/member/myPageBoard.jsp").forward(request, response);
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
