package com.ensport.reply.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ensport.board.model.vo.Board;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.reply.model.dao.ReplyDao;

public class ReplyService {

		
	//마이페이지 Reply 개수 돌려주기
	public int replyListCount(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new ReplyDao().replyListCount(conn, userId);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}

	
	//마이페이지 Reply 리스트
	public ArrayList<Board> selectMyReplyList(PageInfo pi, String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Board> selectMyReplyList = new ReplyDao().selectMyReplyList(conn, userId, pi);
		
		return selectMyReplyList;
	}

}
