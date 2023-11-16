package com.ensport.matching.model.vo;

import java.sql.Connection;
import java.util.Date;

public class BaseballMatching {

	private int placeNo;
	private String placeName;
	private String subInfo;
	private String placeSize;
	private String parkingYn;
	private Date date;
	private int count;
	private String placeStartTime;
	private String placeEndTime;
	private int maxCapacity;
	private int categoryNo;
	private String localName;
	private String filePath;
	private String changeName;
	public BaseballMatching() {
		super();
	}
	
	
	
	
	
	
	
	





	public BaseballMatching(int placeNo, String placeName, String filePath, String changeName) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.filePath = filePath;
		this.changeName = changeName;
	}













	public BaseballMatching(String placeName, String filePath, String changeName) {
		super();
		this.placeName = placeName;
		this.filePath = filePath;
		this.changeName = changeName;
	}








	public BaseballMatching(String filePath) {
		super();
		this.filePath = filePath;
	}








	public String getFilePath() {
		return filePath;
	}




	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}




	public BaseballMatching(int placeNo, String placeName, String subInfo, String placeSize, String parkingYn, Date date,
			int count, String placeStartTime, String placeEndTime, int maxCapacity, int categoryNo, String localName,
			String filePath, String changeName) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.subInfo = subInfo;
		this.placeSize = placeSize;
		this.parkingYn = parkingYn;
		this.date = date;
		this.count = count;
		this.placeStartTime = placeStartTime;
		this.placeEndTime = placeEndTime;
		this.maxCapacity = maxCapacity;
		this.categoryNo = categoryNo;
		this.localName = localName;
		this.filePath = filePath;
		this.changeName = changeName;
	}




	public BaseballMatching(String placeName, String changeName) {
		super();
		this.placeName = placeName;
		this.changeName = changeName;
	}




	public String getChangeName() {
		return changeName;
	}




	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}




	public BaseballMatching(int placeNo, String placeName, String subInfo, String placeSize, String parkingYn, Date date,
			int count, String placeStartTime, String placeEndTime, int maxCapacity, int categoryNo, String localName) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.subInfo = subInfo;
		this.placeSize = placeSize;
		this.parkingYn = parkingYn;
		this.date = date;
		this.count = count;
		this.placeStartTime = placeStartTime;
		this.placeEndTime = placeEndTime;
		this.maxCapacity = maxCapacity;
		this.categoryNo = categoryNo;
		this.localName = localName;
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
	public String getSubInfo() {
		return subInfo;
	}
	public void setSubInfo(String subInfo) {
		this.subInfo = subInfo;
	}
	public String getPlaceSize() {
		return placeSize;
	}
	public void setPlaceSize(String placeSize) {
		this.placeSize = placeSize;
	}
	public String getParkingYn() {
		return parkingYn;
	}
	public void setParkingYn(String parkingYn) {
		this.parkingYn = parkingYn;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPlaceStartTime() {
		return placeStartTime;
	}
	public void setPlaceStartTime(String placeStartTime) {
		this.placeStartTime = placeStartTime;
	}
	public String getPlaceEndTime() {
		return placeEndTime;
	}
	public void setPlaceEndTime(String placeEndTime) {
		this.placeEndTime = placeEndTime;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	@Override
	public String toString() {
		return "BaseballMatching [placeNo=" + placeNo + ", placeName=" + placeName + ", subInfo=" + subInfo
				+ ", placeSize=" + placeSize + ", parkingYn=" + parkingYn + ", date=" + date + ", count=" + count
				+ ", placeStartTime=" + placeStartTime + ", placeEndTime=" + placeEndTime + ", maxCapacity="
				+ maxCapacity + ", categoryNo=" + categoryNo + ", localName=" + localName + "]";
	}








	
	
	
	
}
