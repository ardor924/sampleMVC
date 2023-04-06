package com.sample2.service;

import java.util.Date;
import java.util.List;

import com.sample2.model.BoardDTO;

public interface BoardService {

	// 게시글 등록 
	public int insertPostingToDB(BoardDTO bDto);
	
	// 게시글 전체 목록 조회
	public List<BoardDTO>getAllBoardListFromDB();
	
	// 현재시간
	public Date getNowDate();
	
	// 조회수증가
	public int addHitUp(int board_hit);
	

}
