package com.sample2.myapp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample2.model.BoardDTO;
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
		
		Date board_regdate = service.getNowDate();
		
		bDto.setBoard_regdate(board_regdate);		
		//bDto.setBoard_hit(0);
		
		service.insertPostingToDB(bDto);
		
		return "redirect:/boardListPage.do";
	}
	
	// 게시글 전체목록 (페이지)
	@RequestMapping("boardListPage.do")
	public String boardListPage(Model model) {
		
		List<BoardDTO> board_list = service.getAllBoardListFromDB();
		
		model.addAttribute("board_list", board_list);
		
		return "board/list";
	}
	
	
	
	// 더미데이터 생성
	@RequestMapping("dummy.do")
	public String dummy(BoardDTO bDto) {
	
		
		Date board_regdate = service.getNowDate();
		
		for(int dummy=1;dummy<=224;dummy++) {
			  
			bDto.setBoard_idx(dummy);
			bDto.setBoard_title("테스트"+dummy);
			bDto.setBoard_writer("관리자");
			bDto.setBoard_contents("테스트"+dummy); 
			bDto.setBoard_regdate(board_regdate);
			bDto.setBoard_hit(0);
			service.insertPostingToDB(bDto);

			  }
		
		return "redirect:/boardListPage.do";
	}
	
	
	
	
	
	
}
