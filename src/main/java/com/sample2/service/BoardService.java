package com.sample2.service;

import java.util.Date;
import java.util.List;

import com.sample2.model.BoardDTO;
import com.sample2.model.BoardPagingDTO;

public interface BoardService {

	// 게시글 등록 
	public int insertPostingToDB(BoardDTO bDto);
	
	// 게시글 전체 목록 조회(리팩토링A타입)
	public List<BoardDTO>getAllBoardListFromDB(BoardDTO bDto,BoardPagingDTO bp);
	
	// 게시판 정렬기능(리팩토링A타입)
	public String setOrderBy(BoardDTO bDto);
	
	// 글삭제
	public int deletePostingFromDB(BoardDTO bDto);
	
	// 게시판 페이지네이션
	public BoardPagingDTO setBoardPaging(int total_rows, int page_rows,int current_page);
	
	// 전체 게시글 갯수
	public int getTotalCnt(BoardDTO bDto);
	
	// 현재시간
	public Date getNowDate();
	
	// 조회수증가
	public void addHitUp(BoardDTO bDto);
	
	// PK값으로 게시글 정보 조회
	public BoardDTO getPostingFromDB(BoardDTO bDto);
	
	// 더미데이터 생성
	public BoardDTO dummy(BoardDTO bDto);

}
