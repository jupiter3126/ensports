package com.ensport.reservation.model.vo;

public class Player {
	
	private int platerNo;
	private int userNo;
	private int reservationNo;
	private String fixedYn;
	
	public Player() {
		super();
	}

	public Player(int platerNo, int userNo, int reservationNo, String fixedYn) {
		super();
		this.platerNo = platerNo;
		this.userNo = userNo;
		this.reservationNo = reservationNo;
		this.fixedYn = fixedYn;
	}

	public int getPlaterNo() {
		return platerNo;
	}

	public void setPlaterNo(int platerNo) {
		this.platerNo = platerNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getFixedYn() {
		return fixedYn;
	}

	public void setFixedYn(String fixedYn) {
		this.fixedYn = fixedYn;
	}

	@Override
	public String toString() {
		return "Player [platerNo=" + platerNo + ", userNo=" + userNo + ", reservationNo=" + reservationNo + ", fixedYn="
				+ fixedYn + "]";
	}
	
	

}
