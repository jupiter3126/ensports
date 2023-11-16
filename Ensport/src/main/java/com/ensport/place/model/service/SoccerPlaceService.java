package com.ensport.place.model.service;

import java.sql.Connection;

import java.util.ArrayList;

import com.ensport.admin.model.vo.Attachment;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.matching.model.dao.SoccerMatchingDao;
import com.ensport.matching.model.vo.SoccerMatching;
import com.ensport.member.model.dao.MemberDao;
import com.ensport.place.model.dao.SoccerPlaceDao;
import com.ensport.place.model.vo.PlaceTime;
import com.ensport.place.model.vo.SoccerPlace;
import com.ensport.reservation.model.vo.Reservation;

public class SoccerPlaceService {
	
	//축구시설예약 목록 조회
	public ArrayList<SoccerPlace> SoccerPlaceList(String localName) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SoccerPlace> list = new SoccerPlaceDao().selectSoccerPlaceList(conn, localName);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	

	//조회수 증가 메소드
	public int increaseCount(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new SoccerPlaceDao().increaseCount(conn,placeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//축구시설예약 상세보기
	public ArrayList<Attachment> selectSoccerAttachmentlist(int placeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Attachment> list = new SoccerPlaceDao().selectSoccerAttachmentlist(conn,placeNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public SoccerPlace selectSoccerPlace(int placeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SoccerPlace ssp = new SoccerPlaceDao().selectSoccerPlace(conn,placeNo);
		
		JDBCTemplate.close(conn);
		
		return ssp;

	}

	//경기장 전체 조회 (지역선택 전)
	public ArrayList<SoccerPlace> selectAllSoccerPlaceList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SoccerPlace> list = new SoccerPlaceDao().selectAllSoccerPlaceList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//예약 확정 
	public int SoccerPlaceReservation(int userNo, String timeNo, String placeNo, String reservationDate) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new SoccerPlaceDao().SoccerPlaceReservation(conn, userNo, timeNo, placeNo, reservationDate);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	//페이징처리
	public int allSoccerPlaceCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new SoccerPlaceDao().allSoccerPlaceCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}

	
	//
	public int reservationPlayer(String timeNo, String placeNo, String reservationDate) {

		Connection conn = JDBCTemplate.getConnection();
		
		int placePlayer = new SoccerPlaceDao().reservationPlayer(conn, timeNo, placeNo, reservationDate);
			
		return placePlayer;
	}

	
	//중복확인 
	public int SoccerPlaceDuplicate(int userNo, String timeNo, String placeNo, String reservationDate) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int duplicate = new SoccerPlaceDao().SoccerPlaceDuplicate(conn,userNo,timeNo,placeNo,reservationDate);
		
		JDBCTemplate.close(conn);
		
		return duplicate;
	}


	
	public int soccerTimeChk(int pno, String selectTime, String placeDate) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new SoccerPlaceDao().soccerTimeChk(conn, pno, selectTime, placeDate);
		
		JDBCTemplate.close(conn);
		
		return count;
		
	}

	//서울지역 페이징 count 
	public int allSeoulListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new SoccerPlaceDao().allSeoulListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}

	//서울지역 페이징 select
	public ArrayList<SoccerPlace> selectAllseoulPlaceList(String localName, PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SoccerPlace> list = new SoccerPlaceDao().selectAllseoulPlaceList(conn, localName, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//경기지역 페이징 count처리
	public int allGyeonggiListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new SoccerPlaceDao().allGyeonggiListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}


	//경기지역 select 처리 
	public ArrayList<SoccerPlace> selectAllgyeonggiPlaceList(String localName, PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SoccerPlace> list = new SoccerPlaceDao().selectAllgyeonggiPlaceList(conn, localName, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}


	//업데이트순 축구 리스트
	public ArrayList<SoccerPlace> selectUpdateSoccerPlaceList() {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SoccerPlace> list = new SoccerPlaceDao().selectUpdateSoccerPlaceList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	

	//업데이트순 축구 리스트
	public ArrayList<SoccerPlace> selectUpdateSoccerPlaceList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SoccerPlace> list = new SoccerPlaceDao().selectUpdateSoccerPlaceList(conn);
		JDBCTemplate.close(conn);
		return list;
	}



}
