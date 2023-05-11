package com.sample2.model;

public class FileDTO {

	
	private int fno;
	private String fName;
	private String fPath;
	
	
	// 기본 생성자
	public FileDTO() {}


	public FileDTO(int fno, String fName, String fPath) {
		super();
		this.fno = fno;
		this.fName = fName;
		this.fPath = fPath;
	}


	public int getFno() {
		return fno;
	}


	public void setFno(int fno) {
		this.fno = fno;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getfPath() {
		return fPath;
	}


	public void setfPath(String fPath) {
		this.fPath = fPath;
	}


	@Override
	public String toString() {
		return "FileDTO [fno=" + fno + ", fName=" + fName + ", fPath=" + fPath + "]";
	}


	
	
}
