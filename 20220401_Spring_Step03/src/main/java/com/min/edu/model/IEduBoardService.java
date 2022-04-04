package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.EduVo;

public interface IEduBoardService {

  public List<EduVo> selectBoard();
  public int insertBoard(EduVo vo);
  public int transactionTest(EduVo vo);
	
}
