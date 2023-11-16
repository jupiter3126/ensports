package com.ensport.matching.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ensport.admin.model.vo.Attachment;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.matching.model.vo.BaseballMatching;
import com.ensport.matching.model.vo.SoccerMatching;
import com.ensport.place.model.vo.Place;
import com.ensport.review.model.vo.Review;

public class BaseballMatchingDao {

private Properties prop = new Properties();
	
	public BaseballMatchingDao() {
		String filePath = BaseballMatchingDao.class.getResource("/db/sql/basematching-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//페이징처리
	public int MatchingAllListCount(Connection conn) {
		//SELECT (조회)
		int count = 0;
		ResultSet rset = null; //조회구문이기 때문에 필요
		Statement stmt = null; //위치홀더 필요없으니 statement 활용
		
		String sql = prop.getProperty("MatchingAllListCount");
		
		try {
			stmt = conn.createStatement();
			
			//개수 조회
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				//조회된 게시글 개수
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return count; //게시글 개수 돌려주기
	}

	//전체 야구 경기장 리스트 조회
	public ArrayList<BaseballMatching> selectAllBaseballMatchingList(Connection conn,PageInfo pi) {
		ResultSet rset =  null;
		PreparedStatement pstmt = null;
		
		ArrayList<BaseballMatching> alist = new ArrayList(); 
		BaseballMatching bm = null;
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
	
		
		String sql = prop.getProperty("selectAllBaseballMatchingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bm = new BaseballMatching(rset.getInt("PLACE_NO")
											,rset.getString("PLACE_NAME") 
											,rset.getString("FILE_PATH")
											,rset.getString("CHANGE_NAME"));

				alist.add(bm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return alist;
	}

	//지역별 야구매치 목록 조회
	public ArrayList<BaseballMatching> selectBaseballMatchingList(Connection conn, String localName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//게시글 목록 조회 리스트
		ArrayList<BaseballMatching> slist = new ArrayList<BaseballMatching>();
		
		BaseballMatching bm = null;
		
		
		
		String sql = prop.getProperty("selectBaseballMatchingList");
		
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, localName);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				bm = new BaseballMatching(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME") 
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				slist.add(bm);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		for(BaseballMatching ssss : slist){
			System.out.println("리스트:" +  ssss);
		};
		
		return slist;
	}

	//야구 조회수
	public int increaseCount(Connection conn, int placeNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,placeNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	
		
		return result;
	}

	//야구 경기장 상세보기
	public Place selectPlace(Connection conn, int placeNo) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Place p = null;
		
		String sql = prop.getProperty("selectPlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Place (rset.getInt("PLACE_NO")
							  ,rset.getString("PLACE_NAME")
							  ,rset.getString("PLACE_SUB_INFO")
							  ,rset.getString("PLACE_SIZE")
							  ,rset.getString("PARKING_YN")
							  ,rset.getDate("PLACE_DATE")
							  ,rset.getString("PLACE_START_TIME")
							  ,rset.getString("PLACE_END_TIME")
							  ,rset.getInt("MAX_CAPACITY")
							  ,rset.getString("CATEGORY_NAME"));
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return p;
	}

	//야구 상세보기
	public ArrayList<Attachment> selectAttachmentLst(Connection conn, int placeNo) {
		ArrayList<Attachment> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Attachment(rset.getInt("AT_NO")
									   ,rset.getString("ORIGIN_NAME")
									   ,rset.getString("CHANGE_NAME")
									   ,rset.getString("FILE_PATH")));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	//야구 중복 예약 확인
	public int BaseballMatchingDulicate(Connection conn, int userNo, int timeNo, int placeNo, String reservationDate) {
		int duplicate = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("baseballMatchingDuplicate");
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, timeNo);
			pstmt.setInt(3,placeNo);
			pstmt.setString(4, reservationDate);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				duplicate = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return duplicate;
	}
	
	//야구예약
	public int BaseballMatchingReservation(Connection conn, int userNo, int timeNo, int placeNo,
			String reservationDate) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("baseballMatchingReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2,timeNo);
			pstmt.setInt(3, placeNo);
			pstmt.setString(4, reservationDate);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//리뷰 총점
	public int selectReviewSum(Connection conn, int placeNo) {
		int sum = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectReviewSum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				sum = rset.getInt("TOTAL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return sum;
	}

	//리뷰 카운트
	public int selectReviewCount(Connection conn, int placeNo) {
		int count = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectReviewCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

	//5점
	public int selectfiveStar(Connection conn, int placeNo) {
		int fiveStar = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectfiveStar");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				fiveStar = rset.getInt("FIVE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fiveStar;
	}

	//4점
	public int selectfourStar(Connection conn, int placeNo) {
		int fourStar = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectfourStar");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				fourStar = rset.getInt("FOUR");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fourStar;
	}

	//3점
	public int selectthreeStar(Connection conn, int placeNo) {
		int threeStar = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectthreeStar");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				threeStar = rset.getInt("THREE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return threeStar;
	}

	//2점
	public int selectTwoStar(Connection conn, int placeNo) {
		int twoStar = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selecttwoStar");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				twoStar = rset.getInt("TWO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return twoStar;
	}

	//1점
	public int selectOneStar(Connection conn, int placeNo) {
		int oneStar = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectoneStar");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				oneStar = rset.getInt("ONE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return oneStar;
	}

	//리뷰리스트
	public ArrayList<Review> selectReviewList(Connection conn, int placeNo) {
		ArrayList<Review> rlist = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rlist.add(new Review(rset.getInt("REVIEW_NO")
									
									,rset.getInt("SCORE")
									,rset.getString("REVIEW_CONTENT")
									,rset.getDate("CREATE_DATE")
									,rset.getString("USER_NICKNAME")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return rlist;
	}

	//최신순
	public ArrayList<Review> selectRecentReview(Connection conn, int placeNo) {
		ArrayList<Review> rlist = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectRecentReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rlist.add(new Review(rset.getInt("REVIEW_NO")
									,rset.getInt("SCORE")
									,rset.getString("REVIEW_CONTENT")
									,rset.getDate("CREATE_DATE")
									,rset.getString("USER_NICKNAME")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return rlist;
	}

	//별점순
	public ArrayList<Review> selectStarReview(Connection conn, int placeNo) {
		ArrayList<Review> slist = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectStarReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				slist.add(new Review(rset.getInt("REVIEW_NO")
						
						,rset.getInt("SCORE")
						,rset.getString("REVIEW_CONTENT")
						,rset.getDate("CREATE_DATE")
						,rset.getString("USER_NICKNAME")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return slist;
	}

	//서울지역 페이징 카운트
	public int allSeoulCount(Connection conn) {
		int count = 0;
		ResultSet rset = null; //조회구문이기 때문에 필요
		Statement stmt = null; //위치홀더 필요없으니 statement 활용
		
		String sql = prop.getProperty("allSeoulListCount");
		
		try {
			stmt = conn.createStatement();
			
			//개수 조회
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				//조회된 게시글 개수
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return count; //게시글 개수 돌려주기
	}

	//서울 지역 페이징 select
	public ArrayList<BaseballMatching> selectAllSeoulSoccerMatchingList(Connection conn, String localName, PageInfo pi) {
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		//게시글 목록 조회 리스트
		ArrayList<BaseballMatching> list = new ArrayList<>();
		
		BaseballMatching bm = null;
		
		String sql = prop.getProperty("selectAllseoulMatchingList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setString(1, localName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				bm = new BaseballMatching(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME")
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(bm);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
				
		return list;
	}

	//경기 페이징 카운트
	public int allGyeonggiListCount(Connection conn) {
		int count = 0;
		ResultSet rset = null; //조회구문이기 때문에 필요
		Statement stmt = null; //위치홀더 필요없으니 statement 활용
		
		String sql = prop.getProperty("allGyeonggiListCount");
		
		try {
			stmt = conn.createStatement();
			
			//개수 조회
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				//조회된 게시글 개수
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return count; //게시글 개수 돌려주기
	}

	//경기 페이징 select
	public ArrayList<BaseballMatching> selectAllGyeonggiSoccerMatchingList(Connection conn, String localName,
			PageInfo pi) {
PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		//게시글 목록 조회 리스트
		ArrayList<BaseballMatching> list = new ArrayList<>();
		
		BaseballMatching bm = null;
		
		String sql = prop.getProperty("selectAllgyeonggiMatchingList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setString(1, localName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				bm = new BaseballMatching(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME")
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(bm);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
				
		return list;
	}
	
}
