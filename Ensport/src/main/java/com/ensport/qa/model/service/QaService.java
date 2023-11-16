package com.ensport.qa.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.qa.model.dao.QaDao;
import com.ensport.qa.model.vo.Qa;

public class QaService {

	
	//마이페이지 내 Qa 개수 조회 메소드
	public int qalistCount(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new QaDao().qalistCount(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}
	
	
	//마이페이지 내 Qa 불러오기
	public ArrayList<Qa> selectMyQaList(PageInfo pi, int userNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Qa> selectMyQaList = new QaDao().selectMyQaList(conn, userNo, pi);
		
		return selectMyQaList;
				
	}
}
