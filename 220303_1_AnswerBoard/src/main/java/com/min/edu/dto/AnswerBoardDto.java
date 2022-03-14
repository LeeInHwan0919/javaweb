package com.min.edu.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data// 모든 필드를 대상으로 접근자와 설정자가 자동으로 생성되고, final 또는 @NonNull 필드 값을 파라미터로 받는 생성자가 만들어지며, toStirng, equals, hashCode 메소드가 자동으로 만들어집니다.
@Getter
@Setter
@ToString
@NoArgsConstructor//생성자 생성
public class AnswerBoardDto implements Serializable{
	
	private static final long serialVersionUID = 216214171989584390L;
	
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
}
