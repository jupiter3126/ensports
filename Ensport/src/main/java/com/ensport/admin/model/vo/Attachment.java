package com.ensport.admin.model.vo;

import java.util.Date;

public class Attachment {

	private int atNo;
	private int refBno;
	private String originName;
	private String changeName;
	private Date uploadDate;
	private String filePath;
	private int fileLevel;
	private int fileType;

	

	public Attachment() {
		super();
	}

	public Attachment(int atNo, String originName, String changeName, int fileLevel) {
		super();
		this.atNo = atNo;
		this.originName = originName;
		this.changeName = changeName;
		this.fileLevel = fileLevel;
	}

	public Attachment(int atNo, String originName, String changeName, String filePath) {
		super();
		this.atNo = atNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}

	public Attachment(int atNo, int refBno, String originName, String changeName, String filePath) {
		super();
		this.atNo = atNo;
		this.refBno = refBno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}


	public Attachment(int atNo, int refBno, String originName, String changeName, Date uploadDate, String filePath,
			int fileLevel, int fileType) {
		super();
		this.atNo = atNo;
		this.refBno = refBno;
		this.originName = originName;
		this.changeName = changeName;
		this.uploadDate = uploadDate;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.fileType = fileType;
	}


	public int getFileType() {
		return fileType;
	}







	public void setFileType(int fileType) {
		this.fileType = fileType;
	}







	public int getFileLevel() {
		return fileLevel;
	}



	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}



	public int getAtNo() {
		return atNo;
	}

	public void setAtNo(int atNo) {
		this.atNo = atNo;
	}

	public int getRefBno() {
		return refBno;
	}

	public void setRefBno(int refBno) {
		this.refBno = refBno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	@Override
	public String toString() {
		return "Attachment [atNo=" + atNo + ", refBno=" + refBno + ", originName=" + originName + ", changeName="
				+ changeName + ", uploadDate=" + uploadDate + ", filePath=" + filePath + ", fileLevel=" + fileLevel
				+ ", fileType=" + fileType + "]";
	}




	
	
}
