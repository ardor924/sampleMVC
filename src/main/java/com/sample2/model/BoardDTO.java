package com.sample2.model;

import java.util.Date;

public class BoardDTO {
	
	private int board_idx;
	private String board_title;
	private String board_writer;
	private String board_contents;
	private Date board_regdate;
	private int board_hit;
	
	public BoardDTO() {}

	public BoardDTO(int board_idx, String board_title, String board_writer, String board_contents, Date board_regdate,
			int board_hit) {
		super();
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_writer = board_writer;
		this.board_contents = board_contents;
		this.board_regdate = board_regdate;
		this.board_hit = board_hit;
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
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
