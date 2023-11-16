package com.ensport.admin.model.vo;

public class PieChart {

	private String genderName;
	private int genderCount;
	public PieChart() {
		super();
	}
	public PieChart(String genderName, int genderCount) {
		super();
		this.genderName = genderName;
		this.genderCount = genderCount;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public int getGenderCount() {
		return genderCount;
	}
	public void setGenderCount(int genderCount) {
		this.genderCount = genderCount;
	}
	@Override
	public String toString() {
		return "PieChart [genderName=" + genderName + ", genderCount=" + genderCount + "]";
	}
	
	
}
