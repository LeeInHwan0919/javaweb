package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerBoardDto;

public interface IAnswerBoardDao {
	
	/**
	 * 답ㅂ변형 게시판 전체 조회
	 * @return 검색된 여러개  row &rarr; AnswerBoardDto
	 */
	public List<AnswerBoardDto> selectAllBoard();
	
	/**
	 * 상세 게시글 조회
	 * @param 검색된 한개의 dto&#40;seq&#41;
	 * @return
	 */
    public AnswerBoardDto selectDetailBoard(AnswerBoardDto dto);
    
    /**
     * 답글작성 <br>
     * <b>Transacition을 통한 작동</b> 전 update 후 insert 진행 
     * @param AnswerBoardDto dto&#부모의 seq, 자식의 입력값;seq&#41;
     * @return 성공한 row의 갯수를 판단하여 성공 true 실패 false
     */
    public boolean reply(AnswerBoardDto dto);
    
    /**
     * 게시판 테이블의 DELFLAG 정보를 변경 N &rarr; Y 삭제
     * @param seq 삭제 대상 row의 식별자 seq
     * @return
     */
    public boolean deleteBoard(String[] seq);
    
    /**
     * 게시판에 입력되어 있는 글 중 CONTENT의 내용을 변경
     * @param HashMap con, seq의 키값으로 되어 있음
     * @return 성공한 갯수 판단 하여 true/false
     */
    public boolean modifyBoard(Map<String, String> map);
    
    /**
     * 새 루트글 입력
     * @param AnswerBoardDto ID, TITLE, CONTENT 
     * @return 성공한 갯수 판단 하여 true/false
     */
    public boolean insertBoard(AnswerBoardDto dto);
}
