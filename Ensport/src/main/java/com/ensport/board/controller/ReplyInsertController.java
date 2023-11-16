package com.ensport.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.board.model.service.BoardService;
import com.ensport.board.model.vo.Reply;
import com.ensport.member.model.vo.Member;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/insertReply.bo")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String content = request.getParameter("content");
		Member loginUser = (Member)request.getSession().getAttribute("loginUser"); //로그인 정보
		String userId = loginUser.getUserId();//댓글작성자 아이디추출
		
		Reply r = new Reply();
		r.setBoardNo(bno);
		r.setReplyContent(content);
		r.setUserId(userId);
		
		//INSERT (DML)
		int result = new BoardService().insertReply(r);
		
		//처리결과에 따른 화면요소는 view에서 결정하기
		response.getWriter().print(result);
		
	}

}
