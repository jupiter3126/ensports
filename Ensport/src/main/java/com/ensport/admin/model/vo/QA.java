package com.ensport.admin.model.vo;

import java.sql.Date;

public class QA {

	private int qa_no;
	private String user_nickname;
	private String qa_title;
	private String qa_content;
	private Date create_date;
	
	public QA() {
		super();
	}
	public QA(int qa_no, String user_nickname, String qa_title, String qa_content, Date create_date) {
		super();
		this.qa_no = qa_no;
		this.user_nickname = user_nickname;
		this.qa_title = qa_title;
		this.qa_content = qa_content;
		this.create_date = create_date;
	}
	public int getQa_no() {
		return qa_no;
	}
	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}
	
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getQa_title() {
		return qa_title;
	}
	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "QA [qa_no=" + qa_no + ", user_nickname=" + user_nickname + ", qa_title=" + qa_title + ", qa_content=" + qa_content
				+ ", create_date=" + create_date + "]";
	}
	
	
}
