package com.ensport.admin.model.vo;

public class MonthRevenue {
	
	private int month;
	private int monthRevenue;
	public MonthRevenue() {
		super();
	}
	public MonthRevenue(int month, int monthRevenue) {
		super();
		this.month = month;
		this.monthRevenue = monthRevenue;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMonthRevenue() {
		return monthRevenue;
	}
	public void setMonthRevenue(int monthRevenue) {
		this.monthRevenue = monthRevenue;
	}
	@Override
	public String toString() {
		return "MonthRevenue [month=" + month + ", monthRevenue=" + monthRevenue + "]";
	}
	
	
}
