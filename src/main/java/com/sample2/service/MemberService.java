package com.sample2.service;

import java.util.Date;
import java.util.List;

import com.sample2.model.MemberDTO;

public interface MemberService {

	// 회원가입 (DB등록)
	public int joinMembership(MemberDTO mDto);
	
	// 전체 회원 목록 조회
	public List<MemberDTO> getAllMemberList();
	
	
	
	// 로그인
	public MemberDTO loginMembership(MemberDTO mDto);
	
	
	// 현재시간
	public Date getNowDate();
	
	// 문자열 날짜 변환	
	public Date stringToDate(String strDate);
	
}
