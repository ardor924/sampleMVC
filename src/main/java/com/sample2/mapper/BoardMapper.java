package com.sample2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample2.model.BoardDTO;

@Mapper
public interface BoardMapper {

	// 게시글 등록
	public int insertPostingToDB(BoardDTO bDto);
	
	// 게시글 전체 목록 조회
	public List<BoardDTO>getAllBoardListFromDB();
	
}
