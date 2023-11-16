package com.ensport.reservation.model.vo;

import java.util.Date;

//예약[RESERVATION]
public class Reservation {
	
	private int reservationNo;
	private String timeNo;					//TIME_NAME 가져오기 위해 String 처리
	private String placeNo;					//PLACE_NAME 가져오기 위해 String 처리
	private String reservationType;
	private Date reservationDate;
	private String genderType;
	private	int userCapacity;

	
	//마이페이지용 예약여부 확인하기
	private String fixedYn;
	private int currentCount;
	
	
	//마이페이지용 Review 여부 확인
	private int playerNo;
	private int reviewNo;
	private int score;
	private String reviewContent;
	private String status;




	
	
	public Reservation(int userCapacity) {
		super();
		this.userCapacity = userCapacity;
	}


	public Reservation(int reservationNo, String timeNo, String placeNo, String reservationType, Date reservationDate,
			int userCapacity, String genderType, String fixedYn) {
		super();
		this.reservationNo = reservationNo;
		this.timeNo = timeNo;
		this.placeNo = placeNo;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.userCapacity = userCapacity;
		this.genderType = genderType;
		this.fixedYn = fixedYn;
	}

	public Reservation() {
		super();
	}

	
	

	public Reservation(int reservationNo, String timeNo, String placeNo) {
		super();
		this.reservationNo = reservationNo;
		this.timeNo = timeNo;
		this.placeNo = placeNo;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getTimeNo() {
		return timeNo;
	}

	public void setTimeNo(String timeNo) {
		this.timeNo = timeNo;
	}

	public String getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getUserCapacity() {
		return userCapacity;
	}

	public void setUserCapacity(int userCapacity) {
		this.userCapacity = userCapacity;
	}

	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	
	public String getFixedYn() {
		return fixedYn;
	}

	public void setFixedYn(String fixedYn) {
		this.fixedYn = fixedYn;
	}
	

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	
	
	
	//마이페이지 리뷰
	
	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	
	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	
	@Override
	public String toString() {
		return "Reservation [reservationNo=" + reservationNo + ", timeNo=" + timeNo + ", placeNo=" + placeNo
				+ ", reservationType=" + reservationType + ", reservationDate=" + reservationDate + ", userCapacity="
				+ userCapacity + ", genderType=" + genderType + ", fixedYn=" + fixedYn + "]";
	}

	
	

}



