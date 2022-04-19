package com.min.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.BoardVo;

@Service
public class BoardServiceImpl implements IBoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class); 
	
	@Autowired
	private IBoardDao dao;

	@Override
	public int insertBoard(BoardVo vo) {
		logger.info("BoardServiceImpl insertBoard 파라미터 값 vo:{}",vo);
		return dao.insertBoard(vo);
	}

	@Transactional
	@Override
	public int reply(BoardVo vo) {
		logger.info("BoardServiceImpl reply 파라미터 값 vo:{}",vo);
		int n = dao.replyUpdate(vo);
		int m = dao.replyInsert(vo);
		return (m>0||n>0)?1:0;
	}

	@Transactional
	@Override
	public BoardVo DetailBoard(BoardVo vo) {
		logger.info("BoardServiceImpl DetailBoard 파라미터 값 vo:{}",vo);
		BoardVo list = dao.selectDetail(vo);
		dao.ReadCount(vo);
		return list;
	}

	@Override
	public int BoardUpdate(BoardVo vo) {
		logger.info("BoardServiceImpl BoardUpdate 파라미터 값 vo:{}",vo);
		return dao.BoardUpdate(vo);
	}

	@Override
	public int BoardUpdateDelflag(BoardVo vo) {
		logger.info("BoardServiceImpl BoardUpdateDelflag 파라미터 값 vo:{}",vo);
		return dao.BoardUpdateDelflag(vo);
	}

	@Override
	public int BoardDelete(BoardVo vo) {
		logger.info("BoardServiceImpl BoardDelete 파라미터 값 vo:{}",vo);
		return dao.BoardDelete(vo);
	}

	@Override
	public List<BoardVo> selectAllBoard() {
		logger.info("BoardServiceImpl selectAllBoard");
		return dao.selectAllBoard();
	}
	
	

}
