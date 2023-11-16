package com.ensport.matching.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ensport.admin.model.vo.Attachment;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.matching.model.dao.BaseballMatchingDao;
import com.ensport.matching.model.dao.SoccerMatchingDao;
import com.ensport.matching.model.vo.BaseballMatching;
import com.ensport.matching.model.vo.SoccerMatching;
import com.ensport.place.model.vo.Place;
import com.ensport.review.model.vo.Review;



public class BaseballMatchingService {

	//페이징처리
	public int MatchingAllListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 개수 받아줄 변수 준비
		int count = new BaseballMatchingDao().MatchingAllListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return count; //게시글 개수 돌려주기
	}

	//야구경기 전체 리스트 조회
	public ArrayList<BaseballMatching> selectAllBaseballMatchingList(PageInfo pi) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<BaseballMatching> list = new BaseballMatchingDao().selectAllBaseballMatchingList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	
	//야구 매칭 지역별 목록 조회
	public ArrayList<BaseballMatching> selectBaseballMatchingList(String localName) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<BaseballMatching> list = new BaseballMatchingDao().selectBaseballMatchingList(conn,localName);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//야구 조회수 증가 메소드
	public int increaseCount(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BaseballMatchingDao().increaseCount(conn,placeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	//경기장 상세보기
	public Place selectPlace(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Place p = new BaseballMatchingDao().selectPlace(conn,placeNo);
		
		JDBCTemplate.close(conn);
		return p;
	}

	//야구 게시판 상세조회 메소드
	public ArrayList<Attachment> selectAttachmentList(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		//이미지가 여러개 일 수 있으니 
		ArrayList<Attachment> list = new BaseballMatchingDao().selectAttachmentLst(conn,placeNo);
		JDBCTemplate.close(conn);
		
		return list;
	}

	//야구 매칭 중복확인
	public int BaseballMatchingDuplicate(int userNo, int timeNo, int placeNo, String reservationDate) {
		Connection conn = JDBCTemplate.getConnection();
		int duplicate = new BaseballMatchingDao().BaseballMatchingDulicate(conn,userNo,timeNo,placeNo,reservationDate);
		
		JDBCTemplate.close(conn);
		return duplicate;
	}

	//야구 예약
	public int BaseballMatchingReservation(int userNo, int timeNo, int placeNo, String reservationDate) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BaseballMatchingDao().BaseballMatchingReservation(conn,userNo,timeNo,placeNo,reservationDate);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//리뷰 총점
	public int selectReviewSum(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int sum = new BaseballMatchingDao().selectReviewSum(conn,placeNo);
		JDBCTemplate.close(conn);
		return sum;
	}

	//리뷰 갯수
	public int selectReviewCount(int placeNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int count = new BaseballMatchingDao().selectReviewCount(conn,placeNo);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	//5점
	public int selectfiveStar(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int fiveStar = new BaseballMatchingDao().selectfiveStar(conn,placeNo);
		JDBCTemplate.close(conn);
		return fiveStar;
	}

	//4점
	public int selectfourStar(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int fourStar = new BaseballMatchingDao().selectfourStar(conn,placeNo);
		JDBCTemplate.close(conn);
		return fourStar;
	}

	//3점
		public int selectthreeStar(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			int threeStar = new BaseballMatchingDao().selectthreeStar(conn,placeNo);
			JDBCTemplate.close(conn);
			return threeStar;
		}
	

	//2점
	public int selectTwoStar(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int twoStar = new BaseballMatchingDao().selectTwoStar(conn,placeNo);
		JDBCTemplate.close(conn);
		return twoStar;
	}

	//1점
	public int selectOneStar(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int oneStar = new BaseballMatchingDao().selectOneStar(conn,placeNo);
		JDBCTemplate.close(conn);
		return oneStar;
	}

	//리뷰리스트
	public ArrayList<Review> selectReviewList(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Review> rlist = new BaseballMatchingDao().selectReviewList(conn,placeNo);
		
		JDBCTemplate.close(conn);
		
		return rlist;
	}

	//최신순
	public ArrayList<Review> selectRecentReview(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Review> rlist = new BaseballMatchingDao().selectRecentReview(conn,placeNo);
		JDBCTemplate.close(conn);
		return rlist;
	}

	//별점순
	public ArrayList<Review> selectStarReview(int placeNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Review> slist = new BaseballMatchingDao().selectStarReview(conn,placeNo);
		JDBCTemplate.close(conn);
		return slist;
	}

	//서울 지역 페이징 카운트
	public int allSeoulListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new BaseballMatchingDao().allSeoulCount(conn);
		JDBCTemplate.close(conn);
		return count;
	}

	//서울 페이징 select
	public ArrayList<BaseballMatching> selectAllSeoulSoccerMatchingList(String localName, PageInfo pi) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<BaseballMatching> list = new BaseballMatchingDao().selectAllSeoulSoccerMatchingList(conn,localName,pi);
		JDBCTemplate.close(conn);
		return list;
	}

	//경기 지역 페이징 카운트
	public int allGyeonggiListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new BaseballMatchingDao().allGyeonggiListCount(conn);
		JDBCTemplate.close(conn);
		return count;
	}

	//경기 페이징 select
	public ArrayList<BaseballMatching> selectAllGyeonggiSoccerMatchingList(String localName, PageInfo pi) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<BaseballMatching> list = new BaseballMatchingDao().selectAllGyeonggiSoccerMatchingList(conn,localName,pi);
		JDBCTemplate.close(conn);
		return list;
	}

	

	



}
