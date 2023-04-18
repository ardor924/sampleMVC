package com.sample2.model;

import java.util.Date;

public class BoardPagingDTO {
	

	// 게시판 기본요소
	private int board_idx;
	private String board_title;
	private String board_writer;
	private String board_contents;
	private Date board_regdate;
	private int board_hit;
	
	
	
	// 게시글수
	private int total_rows;
	private int page_rows;
	
	// 게시글 번호
	private int page_start_row_num;
	private int page_end_row_num;
	
	
	// 페이지
	private int current_page;
	private int total_page;
	private int block_start_page;
	private int block_end_page;
	private int block_prev_page;
	private int block_next_page;
	
	// 블럭
	private int current_block_location;
	private int block_lenth = 10;


	
	
	// 기본생성자
	public BoardPagingDTO() {};
	
	
	
	// 인자 생성자
	public BoardPagingDTO(int total_rows,int page_rows,int current_page) {
		
		this.total_rows = total_rows;
		this.page_rows = page_rows;
		this.current_page = current_page;
		
		
		calcValue(total_rows, page_rows);
		
	}
	
	
	// 페이지 계산
	public void calcValue(int toatal_rows, int page_rows) {
		
		
		// 전체 페이지수 (ex 총 게시글수가 265일때 : 반올림(265/10) = 27페이지)
		total_page = (int) Math.ceil((double)toatal_rows/page_rows);
		
		// 페이지당 시작번호 (ex 현재페이지가 24일때 : 24-1*10  = 230번)
		page_start_row_num = (current_page-1) * page_rows;		
		
		// 페이지당 끝번호 (ex 현재페이지가 24일때 : 24*10-1  = 239번)
		page_end_row_num = (current_page * page_rows)-1;		
		
		// 현재 블럭 위치 (ex 현재페이지가 30 일때 : (30-1)/10 = 2)
		current_block_location = (current_page-1)/block_lenth;				
		
		// 현재 블럭의 시작페이지 (ex : 현재 블럭이 2일때 : 2*10+1 = 21페이지)
		block_start_page = (current_block_location * block_lenth) + 1;
				
		// 현재 블럭의 끝페이지 (ex : 현재 블럭이 2일때 : 2+1*10 = 30페이지)
		block_end_page =  (current_block_location+1) * block_lenth;
		
		// 이전 블럭 페이지 (ex : 현재 블럭의 시작페이지가 21일때 : 21-1 = 20페이지)
		block_prev_page = block_start_page-1;
		
		// 다음 블럭 페이지 (ex : 현재 블럭의 끝페이지가 30일때 : 30+1 = 31페이지)
		block_next_page = block_end_page+1;
				
		// 블럭 끝페이지 예외 (ex : 전체 페이지수가 27일때 : 블럭의 끝페이지 = 전체 페이지수)
		if(block_end_page > total_page) block_end_page = total_page;
	
		// 다음 블럭 페이지 예외 (ex : 전체 페이지수가 27일때 : 다음 페이지 = 전체 페이지수)
		if(block_next_page>total_page) block_next_page = total_page;
		
		
	}



	
	// 게터세터
	public int getBoard_idx() {
		return board_idx;
	}



	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}



	public String getBoard_title() {
		return board_title;
	}



	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}



	public String getBoard_writer() {
		return board_writer;
	}



	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}



	public String getBoard_contents() {
		return board_contents;
	}



	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}



	public Date getBoard_regdate() {
		return board_regdate;
	}



	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}



	public int getBoard_hit() {
		return board_hit;
	}



	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}



	public int getTotal_rows() {
		return total_rows;
	}



	public void setTotal_rows(int total_rows) {
		this.total_rows = total_rows;
	}



	public int getPage_rows() {
		return page_rows;
	}



	public void setPage_rows(int page_rows) {
		this.page_rows = page_rows;
	}



	public int getPage_start_row_num() {
		return page_start_row_num;
	}



	public void setPage_start_row_num(int page_start_row_num) {
		this.page_start_row_num = page_start_row_num;
	}



	public int getPage_end_row_num() {
		return page_end_row_num;
	}



	public void setPage_end_row_num(int page_end_row_num) {
		this.page_end_row_num = page_end_row_num;
	}



	public int getCurrent_page() {
		return current_page;
	}



	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}



	public int getTotal_page() {
		return total_page;
	}



	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}



	public int getBlock_start_page() {
		return block_start_page;
	}



	public void setBlock_start_page(int block_start_page) {
		this.block_start_page = block_start_page;
	}



	public int getBlock_end_page() {
		return block_end_page;
	}



	public void setBlock_end_page(int block_end_page) {
		this.block_end_page = block_end_page;
	}



	public int getBlock_prev_page() {
		return block_prev_page;
	}



	public void setBlock_prev_page(int block_prev_page) {
		this.block_prev_page = block_prev_page;
	}



	public int getBlock_next_page() {
		return block_next_page;
	}



	public void setBlock_next_page(int block_next_page) {
		this.block_next_page = block_next_page;
	}



	public int getCurrent_block_location() {
		return current_block_location;
	}



	public void setCurrent_block_location(int current_block_location) {
		this.current_block_location = current_block_location;
	}



	public int getBlock_lenth() {
		return block_lenth;
	}



	public void setBlock_lenth(int block_lenth) {
		this.block_lenth = block_lenth;
	}



	@Override
	public String toString() {
		return "BoardPagingDTO [board_idx=" + board_idx + ", board_title=" + board_title + ", board_writer="
				+ board_writer + ", board_contents=" + board_contents + ", board_regdate=" + board_regdate
				+ ", board_hit=" + board_hit + ", total_rows=" + total_rows + ", page_rows=" + page_rows
				+ ", page_start_row_num=" + page_start_row_num + ", page_end_row_num=" + page_end_row_num
				+ ", current_page=" + current_page + ", total_page=" + total_page + ", block_start_page="
				+ block_start_page + ", block_end_page=" + block_end_page + ", block_prev_page=" + block_prev_page
				+ ", block_next_page=" + block_next_page + ", current_block_location=" + current_block_location
				+ ", block_lenth=" + block_lenth + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
