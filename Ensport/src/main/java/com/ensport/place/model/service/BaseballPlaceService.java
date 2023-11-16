package com.ensport.place.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ensport.admin.model.vo.Attachment;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.place.model.dao.BaseballPlaceDao;
import com.ensport.place.model.dao.SoccerPlaceDao;
import com.ensport.place.model.vo.Place;
import com.ensport.place.model.vo.SoccerPlace;


public class BaseballPlaceService {

	//페이징처리 
	public int allBaseballPlaceCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new BaseballPlaceDao().allBaseballPlaceCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}

	//경기장 전체 조회 (지역선택 전)
	public ArrayList<Place> selectAllBaseballPlaceList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Place> list = new BaseballPlaceDao().selectAllBaseballPlaceList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//조회수 증가 메소드 
	public int increaseBaseballCount(int placeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BaseballPlaceDao().increaseBaseballCount(conn,placeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Place selectBaseballPlace(int placeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Place bp = new BaseballPlaceDao().selectBaseballPlace(conn,placeNo);
		
		JDBCTemplate.close(conn);
		
		return bp;
	}

	//축구시설예약 상세보기
	public ArrayList<Attachment> selectBaseballAttachmentlist(int placeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Attachment> list = new BaseballPlaceDao().selectBaseballAttachmentlist(conn,placeNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//참여
	public int baseballreservationPlayer(String timeNo, String placeNo, String reservationDate) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int placePlayer = new BaseballPlaceDao().baseballreservationPlayer(conn, timeNo, placeNo, reservationDate);
			
		return placePlayer;
	}

	//중복확인
	public int baseballPlaceDuplicate(int userNo, String timeNo, String placeNo, String reservationDate) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int duplicate = new BaseballPlaceDao().baseballPlaceDuplicate(conn,userNo,timeNo,placeNo,reservationDate);
		
		JDBCTemplate.close(conn);
		
		return duplicate;
	}

	//예약확정
	public int baseballPlaceReservation(int userNo, String timeNo, String placeNo, String reservationDate) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BaseballPlaceDao().baseballPlaceReservation(conn, userNo, timeNo, placeNo, reservationDate);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;	
	}

	public int baseballTimeChk(int pno, String selectTime, String placeDate) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new BaseballPlaceDao().baseballTimeChk(conn, pno, selectTime, placeDate);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	//서울지역 페이징 count
	public int baseballSeoulListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new BaseballPlaceDao().baseballSeoulListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}

	//서울지역 페이징 select
	public ArrayList<Place> selectBaseballSeoulPlaceList(String localName, PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Place> list = new BaseballPlaceDao().selectBaseballSeoulPlaceList(conn, localName, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//서울 지역 페이징 count
	public int baceballGyeonggiListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new BaseballPlaceDao().baceballGyeonggiListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}

	//서울지역 페이징 select
	public ArrayList<Place> selectBaseballgyeonggiPlaceList(String localName, PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Place> list = new BaseballPlaceDao().selectBaseballgyeonggiPlaceList(conn, localName, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	

}
