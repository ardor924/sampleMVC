package com.sample2.model;

public class BoardPagingDTO {
	
	// 기본 게시판 요소
	private int board_idx;
	private String board_title;
	private String board_writer;
	private String board_contents;
	private String board_regdate;
	private int board_hit;
	
	
	// 페이지	
	private int start_page; 	            // 시작페이지 (게시글1개당 1페이지로 계산) 
	private int prev_page; 		            // 이전페이지로
	private int current_page; 	            // 현재페이지로
	private int next_page; 		            // 다음페이지로
	private int total_page;		            // 전체페이지

	
	// 블럭	
	private int start_block; 				//	시작블럭
	private int end_block; 					//	끝블럭	
	private int current_block;				//  현재 블럭위치
	private int block_size = 10; 			//  표시할 블록의갯수
	
	
	// 게시글수
	private int page_cnt;					// 페이지당 게시글수
	private int total_cnt;					// 전체 게시글수
	
	// 시작번호
	private int start_idx;					// 페이지별 시작번호
	
	
	// 기본생성자
	public BoardPagingDTO(){};
	
	
	// 인자 생성자
	public BoardPagingDTO(int total_cnt, int page_cnt, int current_page) { // 전체게시글갯수 , 페이지당게시글갯수, 현제 페이지
		this.total_cnt = total_cnt;
		this.page_cnt = page_cnt;
		this.current_page = current_page;
		
		// 객체 생성시에 paging 처리 계산
		setValue(total_cnt, page_cnt);
		
	};
	
	
	// 계산
	public void setValue(int total_cnt,int page_cnt) {
		
		// 전체페이지
		this.total_page = (int) Math.ceil((double)total_cnt/page_cnt);
		// 시작페이지 				[ ex : (현재페이지15 - 1)*페이지당갯수10 = 140번째게시글 페이지 ]
		this.start_page = (current_page-1)*page_cnt;
		// 현재 블럭위치
		this.current_block = (current_page-1)/block_size;
		// 시작블럭
		this.start_block = (block_size*current_block)+1;
		// 끝블럭
		this.end_block = start_block + (block_size - 1); 
		
	};
	
	
}
