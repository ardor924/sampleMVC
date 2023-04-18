package com.sample2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample2.model.BoardDTO;

@Mapper
public interface BoardMapper {

	// 게시글 등록
	public int insertPostingToDB(BoardDTO bDto);
	
	// 게시글 전체 목록 조회
	public List<BoardDTO>getAllBoardListFromDB(BoardDTO bDto);
	
	// 글삭제
	public int deletePostingFromDB(BoardDTO bDto);
	
	// 전체 게시글 갯수 
	public int getTotalCntFromDB(BoardDTO boardDTO);
	
	// PK값으로 게시글 정보 조회
	public BoardDTO getPostingFromDB(BoardDTO boardDTO);
	
	// 조회수 증가
	public void addHitUp(BoardDTO boardDTO);
	
}
