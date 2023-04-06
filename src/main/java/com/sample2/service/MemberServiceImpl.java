package com.sample2.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample2.mapper.MemberMapper;
import com.sample2.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired MemberMapper memberMapper;

	
	// 회원가입
	@Override
	public int joinMembership(MemberDTO mDto) {
		
		return memberMapper.insertMemberToDB(mDto);
	}

	
	// 로그인
	@Override
	public MemberDTO loginMembership(MemberDTO mDto) {
	
		return memberMapper.getMemberInfoFromDB(mDto);
	}



	
	
	// 전체 회원목록 조회
	@Override
	public List<MemberDTO> getAllMemberList() {
		
		return memberMapper.getAllMemberInfoFromDB();
	}
	
	

	// 현재시간
	@Override
	public Date getNowDate() {
	
		Date nowDate = new Date();
		
		return nowDate;
	}


	// 문자열 날짜 변환	
	@Override
	public Date stringToDate(String strDate) {
		
		
		// 초기값 세팅
		Date date = null;
		
		try {
			// 포맷터
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			// 문자열 -> date
			date = sdf.parse(strDate);
			
		} catch (ParseException e) {
			System.out.println("문자열 변환에서 에러 발생!!");
		}
		
		return date;
	}


	

	
	
	

}
