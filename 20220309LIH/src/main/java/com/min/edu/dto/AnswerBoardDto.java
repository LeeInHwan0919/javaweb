package com.min.edu.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AnswerBoardDto implements Serializable {

	private static final long serialVersionUID = 7072715040224794703L;

	private int seq;
	private String id;
	private String title;
	private String content;
	private int ref;
	private int step;
	private int depth;
	private String delflag;
	private String regdate;
	
	public AnswerBoardDto(int seq, String id, String title, String content) {
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public AnswerBoardDto(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public AnswerBoardDto(int seq, String content) {
		
		this.seq = seq;
		this.content = content;
	}
	
	

	
	
	
	
}
