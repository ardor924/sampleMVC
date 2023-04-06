package com.sample2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample2.model.MemberDTO;

@Mapper
public interface MemberMapper {

	
	// 회원가입
	// 입력한정보를 DB에 등록
	public int insertMemberToDB(MemberDTO mDto);
	
	// 전체 회원 목록 조회
	public List<MemberDTO> getAllMemberInfoFromDB();

	// 로그인
	// 입력한정보와 일치하는 회원정보를 DB에서 조회
	public MemberDTO getMemberInfoFromDB(MemberDTO mDto);
	
	
}
