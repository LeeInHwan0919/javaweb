package com.min.edu.vo;

import java.io.Serializable;

public class GraphVo implements Serializable{

	private static final long serialVersionUID = 3789244305181110069L;
	
	private int pos_seq;
	private String pos_type;
	private String pos_time;
	private int pos_count;
	private String mb_id;
	
	
	@Override
	public String toString() {
		return "GraphVo [pos_seq=" + pos_seq + ", pos_type=" + pos_type + ", pos_time=" + pos_time + ", pos_count="
				+ pos_count + ", mb_id=" + mb_id + "]";
	}
	public GraphVo() {
		
	}
	
	public GraphVo(int pos_seq, String pos_type, String pos_time, int pos_count, String mb_id) {
		this.pos_seq = pos_seq;
		this.pos_type = pos_type;
		this.pos_time = pos_time;
		this.pos_count = pos_count;
		this.mb_id = mb_id;
	}
	public int getPos_seq() {
		return pos_seq;
	}
	public void setPos_seq(int pos_seq) {
		this.pos_seq = pos_seq;
	}
	public String getPos_type() {
		return pos_type;
	}
	public void setPos_type(String pos_type) {
		this.pos_type = pos_type;
	}
	public String getPos_time() {
		return pos_time;
	}
	public void setPos_time(String pos_time) {
		this.pos_time = pos_time;
	}
	public int getPos_count() {
		return pos_count;
	}
	public void setPos_count(int pos_count) {
		this.pos_count = pos_count;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	
	
}
