package com.sample2.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample2.mapper.BoardMapper;
import com.sample2.mapper.MemberMapper;
import com.sample2.model.BoardDTO;
import com.sample2.model.BoardPagingDTO;

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
	public List<BoardDTO> getAllBoardListFromDB(BoardDTO bDto,BoardPagingDTO bp) {	
		
		int page_rows = bp.getPage_rows();
		int page_start_row_num =  bp.getPage_start_row_num(); 
		int page_end_row_num =  bp.getPage_end_row_num(); 
		
		System.out.println("page_rows : "+page_rows);
		System.out.println("page_start_row_num : "+page_start_row_num);
		System.out.println("page_end_row_num : "+page_end_row_num);
		
		bDto.setPage_rows(page_rows);
		bDto.setPage_start_row_num(page_start_row_num);

		
		
		return boardMapper.getAllBoardListFromDB(bDto);
	}
	
	// 글삭제
	@Override
	public int deletePostingFromDB(BoardDTO bDto) {
		return boardMapper.deletePostingFromDB(bDto);
	}





	
	
	// 게시판 페이지 네이션
	@Override
	public BoardPagingDTO setBoardPaging(int total_rows, int page_rows, int current_page) {

		
		BoardPagingDTO bp = new BoardPagingDTO(total_rows, page_rows, current_page);
		
		
		
		
		System.out.println("total_rows : "+total_rows);
		System.out.println("page_rows : "+page_rows);
		System.out.println("current_page : "+current_page);
		System.out.println("------------------------ : ");

		return bp;
	}



	
	// 게시판 정렬기능
	@Override
	public String setOrderBy(BoardDTO bDto) {
		
		String order_by = bDto.getOrder_by();		
		System.out.println("order_by : "+order_by);
		System.out.println("------------------------ : ");
		
		return order_by;
	}
	
	
	
	
	// 게시글 전체 갯수
	@Override
	public int getTotalCnt(BoardDTO bDto) {		
		return boardMapper.getTotalCntFromDB(bDto);
	}


	
	
	
	// 현재시간
	@Override
	public Date getNowDate() {
	
		Date nowDate = new Date();
		
		return nowDate;
	}


	// 조회수 증가
	@Override
	public void addHitUp(BoardDTO bDto) {
		
		// 필요 파라미터 추출
		int board_hit = bDto.getBoard_hit();	
		System.out.println("board_hit : "+board_hit);
		
		// 조회수 증가식
		int addHit = board_hit+1;
		System.out.println("addHit : "+addHit);
		
		// 수정한 파라미터 세팅
		bDto.setBoard_hit(addHit);
		
		// 조회수 증가(DB update)
		boardMapper.addHitUp(bDto);
		
	}
	
	// PK값으로 게시글 정보 조회
	@Override
	public BoardDTO getPostingFromDB(BoardDTO bDto) {
		
		String keyword= bDto.getKeyword();
		String search_ype = bDto.getSearch_type();
		
		bDto = boardMapper.getPostingFromDB(bDto);
		
		bDto.setKeyword(keyword);
		bDto.setSearch_type(search_ype);
		
		return bDto;
	}

	// 더미데이터 생성
	@Override
	public BoardDTO dummy(BoardDTO bDto) {
		

		for(int dummy = 1; dummy <= 264; dummy++) {
			
		bDto.setBoard_title("테스트"+dummy);	
		bDto.setBoard_writer("관리자");	
		bDto.setBoard_contents("더미데이터"+dummy);
		bDto.setBoard_regdate(getNowDate());
		bDto.setBoard_hit(0);
		
		boardMapper.insertPostingToDB(bDto);
		
		}
	
		return bDto;
	}

	/*----------------파일------------------*/
	// 폴더용 날짜포맷
	@Override
	public String getFolderDate() {
		
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(nowDate);
		
		return strDate;
	}











	
	
	
	
	
	
}
