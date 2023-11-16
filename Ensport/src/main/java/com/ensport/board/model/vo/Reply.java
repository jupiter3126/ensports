package com.ensport.board.model.vo;

import java.sql.Date;

public class Reply {
	
	private int replyNo;
	private int boardNo;
	private String userId;
	private String replyContent;
	private int likeNum;
	private int unlikeNum;
	private Date createDate;
	private String status;
	
	public Reply() {
		super();
	}

	public Reply(int replyNo, int boardNo, String userId, String replyContent, int likeNum, int unlikeNum,
			Date createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.userId = userId;
		this.replyContent = replyContent;
		this.likeNum = likeNum;
		this.unlikeNum = unlikeNum;
		this.createDate = createDate;
		this.status = status;
	}
	
	public Reply(int replyNo, String userId, String replyContent,Date createDate) {
		super();
		this.replyNo = replyNo;
		this.userId = userId;
		this.replyContent = replyContent;
		this.createDate = createDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getUnlikeNum() {
		return unlikeNum;
	}

	public void setUnlikeNum(int unlikeNum) {
		this.unlikeNum = unlikeNum;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", boardNo=" + boardNo + ", userId=" + userId + ", replyContent="
				+ replyContent + ", likeNum=" + likeNum + ", unlikeNum=" + unlikeNum + ", createDate=" + createDate
				+ ", status=" + status + "]";
	}
	
	
}	