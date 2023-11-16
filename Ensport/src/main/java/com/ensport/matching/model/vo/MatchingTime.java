package com.ensport.matching.model.vo;

import java.sql.Date;

public class MatchingTime {

	private int timeNo;
	private Date timeValue;
	
	public MatchingTime() {
		super();
	}
	public MatchingTime(int timeNo, Date timeValue) {
		super();
		this.timeNo = timeNo;
		this.timeValue = timeValue;
	}
	
	
	public int getTimeNo() {
		return timeNo;
	}
	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}
	public Date getTimeValue() {
		return timeValue;
	}
	public void setTimeValue(Date timeValue) {
		this.timeValue = timeValue;
	}
	@Override
	public String toString() {
		return "PlaceTime [timeNo=" + timeNo + ", timeValue=" + timeValue + "]";
	}
}
