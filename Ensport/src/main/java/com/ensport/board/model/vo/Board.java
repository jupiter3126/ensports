package com.ensport.board.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNo;
	private String userNo;
	private String boardTitle;
	private String boardContent;
	private Date createDate;
	private int boardCount;
	private String status;
	private String adminYN;
	private int boardType;
	
	
	//마이페이지 REPLY용
	private int replyNo;
	private String replyContent;
	private Date replyCreateDate;
	
	
	
	public Board() {
		super();
	}

	public Board(int boardNo, String userNo, String boardTitle, String boardContent, Date createDate, int boardCount,
			String status, String adminYN) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.boardCount = boardCount;
		this.status = status;
		this.adminYN = adminYN;
	}
	

	public Board(int boardNo, String userNo, String boardTitle, Date createDate, int boardCount, int boardType) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.boardCount = boardCount;
		this.boardType = boardType;
	}
	
	

	public Board(String userNo, String boardTitle, String boardContent, int boardType) {
		super();
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardType = boardType;
	}

	public Board(int boardNo, String userNo, String boardTitle, String boardContent, Date createDate, int boardCount) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.boardCount = boardCount;
	}
	
	
	

	public Board(int boardNo, String userNo, String boardTitle, String boardContent, Date createDate, int boardCount,
			int boardType) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.boardCount = boardCount;
		this.boardType = boardType;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdminYN() {
		return adminYN;
	}

	public void setAdminYN(String adminYN) {
		this.adminYN = adminYN;
	}
	
	
	
	
	
	
	//reply
	public int getReplyNo() {
		return replyNo;
	}
	
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyCreateDate() {
		return replyCreateDate;
	}

	public void setReplyCreateDate(Date replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}

	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userNo=" + userNo + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", createDate=" + createDate + ", boardCount=" + boardCount + ", status=" + status
				+ ", adminYN=" + adminYN + "]";
	}
	
	
}
