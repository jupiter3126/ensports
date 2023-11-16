package com.ensport.board.model.dao;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ensport.board.model.vo.Attachment;
import com.ensport.board.model.vo.Board;
import com.ensport.board.model.vo.Reply;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;

public class BoardDao {
	
	Properties prop = new Properties();
	
	public BoardDao() {
		
		
		String filePath = BoardDao.class.getResource("/db/sql/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<Board> selectBoardList(Connection conn, PageInfo pi) {
		
		//준비물
				ArrayList<Board> list = new ArrayList<>();
				ResultSet rset = null;
				PreparedStatement pstmt = null;
				
				String sql = prop.getProperty("selectBoardList");
				//1페이지 : 1~10 / 5페이지 : 41~50 / 10페이지 : 91~100
				//2페이지 : 11~20
				int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;  
				int endRow = pi.getCurrentPage() * pi.getBoardLimit();
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()){
						list.add(new Board(rset.getInt("BOARD_NO")
										  ,rset.getString("USER_NICKNAME")
										  ,rset.getString("BOARD_TITLE")
										  ,rset.getDate("CREATE_DATE")
										  ,rset.getInt("BOARD_COUNT")
										  ,rset.getInt("BOARD_TYPE")));
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

	public int insertBoard(Connection conn, Board b) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getUserNo());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, b.getBoardType());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public int increaseCount(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Board selectBoard(Connection conn, int boardNo) {
		Board b = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_NO")
						     ,rset.getString("USER_NICKNAME")
						     ,rset.getString("BOARD_TITLE")
						     ,rset.getString("BOARD_CONTENT")
						     ,rset.getDate("CREATE_DATE")
						     ,rset.getInt("BOARD_COUNT")
						     ,rset.getInt("BOARD_TYPE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return b;
	}

	public Attachment selectAttachment(Connection conn, int boardNo) {
		Attachment a = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				a = new Attachment(rset.getInt("AT_NO")
								  ,rset.getString("ORIGIN_NAME")
								  ,rset.getString("CHANGE_NAME")
								  ,rset.getString("FILE_PATH"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return a;
	}

	public int listCount(Connection conn) {
		//SELECT (조회)
				int count = 0;
				ResultSet rset = null; //조회구문이기 때문에 필요
				Statement stmt = null; //위치홀더 필요없으니 statement 활용
				
				String sql = prop.getProperty("listCount");
				
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

	public int updateBoard(Connection conn, Board b) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getAtNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertNewAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, at.getBoardNo());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertReply(Connection conn, Reply r) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getBoardNo());
			pstmt.setString(3, r.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Reply> selectReplyList(Connection conn, int bno) {
		
		ArrayList<Reply> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reply(rset.getInt("REPLY_NO")
								  ,rset.getString("USER_NICKNAME")
								  ,rset.getString("REPLY_CONTENT")
								  ,rset.getDate("CREATE_DATE")));
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
	

	public int deleteReply(int replyNo, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateReply(int replyNo, String content, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setInt(2, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	public int insertAttachmentList(Connection conn, ArrayList<Attachment> list) {
		
		//실행 후 받은 결과를 처리할 변수 (여러개를 처리하기 위해 1로 초기화해두기)
				int result3 = 1;
				PreparedStatement pstmt = null;
				String sql = prop.getProperty("insertAttachmentList");
				
				try {
					
					//list에 담겨진 각 Attachment를 꺼내서 각 데이터로 추가구문 작성하기
					//순차적으로 전부 접근하여 추출할 수 있도록 향상된 for문 사용
					for(Attachment at : list) {
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setString(1, at.getOriginName());
						pstmt.setString(2, at.getChangeName());
						pstmt.setString(3, at.getFilePath());
						
						//실행 후 받은 결과가 하나라도 0이 나오면 결과값을 0으로 만들기
						result3 *= pstmt.executeUpdate();
						
					}
					
				} catch (SQLException e) {
					//try구문에서 첫번째 처리에 실패가된다면 result2가 1로 전달되는것을 방지
					result3 = 0; 
					e.printStackTrace();
				}finally {
					JDBCTemplate.close(pstmt);
				}
				
				return result3;
		
	}

	public ArrayList<Attachment> selectAttachmentList(Connection conn, int boardNo) {
		
		ArrayList<Attachment> list = new ArrayList<>();
		ResultSet rset = null;
		String sql = prop.getProperty("selectImageAttachment");
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
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

	public int deleteAttachment(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
