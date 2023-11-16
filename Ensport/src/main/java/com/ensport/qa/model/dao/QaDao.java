package com.ensport.qa.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.qa.model.vo.Qa;

public class QaDao {
	
	private Properties prop = new Properties();

	// 매퍼파일 읽어오는 작업 (기본생성자에 추가)
	// DAO로 메소드를 호출하는 시점에서 파일이 읽힌다.
	public QaDao() {

		try {
			String filePath = QaDao.class.getResource("/db/sql/qa-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//내 QA 게시글 수
	public int qalistCount(Connection conn, int userNo) {
		
		// SELECT (조회)
		int count = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("qaListCount");
		

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				// 조회된 게시글 개수
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
	
	
	
	
	//마이페이지 Qa List
	public ArrayList<Qa> selectMyQaList(Connection conn, int userNo, PageInfo pi) {

		// 준비물
		ArrayList<Qa> qList = new ArrayList<Qa>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		Qa qa = null;

		String sql = prop.getProperty("selectMyQaList");
		
		// 1페이지 : 1~10 / 5페이지 : 41~50 / 10페이지 91~100
		// 2페이지 : 11~20
		 int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		 int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		 
		try {
			
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				
				qa = new Qa();
				
				qa.setQaNo(rset.getInt("QA_NO"));
				qa.setQaTitle(rset.getString("QA_TITLE"));
				qa.setQaContent(rset.getString("QA_CONTENT"));
				qa.setQaWriteDate(rset.getDate("WRITEDATE"));
				qa.setQaAnswer(rset.getString("QA_ANSWER"));
				qa.setQaAnswerDate(rset.getDate("ANSWERDATE"));
				
				qList.add(qa);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return qList;
	}
	
	
	
	
	

}
