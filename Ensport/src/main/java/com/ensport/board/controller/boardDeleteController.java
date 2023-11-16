package com.ensport.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.board.model.service.BoardService;
import com.ensport.board.model.vo.Attachment;

/**
 * Servlet implementation class boardDeleteController
 */
@WebServlet("/boardDelete.bo")
public class boardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		int result = new BoardService().deleteBoard(boardNo);
		int result1 = 1;
		
		if(request.getParameter("atno")!=null) {
			result1 = new BoardService().deleteAttachment(boardNo);
		}
		
		
		
		
		if(result*result1>0) {
			session.setAttribute("alertMsg", "게시글 삭제 완료");
			response.sendRedirect(request.getContextPath()+"/boardList.bo?currentPage=1");
		}else {
			session.setAttribute("alertMsg", "게시글 삭제 실패");
			response.sendRedirect(request.getContextPath()+"/boardDetail.bo?bno="+boardNo);
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
