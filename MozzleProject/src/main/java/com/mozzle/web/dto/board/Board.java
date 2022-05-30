package com.mozzle.web.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Board {
	private String post_id;
	private String mozzle_id;
	private String user_id;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private String regdate;
	
	private int seq;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(String post_id, String mozzle_id, String user_id, String title, String content, int refer, int step,
			int depth, String regdate, int seq) {
		super();
		this.post_id = post_id;
		this.mozzle_id = mozzle_id;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.regdate = regdate;
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "Board [post_id=" + post_id + ", mozzle_id=" + mozzle_id + ", user_id=" + user_id + ", title=" + title
				+ ", content=" + content + ", refer=" + refer + ", step=" + step + ", depth=" + depth + ", regdate="
				+ regdate + ", seq=" + seq + "]";
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getMozzle_id() {
		return mozzle_id;
	}

	public void setMozzle_id(String mozzle_id) {
		this.mozzle_id = mozzle_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
//	private String report_id;
//	private String report_time;
//	private String reporter;
//	private String reason;
	
	
}
