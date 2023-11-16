package com.ensport.review.model.dao;

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
import com.ensport.reservation.model.vo.Reservation;
import com.ensport.review.model.vo.Review;

public class ReviewDao {

	
	private Properties prop = new Properties();
	
	public ReviewDao() {

		try {
			String filePath = ReviewDao.class.getResource("/db/sql/review-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	//마이페이지 - 내 리뷰 개수
	public int reviewListCount(Connection conn, int userNo) {
		
		// SELECT (조회)
		int count = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("reviewListCount");
		

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
	
	
	
	//마이페이지 - 내 리뷰 LIST
	public ArrayList<Reservation> selectMyReviewList(Connection conn, int userNo, PageInfo pi) {
		
			// 준비물
			ArrayList<Reservation> reviewList = new ArrayList<Reservation>();
			ResultSet rset = null;
			PreparedStatement pstmt = null;
			
			Reservation review = null;

			String sql = prop.getProperty("selectMyReviewList");
			
			
			System.out.println("pi:" + pi);
			
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
					
					review = new Reservation();
					
					review.setPlayerNo(rset.getInt("PLAYER_NO"));
					review.setReservationNo(rset.getInt("RESERVATION_NO"));
					review.setReservationDate(rset.getDate("RESERVATION_DATE"));
					review.setTimeNo(rset.getString("TIME_VALUE"));
					review.setPlaceNo(rset.getString("PLACE_NAME"));
					review.setReservationType(rset.getString("RESERVATION_TYPE"));
					review.setFixedYn(rset.getString("FIXED_YN"));
					review.setReviewNo(rset.getInt("REVIEW_NO"));
					review.setScore(rset.getInt("SCORE"));
					review.setReviewContent(rset.getString("REVIEW_CONTENT"));
//					review.setStatus(rset.getString("STATUS"));
					
					reviewList.add(review);
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


	

	// 마이페이지 - 내가 쓴 리뷰 상세보기
	public Review selectMyReviewDetail(Connection conn, int reviewNo) {
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		Review reviewDetail = null;

		String sql = prop.getProperty("selectMyReviewDetail");
		
		 
		try {
			
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, reviewNo);

			rset = pstmt.executeQuery();

			
			while (rset.next()) {
				
				reviewDetail = new Review();
				
				reviewDetail.setReviewNo(rset.getInt("REVIEW_NO"));
				reviewDetail.setScore(rset.getInt("SCORE"));
				reviewDetail.setReviewContent(rset.getString("REVIEW_CONTENT"));
				reviewDetail.setPlayerNo(rset.getInt("PLAYER_NO"));
				reviewDetail.setCreateDate(rset.getDate("CREATE_DATE"));
				reviewDetail.setStatus(rset.getString("STATUS"));
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return reviewDetail;
		
	}


	//23-11-13 마이페이지 - 내 리뷰 삭제하기
	public int deleteMyReview(Connection conn, int reviewNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMyReview");
		
			
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	
	
	//23-11-13 마이페이지 - 내 리뷰 등록하기
	public int insertMyReview(Connection conn, int score, String reviewContent, int playerNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMyReview");
		
			
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, score);
			pstmt.setString(2, reviewContent);
			pstmt.setInt(3, playerNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	

	//23-11-13 마이페이지 - 내 리뷰 수정하기
	public int updateMyReview(Connection conn, int reviewNo, int score, String reviewContent) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMyReview");
		
			
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, score);
			pstmt.setString(2, reviewContent);
			pstmt.setInt(3, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	//마이페이지 - reviewNo 조회하기
	public int selectMyReviewNo(Connection conn, int score, String reviewContent, int playerNo) {

		// SELECT (조회)
		int reviewNo = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("selectMyReviewNo");

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, score);
			pstmt.setString(2, reviewContent);
			pstmt.setInt(3, playerNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				// 조회된 reviewNo
				reviewNo = rset.getInt("REVIEW_NO");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return reviewNo;
	}

}
