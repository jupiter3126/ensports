package com.ensport.admin.model.vo;

import java.sql.Date;

public class QAComment {

	private int qa_answer_no;
	private int user_no;
	private String qa_answer;
	private Date create_date;
	
	public QAComment() {
		super();
	}
	
	

	public QAComment(int qa_answer_no, String qa_answer, Date create_date) {
		super();
		this.qa_answer_no = qa_answer_no;
		this.qa_answer = qa_answer;
		this.create_date = create_date;
	}



	public QAComment(int qa_answer_no, int user_no, String qa_answer) {
		super();
		this.qa_answer_no = qa_answer_no;
		this.user_no = user_no;
		this.qa_answer = qa_answer;
	}



	public QAComment(int qa_answer_no, int user_no, String qa_answer, Date create_date) {
		super();
		this.qa_answer_no = qa_answer_no;
		this.user_no = user_no;
		this.qa_answer = qa_answer;
		this.create_date = create_date;
	}

	public int getQa_answer_no() {
		return qa_answer_no;
	}

	public void setQa_answer_no(int qa_answer_no) {
		this.qa_answer_no = qa_answer_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getQa_answer() {
		return qa_answer;
	}

	public void setQa_answer(String qa_answer) {
		this.qa_answer = qa_answer;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Override
	public String toString() {
		return "QAComment [qa_answer_no=" + qa_answer_no + ", user_no=" + user_no + ", qa_answer=" + qa_answer
				+ ", create_date=" + create_date + "]";
	}
	
	

}
