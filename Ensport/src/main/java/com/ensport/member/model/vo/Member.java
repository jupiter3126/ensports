package com.ensport.member.model.vo;

import java.util.Date;


//회원
public class Member {

	private int userNo;
	private String userId;
	private String userPassword;
	private String userNickname;
	private String userName;
	private String email;
	private String phone;
	private Date enrolldate;
	private String gender;
	private String address;
	private String addressDetail;
	private String prefer;
	private String images;
	private String status;

	
	
	public Member() {
		super();
	}




	public Member(int userNo, String userNickname, Date enrolldate) {
		super();
		this.userNo = userNo;
		this.userNickname = userNickname;
		this.enrolldate = enrolldate;
	}




	public Member(int userNo, String userId, String userPassword, String userNickname, String userName, String email,
			String phone, Date enrolldate, String gender, String address, String addressDetail, String prefer,
			String images, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.enrolldate = enrolldate;
		this.gender = gender;
		this.address = address;
		this.addressDetail = addressDetail;
		this.prefer = prefer;
		this.images = images;
		this.status = status;
	}



	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Date getEnrolldate() {
		return enrolldate;
	}


	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrefer() {
		return prefer;
	}

	public void setPrefer(String prefer) {
		this.prefer = prefer;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddressDetail() {
		return addressDetail;
	}



	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}



	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPassword=" + userPassword + ", userNickname="
				+ userNickname + ", userName=" + userName + ", email=" + email + ", phone=" + phone + ", enrolldate="
				+ enrolldate + ", gender=" + gender + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", prefer=" + prefer + ", images=" + images + ", status=" + status + "]";
	}




}
