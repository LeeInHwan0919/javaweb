package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {

	private int seq;
	private String id;
	private String title;
	private String content;
	private int step;
	private int depth;
	private int ref;
	private String delflag;
	private String regdate;
	
	
	public BoardVo(int seq, String id, String title, String content) {
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
	}


	public BoardVo(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public BoardVo(int depth) {
		this.depth = depth;
	}

	
	public String getphoto() {
		String str = "";
		String blank = "&nbsp;&nbsp;&nbsp;";
		String pic = "<img alt=\"답글\" src=\"./image/reply2.png\">";

		for (int i = 0; i < depth; i++) {
			str += blank;
		}
		
		return depth > 0 ? str + pic : str;
	}


	

}
