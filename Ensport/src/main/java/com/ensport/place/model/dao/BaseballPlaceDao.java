package com.ensport.place.model.dao;

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
import com.ensport.place.model.vo.Place;
import com.ensport.place.model.vo.SoccerPlace;


public class BaseballPlaceDao {
	
	private Properties prop = new Properties();
	
	public BaseballPlaceDao() {
		String filePath = SoccerPlaceDao.class.getResource("/db/sql/place-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//페이징 처리
	public int allBaseballPlaceCount(Connection conn) {
		
		//SELECT (조회)
		int count = 0;
		ResultSet rset = null; //조회구문이기 때문에 필요
		Statement stmt = null; //위치홀더 필요없으니 statement 활용
		
					
		String sql = prop.getProperty("allBaseballPlaceCount");
					
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

	//경기장 전체 조회 
	public ArrayList<Place> selectAllBaseballPlaceList(Connection conn, PageInfo pi) {
		
		ResultSet rset =  null;
		PreparedStatement pstmt = null;	
		ArrayList<Place> list = new ArrayList<>();
		
		Place bp = null;
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
				
		String sql = prop.getProperty("selectAllBaseballPlaceList");
		
		try {

			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
		
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Place(rset.getInt("PLACE_NO")
									, rset.getString("PLACE_NAME")
									, rset.getString("FILE_PATH")
									, rset.getString("CHANGE_NAME")));
				
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

	//메소드 증가 메소드
	public int increaseBaseballCount(Connection conn, int placeNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseBaseballCount");
		
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

	public Place selectBaseballPlace(Connection conn, int placeNo) {
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Place bp = null;
		
		String sql = prop.getProperty("selectBaseballPlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bp = new Place (rset.getInt("PLACE_NO")
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
		
		return bp;
	}

	//축구시설 예약 상세조회 메소드
	public ArrayList<Attachment> selectBaseballAttachmentlist(Connection conn, int placeNo) {
		
		ArrayList<Attachment> list = new ArrayList<>();
		
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBaseballAttachmentlist");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, placeNo);
			
			rset=pstmt.executeQuery();
			
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

	//참여
	public int baseballreservationPlayer(Connection conn, String timeNo, String placeNo, String reservationDate) {
		
		int placePlayer = 0;
		
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("baseballreservationPlayer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, placeNo);
			pstmt.setString(2, reservationDate);
			pstmt.setString(3, timeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				placePlayer = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return placePlayer;
	}

	//중복확인
	public int baseballPlaceDuplicate(Connection conn, int userNo, String timeNo, String placeNo,
			String reservationDate) {
		
		int duplicate = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("baseballPlaceDuplicate");
		
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, timeNo);
			pstmt.setString(3,placeNo);
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

	//예약확정 데이터 보내기 
	public int baseballPlaceReservation(Connection conn, int userNo, String timeNo, String placeNo,
			String reservationDate) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("baseballPlaceReservation");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, timeNo);
			pstmt.setString(3,placeNo);
			pstmt.setString(4, reservationDate);
			 
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//자원반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//경기장 대여 인원마감 ajax 확인하기 
	public int baseballTimeChk(Connection conn, int pno, String selectTime, String placeDate) {
		
		//SELECT (조회)
		//예약이 되면 - 1행 반환
		//예약이 없는 경우 - 0행 반환
		int count = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("baseballTimeChk");
		
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			pstmt.setString(2, placeDate);
			pstmt.setString(3, selectTime);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}

	//서울지역 페이징 count 
	public int baseballSeoulListCount(Connection conn) {
		
		//SELECT (조회)
		int count = 0;
		ResultSet rset = null; //조회구문이기 때문에 필요
		Statement stmt = null; //위치홀더 필요없으니 statement 활용
		
					
		String sql = prop.getProperty("baseballSeoulListCount");
					
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

	//서울지역 페이징 SELECT 
	public ArrayList<Place> selectBaseballSeoulPlaceList(Connection conn, String localName, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		//게시글 목록 조회 리스트
		ArrayList<Place> list = new ArrayList<Place>();
		
		Place bp = null;
		
		String sql = prop.getProperty("selectBaseballSeoulPlaceList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setString(1, localName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				bp = new Place(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME")
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(bp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
				
		return list;
	}

	//경기지역 페이징 count처리
	public int baceballGyeonggiListCount(Connection conn) {
		
		//SELECT (조회)
		int count = 0;
		ResultSet rset = null; //조회구문이기 때문에 필요
		Statement stmt = null; //위치홀더 필요없으니 statement 활용
		
					
		String sql = prop.getProperty("baceballGyeonggiListCount");
					
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

	//경기지역 SELECT 처리
	public ArrayList<Place> selectBaseballgyeonggiPlaceList(Connection conn, String localName, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		//게시글 목록 조회 리스트
		ArrayList<Place> list = new ArrayList<Place>();
		
		Place bp = null;
		
		String sql = prop.getProperty("selectBaseballgyeonggiPlaceList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setString(1, localName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				bp = new Place(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME")
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(bp);
				
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
