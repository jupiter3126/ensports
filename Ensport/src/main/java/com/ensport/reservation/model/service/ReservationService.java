package com.ensport.reservation.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.ensport.common.JDBCTemplate;
import com.ensport.common.model.vo.PageInfo;
import com.ensport.qa.model.dao.QaDao;
import com.ensport.qa.model.vo.Qa;
import com.ensport.reservation.model.dao.ReservationDao;
import com.ensport.reservation.model.vo.Reservation;

public class ReservationService {

	// 마이페이지 내 Reservation 개수 조회 메소드
	public int reservationListCount(int userNo) {
		Connection conn = JDBCTemplate.getConnection();

		// 게시글 개수 받아줄 변수 준비
		int count = new ReservationDao().reservationListCount(conn, userNo);

		JDBCTemplate.close(conn);

		return count; // 게시글 개수 돌려주기
	}

	// 마이페이지 내 Reservation 불러오기
	public ArrayList<Reservation> selectMyReservationList(PageInfo pi, int userNo) {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Reservation> selectMyReservationList = new ReservationDao().selectMyReservationList(conn, userNo, pi);

		return selectMyReservationList;

	}

	// 총인원
	public int selectAll(int placeNo, String reservationDate, int timeNo) {

		Connection conn = JDBCTemplate.getConnection();
		int total = new ReservationDao().selectAll(conn, placeNo, reservationDate, timeNo);
		return total;
	}

	// 참여자
	public int selectPlayer(int placeNo, String reservationDate, int timeNo) {

		Connection conn = JDBCTemplate.getConnection();
		int player = new ReservationDao().selectPlayer(conn, placeNo, reservationDate, timeNo);
		return player;
	}

	// 예약 취소
	public int reservationCancel(int rvNo, int userNo) {

		Connection conn = JDBCTemplate.getConnection();

		int result = new ReservationDao().reservationCancel(conn, rvNo, userNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		return result;

	}
}
