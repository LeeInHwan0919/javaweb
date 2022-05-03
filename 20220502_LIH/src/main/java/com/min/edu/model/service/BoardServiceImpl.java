package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.RowNumVo;

@Service
public class BoardServiceImpl implements IBoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class); 
	
	@Autowired
	private IBoardDao dao;

	@Override
	public int insertBoard(Map<String, Object> map) {
		logger.info("BoardServiceImpl insertBoard 파라미터 값 map:{}",map);
		return dao.insertBoard(map);
	}

	@Transactional
	@Override
	public int reply(Map<String, Object> map) {
		logger.info("BoardServiceImpl reply 파라미터 값 map:{}",map);
		int n = dao.replyUpdate(map);
		int m = dao.replyInsert(map);
		return (m>0||n>0)?1:0;
	}

	@Transactional
	@Override
	public BoardVo selectDetail(String chk) {
		logger.info("BoardServiceImpl DetailBoard 파라미터 값 chk:{}",chk);
		BoardVo list = dao.selectDetail(chk);
		dao.ReadCount(chk);
		return list;
	}

	@Override
	public int BoardUpdate(Map<String, Object> map) {
		logger.info("BoardServiceImpl BoardUpdate 파라미터 값 vo:{}",map);
		return dao.BoardUpdate(map);
	}



	@Override
	public List<BoardVo> selectAllBoard() {
		logger.info("BoardServiceImpl selectAllBoard");
		return dao.selectAllBoard();
	}

	@Override
	public List<BoardVo> selectDown(Map<String, Object> map) {
		logger.info("BoardServiceImpl selectDown 파라미터 값:{}",map);
		return dao.selectDown(map);
	}


	@Override
	public int MultipleDelete(Map<String, String[]> map) {
		logger.info("BoardServiceImpl MultipleDelete 선택한 seq값:{}",map);
		return dao.MultipleDelete(map);
	}

	/*
	 * 페이징 처리
	 */
	@Override
	public List<BoardVo> adminBoardListRow(RowNumVo vo) {
		logger.info("BoardServiceImpl adminBoardListRow");
		return dao.adminBoardListRow(vo);
	}

	@Override
	public int adminBoardListTotal() {
		logger.info("BoardServiceImpl adminBoardListTotal");
		return dao.adminBoardListTotal();
	}

	@Override
	public List<BoardVo> userBoardListRow(RowNumVo vo) {
		logger.info("BoardServiceImpl userBoardListRow");
		return dao.userBoardListRow(vo);
	}

	@Override
	public int userBoardListTotal() {
		logger.info("BoardServiceImpl userBoardListTotal");
		return dao.userBoardListTotal();
	}
	
	

}
