package com.ensport.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ensport.admin.model.dao.AdminDao;
import com.ensport.admin.model.vo.Attachment;
import com.ensport.admin.model.vo.MonthRevenue;
import com.ensport.admin.model.vo.PieChart;
import com.ensport.admin.model.vo.Place;
import com.ensport.admin.model.vo.QA;
import com.ensport.admin.model.vo.QAComment;
import com.ensport.common.JDBCTemplate;
import com.ensport.member.model.vo.Member;
import com.ensport.review.model.vo.Review;

public class AdminService {

	public int placeEnroll(Place p, ArrayList<Attachment> list) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().placeEnroll(p,conn);
		
		int result2 = new AdminDao().insertPlacePhoto(list,conn);
		
		
		if(result*result2 > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;
	}

	public ArrayList<Place> selectPlaceList() {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Place> list = new AdminDao().selectPlaceList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public Place selectOnePlace(int placeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Place p = new AdminDao().selectOnePlace(placeNo,conn);
		
		JDBCTemplate.close(conn);
		
		return p;
	}


	public ArrayList<Attachment> selectOnePlaceAttachment(int placeNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Attachment> list = new AdminDao().selectOnePlaceAttachment(placeNo,conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int insertQA(int userNo, String subject, String message) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().insertQA(userNo,subject,message,conn);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;

	}

	public ArrayList<QA> selectQAList() {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<QA> list = new AdminDao().selectQAList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public QA selectOneQA(int qa_no) {

		Connection conn = JDBCTemplate.getConnection();
		
		QA q = new AdminDao().selectOneQA(conn, qa_no);
		
		JDBCTemplate.close(conn);
		

		return q;
	}

	public int insertQAComment(QAComment qac) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().insertQAComment(qac,conn);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;

	}

	public QAComment selectOneQAComment(int qa_answer_no) {


		Connection conn = JDBCTemplate.getConnection();
		
		QAComment qac = new AdminDao().selectOneQAComment(conn,qa_answer_no);
		
		JDBCTemplate.close(conn);
		
		return qac;
		
	}

	public int qaCommentUpdate(int qa_answer_no, String qa_answer) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().qaCommentUpdate(qa_answer_no,qa_answer,conn);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;
	}

	public int qaCommentDelete(int qa_answer_no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().qaCommentDelete(qa_answer_no,conn);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;
	}

	public int updatePlace(Place p, ArrayList<Attachment> list) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().updatePlace(conn,p);
		
		//첨부파일이 있으면 처리 후 값 담길 변수 준비
		//첨부파일이 없으면 게시글 처리만 하기 위해 1로 초기화
		int result2 = 1;
		for(Attachment at : list) {
			if(at!=null){//첨부파일이 있다면
				//기존 첨부파일이 있다면 (update) - fileNo 가 있는지 확인
				if(at.getAtNo() != 0) {
					result2 = new AdminDao().updatePlaceAttachment(conn,at);
				}else {//기존에 첨부파일이 없었다면 - insert
					//기존에 첨부파일 추가 메소드에서는 sql구문이
					//refBno(참조게시글번호) 부분이 currval (현재시퀀스번호)로 들어가 있어서 사용할 수 없다.
					//controller에서 가져온 boardNo 를 넣어서 추가하여야한다.
					
					result2 = new AdminDao().insertNewPlaceAttachment(conn,at);
				}
				
				
			}
			//게시글 수정과 첨부파일 수정 또는 추가 작업중 하나라도 잘못되었다면
			//되돌리기 작업을 수행하여야한다.
			
			if(result*result2>0) {//둘중하나라도 0이면 0일테니 성공여부 확인가능
				JDBCTemplate.commit(conn);
			}else {
				
				JDBCTemplate.rollback(conn);
			}
		}
		
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public void deleteUnselectedFile(int originFileNo) {


		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().deleteUnselectedFile(originFileNo,conn);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
	}

	public int deletePlace(int placeNo) {


		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().deletePlace(placeNo,conn);
		
		int result2 = new AdminDao().deletePlaceAttachment(placeNo,conn);
		
		if(result * result2 > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result * result2;
	}

	public ArrayList<Member> selectMemberList() {

		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new AdminDao().selectMemberList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public Member selectOneMember(int userNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new AdminDao().selectOneMember(conn,userNo);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	public int adminDeleteMember(int userNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().adminDeleteMember(userNo,conn);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int countMember() {
		
		Connection conn = JDBCTemplate.getConnection();

		int count = new AdminDao().countMember(conn);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	public int countPlace() {

		Connection conn = JDBCTemplate.getConnection();

		int count = new AdminDao().countPlace(conn);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	public int countReply() {
		Connection conn = JDBCTemplate.getConnection();

		int count = new AdminDao().countReply(conn);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	public ArrayList<Review> selectReviewList() {
		Connection conn = JDBCTemplate.getConnection();

		 ArrayList<Review> list = new AdminDao().selectReviewList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Integer> countAdminMember() {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Integer> list = new AdminDao().countAdminMember(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<PieChart> countGender() {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<PieChart> list = new AdminDao().countGender(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<MonthRevenue> calculateMonthlyRevenue() {
		
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<MonthRevenue> list = new AdminDao().calculateMonthlyRevenue(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	

	




}
