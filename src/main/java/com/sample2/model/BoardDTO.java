package com.sample2.model;

import java.util.Date;

public class BoardDTO {
	
	
	// 기본 게시판 요소
	private int board_idx;
	private String board_title;
	private String board_writer;
	private String board_contents;
	private Date board_regdate;
	private int board_hit;
	
	// 페이징
	private int page_rows;
	private int page_start_row_num;
	private int current_page;
	
	
	// 게시판 정렬
	private String order_by; // 게시판 정렬
	
	
	// 게시판 검색
	private String search_type; // 작성자 제목 내용 검색
	private String keyword; // 검색키워드
	
	
	// 기본생성자
	public BoardDTO() {}


	public BoardDTO(int board_idx, String board_title, String board_writer, String board_contents, Date board_regdate,
			int board_hit, int page_rows, int page_start_row_num,int current_page, String order_by, String search_type, String keyword) {
		super();
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_writer = board_writer;
		this.board_contents = board_contents;
		this.board_regdate = board_regdate;
		this.board_hit = board_hit;
		this.page_rows = page_rows;
		this.page_start_row_num = page_start_row_num;
		this.current_page = current_page;
		this.order_by = order_by;
		this.search_type = search_type;
		this.keyword = keyword;
	}


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


	public int getCurrent_page() {
		return current_page;
	}


	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}


	public String getOrder_by() {
		return order_by;
	}


	public void setOrder_by(String order_by) {
		this.order_by = order_by;
	}


	public String getSearch_type() {
		return search_type;
	}


	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	@Override
	public String toString() {
		return "BoardDTO [board_idx=" + board_idx + ", board_title=" + board_title + ", board_writer=" + board_writer
				+ ", board_contents=" + board_contents + ", board_regdate=" + board_regdate + ", board_hit=" + board_hit
				+ ", page_rows=" + page_rows + ", page_start_row_num=" + page_start_row_num + ", current_page="
				+ current_page + ", order_by=" + order_by + ", search_type=" + search_type + ", keyword=" + keyword
				+ "]";
	}



	
}
