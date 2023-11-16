package com.ensport.qa.model.vo;

import java.util.Date;

public class Qa {
	

	//QA
	private int qaNo;
	private String userNo;
	private String qaTitle;
	private String qaContent;
	private Date qaWriteDate;		//user 문의 작성 시간
   
	//QA Comment
	private int qaAnswerNo;
	private int userNoAdmin;
	private String qaAnswer;
	private Date qaAnswerDate;		//admin 답변 작성 시간
	
	
	public Qa() {
		super();
	}

	public Qa(int qaNo, String userNo, String qaTitle, String qaContent, Date qaWriteDate, int qaAnswerNo,
			int userNoAdmin, String qaAnswer, Date qaAnswerDate) {
		super();
		this.qaNo = qaNo;
		this.userNo = userNo;
		this.qaTitle = qaTitle;
		this.qaContent = qaContent;
		this.qaWriteDate = qaWriteDate;
		this.qaAnswerNo = qaAnswerNo;
		this.userNoAdmin = userNoAdmin;
		this.qaAnswer = qaAnswer;
		this.qaAnswerDate = qaAnswerDate;
	}
	
	

	public int getQaNo() {
		return qaNo;
	}

	public void setQaNo(int qaNo) {
		this.qaNo = qaNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

	public Date getQaWriteDate() {
		return qaWriteDate;
	}

	public void setQaWriteDate(Date qaWriteDate) {
		this.qaWriteDate = qaWriteDate;
	}

	public int getQaAnswerNo() {
		return qaAnswerNo;
	}

	public void setQaAnswerNo(int qaAnswerNo) {
		this.qaAnswerNo = qaAnswerNo;
	}

	public int getUserNoAdmin() {
		return userNoAdmin;
	}

	public void setUserNoAdmin(int userNoAdmin) {
		this.userNoAdmin = userNoAdmin;
	}

	public String getQaAnswer() {
		return qaAnswer;
	}

	public void setQaAnswer(String qaAnswer) {
		this.qaAnswer = qaAnswer;
	}

	public Date getQaAnswerDate() {
		return qaAnswerDate;
	}

	public void setQaAnswerDate(Date qaAnswerDate) {
		this.qaAnswerDate = qaAnswerDate;
	}

	
	@Override
	public String toString() {
		return "Qa [qaNo=" + qaNo + ", userNo=" + userNo + ", qaTitle=" + qaTitle + ", qaContent=" + qaContent
				+ ", qaWriteDate=" + qaWriteDate + ", qaAnswerNo=" + qaAnswerNo + ", userNoAdmin=" + userNoAdmin
				+ ", qaAnswer=" + qaAnswer + ", qaAnswerDate=" + qaAnswerDate + "]";
	}
	

}
