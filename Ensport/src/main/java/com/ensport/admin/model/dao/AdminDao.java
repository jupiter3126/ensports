package com.ensport.admin.model.dao;

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
import com.ensport.admin.model.vo.MonthRevenue;
import com.ensport.admin.model.vo.PieChart;
import com.ensport.admin.model.vo.Place;
import com.ensport.admin.model.vo.QA;
import com.ensport.admin.model.vo.QAComment;
import com.ensport.common.JDBCTemplate;
import com.ensport.member.model.vo.Member;
import com.ensport.review.model.vo.Review;

public class AdminDao {

	public Properties prop = new Properties();
	
	public AdminDao() {
		
		String filePath = AdminDao.class.getResource("/db/sql/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int placeEnroll(Place p, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("placeEnroll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,p.getPlaceName());
			pstmt.setString(2,p.getPlace_size());
			pstmt.setString(3,p.getParking_yn());
			pstmt.setInt(4,p.getMax_capacity());
			pstmt.setInt(5,Integer.parseInt(p.getCategoryNo()));
			pstmt.setString(6,p.getLocalName());
			pstmt.setString(7,p.getPlace_sub_info());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	public int insertPlacePhoto(ArrayList<Attachment> list, Connection conn) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("insertPlacePhoto");
		
		try {
			for(Attachment a : list) {
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1,a.getOriginName());
				pstmt.setString(2,a.getChangeName());
				pstmt.setString(3,a.getFilePath());
				pstmt.setInt(4, a.getFileLevel());

				
				result *= pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = 0;
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Place> selectPlaceList(Connection conn) {

		ArrayList<Place> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("selectPlaceList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				
				list.add(new Place(rset.getInt("PLACE_NO")
								  ,rset.getString("PLACE_NAME")
								  ,rset.getString("PLACE_SUB_INFO")
								  ,rset.getString("PLACE_SIZE")
								  ,rset.getString("PARKING_YN")
								  ,rset.getDate("PLACE_DATE")
								  ,rset.getInt("PLACE_COUNT")
								  ,rset.getString("PLACE_START_TIME")
								  ,rset.getString("PLACE_END_TIME")
								  ,rset.getInt("MAX_CAPACITY")
								  ,rset.getString("CATEGORY_NAME")
								  ,rset.getString("LOCAL_NAME")));
				
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

	public Place selectOnePlace(int placeNo, Connection conn) {

		Place p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectOnePlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, placeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Place(rset.getInt("PLACE_NO")
						  ,rset.getString("PLACE_NAME")
						  ,rset.getString("PLACE_SUB_INFO")
						  ,rset.getString("PLACE_SIZE")
						  ,rset.getString("PARKING_YN")
						  ,rset.getDate("PLACE_DATE")
						  ,rset.getInt("PLACE_COUNT")
						  ,rset.getString("PLACE_START_TIME")
						  ,rset.getString("PLACE_END_TIME")
						  ,rset.getInt("MAX_CAPACITY")
						  ,rset.getString("CATEGORY_NO")
						  ,rset.getString("LOCAL_NAME"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}
	
	public ArrayList<Attachment> selectOnePlaceAttachment(int placeNo, Connection conn) {

		ArrayList<Attachment> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectOnePlaceAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, placeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Attachment(rset.getInt("AT_NO"),
										rset.getString("ORIGIN_NAME"),
									    rset.getString("CHANGE_NAME"),
									    rset.getInt("FILE_LEVEL")));
			}
			for(int i = 0; i<2; i++) {
				
				list.add(new Attachment());
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


	public int insertQA(int userNo, String subject, String message, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, subject);
			pstmt.setString(3, message);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<QA> selectQAList(Connection conn) {

		ArrayList<QA> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("selectQAList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			
			while(rset.next()) {
				list.add(new QA(rset.getInt("QA_NO")
								,rset.getString("USER_NICKNAME")
								,rset.getString("QA_TITLE")
								,rset.getString("QA_CONTENT")
								,rset.getDate("CREATE_DATE")));
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


	public QA selectOneQA(Connection conn, int qa_no) {

		QA q = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectOneQA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qa_no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new QA(rset.getInt("QA_NO")
						,rset.getString("USER_NICKNAME")
						,rset.getString("QA_TITLE")
						,rset.getString("QA_CONTENT")
						,rset.getDate("CREATE_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return q;
	}


	public int insertQAComment(QAComment qac, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQAComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qac.getQa_answer_no());
			pstmt.setInt(2, qac.getUser_no());
			pstmt.setString(3, qac.getQa_answer());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}


	public QAComment selectOneQAComment(Connection conn, int qa_answer_no) {

		QAComment qac = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectOneQAComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qa_answer_no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				qac = new QAComment(rset.getInt("QA_ANSWER_NO")
									,rset.getString("QA_ANSWER")
									,rset.getDate("CREATE_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return qac;
	}


	public int qaCommentUpdate(int qa_answer_no, String qa_answer, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("qaCommentUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qa_answer);
			pstmt.setInt(2, qa_answer_no);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int qaCommentDelete(int qa_answer_no, Connection conn) {

		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("qaCommentDelete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qa_answer_no);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updatePlace(Connection conn, Place p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,p.getPlaceName());
			pstmt.setString(2,p.getPlace_size());
			pstmt.setString(3,p.getParking_yn());
			pstmt.setInt(4,p.getMax_capacity());
			pstmt.setInt(5,Integer.parseInt(p.getCategoryNo()));
			pstmt.setString(6,p.getLocalName());
			pstmt.setString(7,p.getPlace_sub_info());
			pstmt.setInt(8, p.getPlaceNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updatePlaceAttachment(Connection conn, Attachment at) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePlaceAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setInt(3, at.getAtNo());
			pstmt.setInt(4, at.getFileLevel());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int insertNewPlaceAttachment(Connection conn, Attachment at) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewPlaceAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, at.getRefBno());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			pstmt.setInt(5, at.getFileLevel());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int deleteUnselectedFile(int originFileNo, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteUnselectedFile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, originFileNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int deletePlace(int placeNo, Connection conn) {


		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deletePlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, placeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int deletePlaceAttachment(int placeNo, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deletePlaceAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, placeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public ArrayList<Member> selectMemberList(Connection conn) {
		
		ArrayList<Member> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		Member m = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			
			while(rset.next()) {
				
				m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserNickname(rset.getString("USER_NICKNAME"));
				m.setEnrolldate(rset.getDate("ENROLLDATE"));
				
				list.add(m);
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


	public Member selectOneMember(Connection conn, int userNo) {

		Member m = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectOneMember");
		

			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, userNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					m = new Member();
					
					m.setUserNo(rset.getInt("USER_NO"));
					m.setUserId(rset.getString("USER_ID"));
					m.setUserPassword(rset.getString("USER_PASSWORD"));
					m.setUserNickname(rset.getString("USER_NICKNAME"));
					m.setUserName(rset.getString("USER_NAME"));
					m.setEmail(rset.getString("EMAIL"));
					m.setPhone(rset.getString("PHONE"));
					m.setEnrolldate(rset.getDate("ENROLLDATE"));
					m.setGender(rset.getString("GENDER"));
					m.setAddress(rset.getString("ADDRESS"));
					m.setPrefer(rset.getString("PREFER"));
					m.setImages(rset.getString("IMAGES"));
					m.setStatus(rset.getString("STATUS"));
					m.setAddressDetail(rset.getString("ADDRESS_DETAIL"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
	
		return m;
	}


	public int adminDeleteMember(int userNo, Connection conn) {


		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminDeleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int countMember(Connection conn) {

		int count = 0;
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("countMember");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				count = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return count;
	}


	public int countPlace(Connection conn) {

		int count = 0;
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("countPlace");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				count = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return count;
	}


	public int countReply(Connection conn) {

		int count = 0;
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("countReply");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				count = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return count;
	}


	public ArrayList<Review> selectReviewList(Connection conn) {
		
		ArrayList<Review> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("selectReviewList");
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("REVIEW_NO")
								   ,rset.getString("REVIEW_CONTENT")
								   ,rset.getDate("CREATE_DATE")
								   ,rset.getString("USER_NICKNAME")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


	public ArrayList<Integer> countAdminMember(Connection conn) {

		ArrayList<Integer> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("countAdminMember");
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(rset.getInt("count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


	public ArrayList<PieChart> countGender(Connection conn) {
		
		ArrayList<PieChart> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("countGender");
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new PieChart(rset.getString("GENDER")
									 ,rset.getInt("COUNT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


	public ArrayList<MonthRevenue> calculateMonthlyRevenue(Connection conn) {
		
		ArrayList<MonthRevenue> list = new ArrayList<>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("calculateMonthlyRevenue");
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new MonthRevenue(rset.getInt("MONTH")
										,rset.getInt("RESERVATION_COUNT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


}



