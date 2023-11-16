package com.ensport.matching.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import com.ensport.admin.model.vo.Attachment;

import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.matching.model.dao.SoccerMatchingDao;
import com.ensport.matching.model.vo.SoccerMatching;
import com.ensport.place.model.vo.Place;
import com.ensport.review.model.vo.Review;

public class SoccerMatchingService {

	//축국경기매칭 목록 조회
	public ArrayList<SoccerMatching> selectSoccerMatchingList(String localName) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SoccerMatching> list = new SoccerMatchingDao().selectSoccerMatchingList(conn,localName);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	//조회수 증가 메소드
		public int increaseCount(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new SoccerMatchingDao().increaseCount(conn,placeNo);
			
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			return result;
		}

		//게시글 개수 조회 메소드
		public int listCount() {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int count = new SoccerMatchingDao().listCount(conn);
			
			JDBCTemplate.close(conn);
			
			return count;
		}

		//게시판 상세조회 메소드
		public ArrayList<Attachment> selectAttachmentList(int placeNo) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			//이미지가 여러개 일 수 있으니 
			ArrayList<Attachment> list = new SoccerMatchingDao().selectAttachmentLst(conn,placeNo);
			JDBCTemplate.close(conn);
			
			return list;
			
		}

		//경기장 상세보기
		public Place selectPlace(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			
			Place p = new SoccerMatchingDao().selectPlace(conn,placeNo);
			
			JDBCTemplate.close(conn);
			return p;
		}

		//전체 경기장 리스트 조회
		public ArrayList<SoccerMatching> selectAllSoccerMatchingList(PageInfo pi) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			ArrayList<SoccerMatching> list = new SoccerMatchingDao().selectAllSoccerMatchingList(conn,pi);
			
			JDBCTemplate.close(conn);
			
			return list;
		}

		//인기 축구 리스트
		public ArrayList<SoccerMatching> selectMostSoccerMatchingList() {
			Connection conn = JDBCTemplate.getConnection();
			
			ArrayList<SoccerMatching> list = new SoccerMatchingDao().selectMostSoccerMatchingList(conn);
			
			JDBCTemplate.close(conn);
			
			return list;
		}

		//예약 확정
		public int SoccerMatchingReservation(int userNo, int timeNo, int placeNo, String reservationDate) {
		
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new SoccerMatchingDao().soccerMatchingReservation(conn,userNo,timeNo,placeNo,reservationDate);
			
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);
			
			return result;
		}

		//중복확인
		public int SoccerMatchingDuplicate(int userNo, int timeNo, int placeNo, String reservationDate) {
			
			Connection conn = JDBCTemplate.getConnection();
			int duplicate = new SoccerMatchingDao().soccerMatchingDulicate(conn,userNo,timeNo,placeNo,reservationDate);
			
			JDBCTemplate.close(conn);
			return duplicate;
		}

		//페이징 처리
		public int MatchingAllListCount() {
			Connection conn = JDBCTemplate.getConnection();
			
			//게시글 개수 받아줄 변수 준비
			int count = new SoccerMatchingDao().MatchingAllListCount(conn);
			
			JDBCTemplate.close(conn);
			
			return count; //게시글 개수 돌려주기
			
		}

		//리뷰 리스트
		public ArrayList<Review> selectReviewList(int placeNo) {

			Connection conn = JDBCTemplate.getConnection();
			
			ArrayList<Review> rlist = new SoccerMatchingDao().selectReviewList(conn,placeNo);
			
			JDBCTemplate.close(conn);
			
			return rlist;
		}

		//리뷰 갯수
		public int selectReviewCount(int placeNo) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int count = new SoccerMatchingDao().selectReviewCount(conn,placeNo);
			
			JDBCTemplate.close(conn);
			
			return count;
		}
		
		//서울 지역 페이징 카운트
		public int allSeoulListCount() {
			Connection conn = JDBCTemplate.getConnection();
			
			int count = new SoccerMatchingDao().allSeoulCount(conn);
			JDBCTemplate.close(conn);
			return count;
		}

		//서울지역 페이징 select
		public ArrayList<SoccerMatching> selectAllSeoulSoccerMatchingList(String localName, PageInfo pi) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<SoccerMatching> list = new SoccerMatchingDao().selectAllSeoulSoccerMatchingList(conn,localName,pi);
			JDBCTemplate.close(conn);
			return list;
		}

		//리뷰 총점
		public int selectReviewSum(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			int sum = new SoccerMatchingDao().selectReviewSum(conn,placeNo);
			JDBCTemplate.close(conn);
			return sum;
		}

		//별 5점 
		public int selectfiveStar(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			int fiveStar = new SoccerMatchingDao().selectfiveStar(conn,placeNo);
			JDBCTemplate.close(conn);
			return fiveStar;
		}

		//별 4점
		public int selectfourStar(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			int fourStar = new SoccerMatchingDao().selectfourStar(conn,placeNo);
			JDBCTemplate.close(conn);
			return fourStar;
		}

		//별 3점
		public int selectthreeStar(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			int threeStar = new SoccerMatchingDao().selectthreeStar(conn,placeNo);
			JDBCTemplate.close(conn);
			return threeStar;
		}

		//별 2점
		public int selectTwoStar(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			int twoStar = new SoccerMatchingDao().selectTwoStar(conn,placeNo);
			JDBCTemplate.close(conn);
			return twoStar;
		}

		//별 1점
		public int selectOneStar(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			int oneStar = new SoccerMatchingDao().selectOneStar(conn,placeNo);
			JDBCTemplate.close(conn);
			return oneStar;
		}

		
		//리뷰 최신순
		public ArrayList<Review> selectRecentReview(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<Review> rlist = new SoccerMatchingDao().selectRecentReview(conn,placeNo);
			JDBCTemplate.close(conn);
			return rlist;
		}

		//리뷰 별점순
		public ArrayList<Review> selectStarReview(int placeNo) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<Review> slist = new SoccerMatchingDao().selectStarReview(conn,placeNo);
			JDBCTemplate.close(conn);
			return slist;
		}

		//경기지역 페이징 select
		public ArrayList<SoccerMatching> selectAllGyeonggiSoccerMatchingList(String localName, PageInfo pi) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<SoccerMatching> list = new SoccerMatchingDao().selectAllGyeonggiSoccerMatchingList(conn,localName,pi);
			JDBCTemplate.close(conn);
			return list;
		}

		//경기 지역 페이징 카운트
		public int allGyeonggiListCount() {
			Connection conn = JDBCTemplate.getConnection();
			
			int count = new SoccerMatchingDao().allGyeonggiCount(conn);
			JDBCTemplate.close(conn);
			return count;
		}

	

		
		

		
		

}















