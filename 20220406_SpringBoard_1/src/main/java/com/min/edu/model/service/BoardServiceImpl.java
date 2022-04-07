package com.min.edu.model.service;

import java.util.HashMap;
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
		logger.info("BoardServiceImpl 게시글 단일/ 다중 삭제 delflagBoard");
	      return dao.delflagBoard(map);
	}

	@Override
	public int writeBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		logger.info("BoardServiceImpl 게시글 상세 조회 getOneBoard");
		return dao.getOneBoard(seq);
	}

	@Override
	public int replyInsert(BoardVo vo, String seq) {
		int m = dao.replyUpdate(seq);
		int n = dao.replyInsert(vo);
		return (n>0 && m>0)?1:0;
	}
	

//	@Override
//	public int replyInsert(BoardVo vo) {
//		logger.info("BoardServiceImpl 답글입력 replyInsert");
//		return dao.replyInsert(vo);
//	}
//
//	@Override
//	public int replyUpdate(String seq) {
//		logger.info("BoardServiceImpl 답글입력 STEP replyUpdate");
//		return dao.replyUpdate(seq);
//	}

}
