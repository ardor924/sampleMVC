package com.sample2.model;

import java.util.Date;

public class MemberDTO {
	
	private int member_idx;
	private String member_id;
	private String member_pw;
	private String member_name;
	private Date member_birth;
	private String member_gender;
	private String member_email;
	private String member_tel;
	private Date member_regdate;

	
	public MemberDTO() {}


	public MemberDTO(int member_idx, String member_id, String member_pw, String member_name, Date member_birth,
			String member_gender, String member_email, String member_tel, Date member_regdate) {
		super();
		this.member_idx = member_idx;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_birth = member_birth;
		this.member_gender = member_gender;
		this.member_email = member_email;
		this.member_tel = member_tel;
		this.member_regdate = member_regdate;
	}


	public int getMember_idx() {
		return member_idx;
	}


	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getMember_pw() {
		return member_pw;
	}


	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public Date getMember_birth() {
		return member_birth;
	}


	public void setMember_birth(Date member_birth) {
		this.member_birth = member_birth;
	}


	public String getMember_gender() {
		return member_gender;
	}


	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}


	public String getMember_email() {
		return member_email;
	}


	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}


	public String getMember_tel() {
		return member_tel;
	}


	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}


	public Date getMember_regdate() {
		return member_regdate;
	}


	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}


	@Override
	public String toString() {
		return "MemberDTO [member_idx=" + member_idx + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_birth=" + member_birth + ", member_gender=" + member_gender
				+ ", member_email=" + member_email + ", member_tel=" + member_tel + ", member_regdate=" + member_regdate
				+ "]";
	};
	
	
	
	
}
