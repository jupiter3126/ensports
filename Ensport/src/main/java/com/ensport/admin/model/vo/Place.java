package com.ensport.admin.model.vo;

import java.sql.Date;


public class Place {

	private int placeNo;
	private String placeName;
	private String place_sub_info;
	private String place_size;
	private String parking_yn;
	private Date place_date;
	private int place_count; 
	private String place_start_time;
	private String place_end_time;
	private int max_capacity;
	private String categoryNo;
	private String localName;
	
	public Place() {
		super();
	}

	public Place(String placeName, String place_sub_info, String place_size, String parking_yn, int max_capacity,
			String categoryNo, String localName) {
		super();
		this.placeName = placeName;
		this.place_sub_info = place_sub_info;
		this.place_size = place_size;
		this.parking_yn = parking_yn;
		this.max_capacity = max_capacity;
		this.categoryNo = categoryNo;
		this.localName = localName;
	}






	public Place(int placeNo, String placeName, String place_sub_info, String place_size, String parking_yn,
			int max_capacity, String categoryNo, String localName) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.place_sub_info = place_sub_info;
		this.place_size = place_size;
		this.parking_yn = parking_yn;
		this.max_capacity = max_capacity;
		this.categoryNo = categoryNo;
		this.localName = localName;
	}

	public Place(int placeNo, String placeName, String place_sub_info, String place_size, String parking_yn,
			Date place_date, int place_count, String place_start_time, String place_end_time, int max_capacity,
			String categoryNo, String localName) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.place_sub_info = place_sub_info;
		this.place_size = place_size;
		this.parking_yn = parking_yn;
		this.place_date = place_date;
		this.place_count = place_count;
		this.place_start_time = place_start_time;
		this.place_end_time = place_end_time;
		this.max_capacity = max_capacity;
		this.categoryNo = categoryNo;
		this.localName = localName;
	}

	
	

	public String getPlace_start_time() {
		return place_start_time;
	}


	public void setPlace_start_time(String place_start_time) {
		this.place_start_time = place_start_time;
	}


	public String getPlace_end_time() {
		return place_end_time;
	}


	public void setPlace_end_time(String place_end_time) {
		this.place_end_time = place_end_time;
	}


	public Date getPlace_date() {
		return place_date;
	}










	public void setPlace_date(Date place_date) {
		this.place_date = place_date;
	}










	public int getPlace_count() {
		return place_count;
	}










	public void setPlace_count(int place_count) {
		this.place_count = place_count;
	}










	public int getPlaceNo() {
		return placeNo;
	}





	public void setPlaceNo(int placeNo) {
		this.placeNo = placeNo;
	}





	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}

	public String getPlace_size() {
		return place_size;
	}

	public void setPlace_size(String place_size) {
		this.place_size = place_size;
	}

	public String getParking_yn() {
		return parking_yn;
	}

	public void setParking_yn(String parking_yn) {
		this.parking_yn = parking_yn;
	}

	public String getPlace_sub_info() {
		return place_sub_info;
	}

	public void setPlace_sub_info(String place_sub_info) {
		this.place_sub_info = place_sub_info;
	}


	@Override
	public String toString() {
		return "Place [placeNo=" + placeNo + ", placeName=" + placeName + ", place_sub_info=" + place_sub_info
				+ ", place_size=" + place_size + ", parking_yn=" + parking_yn + ", place_date=" + place_date
				+ ", place_count=" + place_count + ", place_start_time=" + place_start_time + ", place_end_time="
				+ place_end_time + ", max_capacity=" + max_capacity + ", categoryNo=" + categoryNo + ", localName="
				+ localName + "]";
	}











	


	


	
	
}
