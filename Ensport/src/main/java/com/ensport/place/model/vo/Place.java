package com.ensport.place.model.vo;
import java.util.Date;
public class Place {
	
	private int placeNo;
	private String placeName;
	private String subInfo;
	private String placeSize;
	private String parkingYn;
	private Date placeDate;
	private int placeCount;
	private String startTime;
	private String endTime;
	private int maxCapacity;
	private String categoryName;
	private String localName;
	private String filePath;
	private String changeName;
	
	public Place() {
		super();
	}

	public Place(int placeNo, String placeName, String subInfo, String placeSize, String parkingYn, Date placeDate,
			int placeCount, String startTime, String endTime, int maxCapacity, String categoryName, String localName,
			String filePath, String changeName) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.subInfo = subInfo;
		this.placeSize = placeSize;
		this.parkingYn = parkingYn;
		this.placeDate = placeDate;
		this.placeCount = placeCount;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxCapacity = maxCapacity;
		this.categoryName = categoryName;
		this.localName = localName;
		this.filePath = filePath;
		this.changeName = changeName;
	}
	
	public Place(int placeNo, String placeName, String subInfo, String placeSize, String parkingYn,
			Date placeDate, String startTime, String endTime, int maxCapacity, String categoryName) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.subInfo = subInfo;
		this.placeSize = placeSize;
		this.parkingYn = parkingYn;
		this.placeDate = placeDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxCapacity = maxCapacity;
		this.categoryName = categoryName;
	}

	public Place(int placeNo, String placeName, String filePath, String changeName ) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.filePath = filePath;
		this.changeName = changeName;
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

	public Date getPlaceDate() {
		return placeDate;
	}

	public void setPlaceDate(Date placeDate) {
		this.placeDate = placeDate;
	}

	public int getPlaceCount() {
		return placeCount;
	}

	public void setPlaceCount(int placeCount) {
		this.placeCount = placeCount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	@Override
	public String toString() {
		return "Place [placeNo=" + placeNo + ", placeName=" + placeName + ", subInfo=" + subInfo + ", placeSize="
				+ placeSize + ", parkingYn=" + parkingYn + ", placeDate=" + placeDate + ", placeCount=" + placeCount
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", maxCapacity=" + maxCapacity
				+ ", categoryName=" + categoryName + ", localName=" + localName + ", filePath=" + filePath
				+ ", changeName=" + changeName + "]";
	}  
	
	
	
	
	
}