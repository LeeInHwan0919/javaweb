package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

@Service
public class BoardServiceImpl implements IBoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private IBoardDao dao;
	
	@Override
	public List<BoardVo> userBoardList() {
		logger.info("BoardServiceImpl 게시글 전체 조회 userBoardList");
		return dao.userBoardList();
	}

	@Override
	public int delflagBoard(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
