package com.ensport.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.board.model.service.BoardService;
import com.ensport.board.model.vo.Attachment;
import com.ensport.board.model.vo.Board;

/**
 * Servlet implementation class boardDetailController
 */
@WebServlet("/boardDetail.bo")
public class boardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상세보기 (게시글 상세조회)
				//게시글 글번호로 조회수 증가 메소드 구현
				//increaseCount 메소드로 구현
				int boardNo = Integer.parseInt(request.getParameter("bno"));
				
				//처리된 결과값 (행수)
				int result = new BoardService().increaseCount(boardNo);
				//게시글 정보 조회 + 조회수 증가처리
				
				if(result>0) {
					Board b = new BoardService().selectBoard(boardNo);
					//첨부파일 정보 조회 selectAttachment();
					//파일번호,원본이름,변경이름,경로
					//해당 게시글에 첨부파일이 있다면 조회를 해와야하니 게시글 번호를 전달하여야한다.
					Attachment at = new BoardService().selectAttachment(boardNo);
					
					ArrayList<Attachment> list = new BoardService().selectAttachmentList(boardNo);
					
					request.setAttribute("b", b); //게시글 정보 전달
					request.setAttribute("a", at); //첨부파일정보도 전달
					
					request.setAttribute("list", list); //이미지 리스트 전달
					
					request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
				}else { //실패
					
					request.getSession().setAttribute("alertMsg", "게시글 조회 실패");
					response.sendRedirect(request.getHeader("referer")); //이전 주소
				}
				
				//조회수가 성공적으로 증가되었다면 -> 게시글 정보 조회해오기
				//조회해온 데이터를 상세보기 페이지로 전달하여 페이지에 값 출력해주기
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
