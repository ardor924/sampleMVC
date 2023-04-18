package com.sample2.myapp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample2.model.BoardDTO;
import com.sample2.model.BoardPagingDTO;
import com.sample2.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService service;
	
	
	// 게시글 작성 (페이지)
	@RequestMapping("boardWritingPage.do")
	public String boardWritingPage() {
		return "board/writing";
	}
	
	
	// 게시글 작성 (DB등록)
	@RequestMapping("writingInsert.do")
	public String writingInsert(BoardDTO bDto) {
		
		// 등록일자 생성
		Date board_regdate = service.getNowDate();
		
		bDto.setBoard_regdate(board_regdate);		
		//bDto.setBoard_hit(0);
		
		service.insertPostingToDB(bDto);
		
		return "redirect:/boardListPage.do";
	}
	
	// 게시글 전체목록 (페이지 ,DB조회)
	@RequestMapping("boardListPage.do")
	public String boardListPage(HttpSession session,
			@RequestParam(defaultValue = "1") int current_page,
			@RequestParam(defaultValue = "10") int page_rows,
			@ModelAttribute("bDto") BoardDTO bDto, Model model){
		
		
		// 전체 페이지 가져오기
		int total_rows = service.getTotalCnt(bDto);
		

		// 게시판 페이지네이션
		BoardPagingDTO bp = service.setBoardPaging(total_rows,page_rows,current_page);
		
		
		
		// 게시판 전체 목록 조회
		List<BoardDTO> board_list = service.getAllBoardListFromDB(bDto,bp);
		
		
		// 게시판정렬
		String order_by = service.setOrderBy(bDto);
		
		
		
		// 파라미터 전달
		model.addAttribute("bp", bp);
		model.addAttribute("board_list", board_list);
		session.setAttribute("order_by", order_by);
		session.setAttribute("bDto", bDto);
		
		return "board/list";
	}
	
	
	
	// 게시글 보기(DB 조회)
	@RequestMapping("boardViewPage.do")
	public String boardViewPage(BoardDTO bDto,BoardPagingDTO bp, Model model) {
		

		// PK값으로 게시글 정보 조회(select)
		bDto = service.getPostingFromDB(bDto);
		
		// 조회수 증가(update)
		service.addHitUp(bDto);
		
		// 파라미터 전달 
		model.addAttribute("bDto", bDto);
		model.addAttribute("bp", bp);

		return "board/view";
	}
	
	
	
	// 글삭제 (DB삭제)
	@RequestMapping("delPosting.do")
	public String delPosting(BoardDTO bDto) {
		service.deletePostingFromDB(bDto);
		return "redirect:/boardListPage.do";
	}
	
	
	
	
	// 더미데이터 생성
	@RequestMapping("dummy.do")
	public String dummy(BoardDTO bDto) {	
		service.dummy(bDto);		
		return "redirect:/boardListPage.do";
	}
	
	
	
	
	
	
}
