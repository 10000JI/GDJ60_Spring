package com.iu.s1.board;

public class BoardFileDTO {
	private Long FileNum;
	private Long Num;
	private String fileName;
	private String oriName;
	public Long getFileNum() {
		return FileNum;
	}
	public void setFileNum(Long fileNum) {
		FileNum = fileNum;
	}
	public Long getNum() {
		return Num;
	}
	public void setNum(Long num) {
		Num = num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	
}
