package com.min.edu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.vo.EduVo;

@Service
public class EduBoardServiceImpl implements IEduBoardService {

	@Autowired
	private IEduBoardDao dao;
	//VMI , 메모리4대원칙 , 다형성3대원칙 , Spring runtime
	
	@Override
	public List<EduVo> selectBoard() {
		return dao.selectBoard();
	}

	@Override
	public int insertBoard(EduVo vo) {
		return dao.insertBoard(vo);
	}

//	@Transactional(readOnly = true)
	@Override
	public int transactionTest(EduVo vo) throws Exception{
		int m = dao.updateBoard(); //기존 데이터의 컬럼 중 DELFLAG를 모두 'Y'로 변경
		int n = dao.insertBoard(vo);
		return (m>0 || n>0)?1:0;
	}

}
