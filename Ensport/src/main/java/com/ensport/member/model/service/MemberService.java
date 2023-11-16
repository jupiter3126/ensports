package com.ensport.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ensport.board.model.vo.Board;
import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.member.model.dao.MemberDao;
import com.ensport.member.model.vo.Member;
import com.ensport.qa.model.dao.QaDao;
import com.ensport.qa.model.vo.Qa;
import com.ensport.reply.model.dao.ReplyDao;

public class MemberService {
	
	
	//로그인 
	public Member loginMember(String userId, String userPwd) {

		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	
	
	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	
	}

	
	//아이디 중복 확인(ajax)
	public int idDuplCheck(String checkId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().idDuplCheck(conn, checkId);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
	
	//휴대폰번호 중복 확인(ajax)
	public int phoneDuplCheck(String checkPhone) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().phoneDuplCheck(conn, checkPhone);
		
		JDBCTemplate.close(conn);
		
		return count;
	}





	//회원정보 수정 메소드
		public Member updateMember(Member m) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new MemberDao().updateMember(conn, m);
			
			Member updateMember = null;
			
			//처리된 행 수를 토대로 dml구문이니 트랜잭션 처리하기(commit/rollback)
			if(result > 0) {	//성공
				JDBCTemplate.commit(conn);		//확정(커밋)
				updateMember = new MemberDao().selectMember(conn, m.getUserNo());
				
				System.out.println("updateMember: " + updateMember);
				
			}else {				
				JDBCTemplate.rollback(conn);	//되돌리기(롤백)
			}
			
			//갱신정보 반환
			return updateMember;
		}
		
		
		
		
		//비밀번호 변경 메소드
		public Member chagePwd(int userNo, String userPwd, String newPwd) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new MemberDao().chagePwd(conn, userNo, userPwd, newPwd);
			
			Member updateMember = null;
			
			if(result > 0) {	//성공
				JDBCTemplate.commit(conn);
				
				//수정한 회원정보 조회하기
				updateMember = new MemberDao().selectMember(conn, userNo);
				
			}else {
				JDBCTemplate.rollback(conn);	//되돌리기
			}
			
			//트랜잭션 처리가 끝났으므로 Connection 반납하기
			JDBCTemplate.close(conn);
			
			return updateMember;		//변경된 회원정보 조회한 객체 반환
		}
	
		
		
		
		//회원 탈퇴
		public int deleteMember(int userNo, String userPwd) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new MemberDao().deleteMember(conn, userNo, userPwd);
			
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}

		
		
		//마이페이지 Board 개수 조회 메소드
		public int boardListCount(int userNo) {
			Connection conn = JDBCTemplate.getConnection();
			
			//게시글 개수 받아줄 변수 준비
			int count = new MemberDao().boardListCount(conn, userNo);
			
			JDBCTemplate.close(conn);
			
			return count; //게시글 개수 돌려주기
		}
		
		
		
		//마이페이지 Board 불러오기
		public ArrayList<Board> selectMyBoardList(PageInfo pi, int userNo) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			ArrayList<Board> selectMyBoardList = new MemberDao().selectMyBoardList(conn, userNo, pi);
			
			return selectMyBoardList;
					
		}

}
