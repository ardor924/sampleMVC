package com.sample2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample2.mapper.BoardMapper;
import com.sample2.mapper.MemberMapper;
import com.sample2.model.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired BoardMapper boardMapper;
	@Autowired MemberMapper memberMapper;
	
	
	// 게시글 등록 
	@Override
	public int insertPostingToDB(BoardDTO bDto) {		
		return boardMapper.insertPostingToDB(bDto);
	}
	
	
	// 게시글 전체 목록 조회
	@Override
	public List<BoardDTO> getAllBoardListFromDB() {	
		return boardMapper.getAllBoardListFromDB();
	}


	
	
	// 현재시간
	@Override
	public Date getNowDate() {
	
		Date nowDate = new Date();
		
		return nowDate;
	}


	// 조회수 증가
	@Override
	public int addHitUp(int board_hit) {
		
		int add_board_hit = board_hit+1;

		return add_board_hit;
	}






	
	
	
	
	
	
}
