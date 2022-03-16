package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserVo;

public interface IAnswerBoardDao {
	/**
	 * 답변형 게시판 
	 */
	public List<AnswerBoardDto> selectAllBoard();
	/**
	 * 답글게시판
	 * @param dto
	 * @return
	 */
	public AnswerBoardDto selectDetailBoard(AnswerBoardDto dto);
	/**
	 * 답글작성<br>
	 * <b>Transaction 을 통한 작동</b> 전 update 후 insert를 진행
	 * @param AnswerBoardDto #40;부모의 seq, 자식의 입력값&#41;
	 * @return 성공한 row갯수를 판단하여 성공 true/실패false
	 */
	public boolean reply(AnswerBoardDto dto);
	/**
	 * 게시판 테이블의 DELFLAG 정보를 변경N &rarr; Y
	 * @param 삭제 대상 row의 식별 seq
	 * @return 성공한 row갯수를 판단하여 성공 true/실패false
	 */
	public boolean deleteBoard(String[] seq);
	/**
	 * 게시판에 입력되어 있는 글 중 CONTENT의 내용을 변경
	 * @param HashMap con,seq의 키값을 전달
	 * @retrun 성공한 row갯수를 판단하여 성공 true/실패false
	 */
	public boolean modifyBoard(Map<String, String> map);
	/**
	 * 새 루트글 입력
	 * @param AnswerBoardDto ID,TITLE,CONTENT
	 * @return 성공한 row갯수를 판단하여 성공 true/실패false
	 */
	public boolean insertBoard(AnswerBoardDto dto);
	
	public boolean signUpInsert(UserVo vo);
	
	public List<UserVo> userInfoAll();
	
	public UserVo loginSelect(UserVo vo);

}
