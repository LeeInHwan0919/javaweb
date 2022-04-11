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
public class BoardServiceImple implements IBoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private IBoardDao dao;
	
	@Override
	public List<BoardVo> userBoardList() {
		logger.info("BoardServiceImple 게시글 전체조회 userBoardList");
		return dao.userBoardList();
	}

	@Override
	public int deflagBoard(Map<String, String[]> map) {
		logger.info("BoardServiceImple 게시글 단일/다중 삭제 deflagBoard ");
		return dao.deflagBoard(map);
	}

	@Override
	public int writeBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		logger.info("BoardServiceImple 글상세 정보 getOneBoard ");
		return dao.getOneBoard(seq);
	}

	@Override
	public int replyInsert(BoardVo vo) {
		logger.info("BoardServiceImple 답글입력 replyInsert");
		int m = dao.replyUpdate(vo.getSeq()+"");
		int n = dao.replyInsert(vo);
		return (m>0||n>0)?1:0;
		
		
	}

	@Override
	public List<BoardVo> restoreBoard() {
		return dao.restoreBoard();
	}

	@Override
	public int restoreDelflag(String seq) {
		return dao.restoreDelflag(seq);
	}

}
