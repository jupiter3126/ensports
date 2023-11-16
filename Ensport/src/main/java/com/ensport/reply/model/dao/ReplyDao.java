package com.ensport.reply.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ensport.board.model.vo.Board;
import com.ensport.board.model.vo.Reply;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;

public class ReplyDao {


	private Properties prop = new Properties();
	
	//기본생성자가 생성되는 시점(메소드 호출 시점)에 파일 읽어오기
	public ReplyDao() {
		
		//컴파일된 파일 기준으로 읽어올 xml파일 경로 찾기
		String filePath = ReplyDao.class.getResource("/db/sql/reply-mapper.xml").getPath();
		
		try {
			//찾은 경로를 넣고 해당 파일 읽어오기
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//마이페이지 Reply 개수
	public int replyListCount(Connection conn, String userId) {

		// SELECT (조회)
		int count = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("replyListCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				count = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

	
	
	//마이페이지 Reply 리스트
	public ArrayList<Board> selectMyReplyList(Connection conn, String userId, PageInfo pi) {

		// 준비물
		ArrayList<Board> reviewList = new ArrayList<Board>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		Board bReply = null;

		String sql = prop.getProperty("selectMyReplyList");
		
		// 1페이지 : 1~10 / 5페이지 : 41~50 / 10페이지 91~100
		// 2페이지 : 11~20
		 int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		 int endRow = pi.getCurrentPage() * pi.getBoardLimit();

		 
		try {
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);
			
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				
				bReply = new Board();
				
				bReply.setBoardNo(rset.getInt("BOARDNO"));
				bReply.setReplyNo(rset.getInt("REPLY_NO"));
				bReply.setBoardTitle(rset.getString("BOARD_TITLE"));
				bReply.setBoardContent(rset.getString("BOARD_CONTENT"));
				bReply.setCreateDate(rset.getDate("BOARD_CREATEDATE"));
				bReply.setReplyContent(rset.getString("REPLY_CONTENT"));
				bReply.setReplyCreateDate(rset.getDate("REPLY_CREATEDATE"));
				
				reviewList.add(bReply);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return reviewList;
	}

}
