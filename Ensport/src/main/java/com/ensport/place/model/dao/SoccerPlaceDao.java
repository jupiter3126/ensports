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
import com.ensport.matching.model.vo.SoccerMatching;
import com.ensport.place.model.vo.SoccerPlace;

public class SoccerPlaceDao {
	
	private Properties prop = new Properties();
	
	public SoccerPlaceDao() {
		String filePath = SoccerPlaceDao.class.getResource("/db/sql/place-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//축구경기장 목록 조회
	public ArrayList<SoccerPlace> selectSoccerPlaceList(Connection conn,String localName) {	
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		//게시글 목록 조회 리스트
		ArrayList<SoccerPlace> list = new ArrayList<SoccerPlace>();
		
		SoccerPlace sp = null;
		
		String sql = prop.getProperty("SoccerPlaceList");
		
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, localName);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				sp = new SoccerPlace(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME")
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(sp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return list;
	}

	//조회수 증가 메소드
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

	//축구시설예약 상세조회 메소드
	public ArrayList<Attachment> selectSoccerAttachmentlist(Connection conn, int placeNo) {
		
		ArrayList<Attachment> list = new ArrayList<>();
		
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAttachment");
		
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

	public SoccerPlace selectSoccerPlace(Connection conn, int placeNo) {
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		SoccerPlace ssp = null;
		
		String sql = prop.getProperty("selectSoccerPlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, placeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ssp = new SoccerPlace (rset.getInt("PLACE_NO")
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
		
		return ssp;
	}

	//경기장 전체조회
	public ArrayList<SoccerPlace> selectAllSoccerPlaceList(Connection conn, PageInfo pi) {

		ResultSet rset =  null;
		PreparedStatement pstmt = null;	
		ArrayList<SoccerPlace> list = new ArrayList<>();
		
		SoccerPlace sp = null;
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
				
		String sql = prop.getProperty("selectAllSoccerPlaceList");
		
		try {

			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
		
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new SoccerPlace(rset.getInt("PLACE_NO")
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
	
	

	//예약 확정 데이터 보내기 
	public int SoccerPlaceReservation(Connection conn, int userNo, String timeNo, String placeNo, String reservationDate) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("soccerPlaceReservation");
		
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
	
	
	
	//페이징처리
	public int allSoccerPlaceCount(Connection conn) {
		
			//SELECT (조회)
			int count = 0;
			ResultSet rset = null; //조회구문이기 때문에 필요
			Statement stmt = null; //위치홀더 필요없으니 statement 활용
			
						
			String sql = prop.getProperty("allSoccerPlaceCount");
						
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

	//구장대여 예약
	public int reservationPlayer(Connection conn, String timeNo, String placeNo, String reservationDate) {
		
		int placePlayer = 0;
		
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("reservationPlayer");
		
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
	public int SoccerPlaceDuplicate(Connection conn, int userNo, String timeNo, String placeNo,String reservationDate) {
		
		int duplicate = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("soccerPlaceDuplicate");
		
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

	
	
	//경기장 대여 인원마감 ajax 확인하기
	public int soccerTimeChk(Connection conn, int pno, String selectTime, String placeDate) {

		//SELECT (조회)
		//예약이 되면 - 1행 반환
		//예약이 없는 경우 - 0행 반환
		int count = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("soccerTimeChk");
		
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
	public int allSeoulListCount(Connection conn) {
		
		//SELECT (조회)
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

	//서울지역 페이징 select
	public ArrayList<SoccerPlace> selectAllseoulPlaceList(Connection conn, String localName, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		//게시글 목록 조회 리스트
		ArrayList<SoccerPlace> list = new ArrayList<SoccerPlace>();
		
		SoccerPlace sp = null;
		
		String sql = prop.getProperty("selectAllseoulPlaceList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setString(1, localName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				sp = new SoccerPlace(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME")
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(sp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
				
		return list;
	}

	//경기지역 페이징 count 처리
	public int allGyeonggiListCount(Connection conn) {
		
		//SELECT (조회)
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

	//경기지역 select 처리 
	public ArrayList<SoccerPlace> selectAllgyeonggiPlaceList(Connection conn, String localName, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		//게시글 목록 조회 리스트
		ArrayList<SoccerPlace> list = new ArrayList<SoccerPlace>();
		
		SoccerPlace sp = null;
		
		String sql = prop.getProperty("selectAllgyeonggiPlaceList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setString(1, localName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				sp = new SoccerPlace(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME")
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(sp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
				
		return list;
	}

	//업데이트 순 리스트
	public ArrayList<SoccerPlace> selectUpdateSoccerPlaceList(Connection conn) {
		
		Statement stmt = null;
		
		ResultSet rset = null;
		
		//게시글 목록 조회 리스트		
		ArrayList<SoccerPlace> list = new ArrayList<SoccerPlace>();
		
		SoccerPlace sp = null;
		
		String sql = prop.getProperty("selectUpdateSoccerPlaceList");
		
		try {
			stmt = conn.createStatement();		
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				
				sp = new SoccerPlace(rset.getInt("PLACE_NO")
										, rset.getString("PLACE_NAME") 
										, rset.getString("FILE_PATH")
										, rset.getString("CHANGE_NAME"));
				
				list.add(sp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
		
	}
		
}

	