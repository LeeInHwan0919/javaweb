package com.min.edu.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@Service
//@Transactional
public class BoardServiceImpl implements IBoardService {

	@Autowired
	private IBoardDao dao ;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Override
	public int insertBoardRoot(Map<String, Object> map) {
		logger.info("BoardServiceImpl insertBoardRoot : ",map);
		return dao.insertBoardRoot(map);
	}

	@Override
	public int boardAnswer(Map<String, Object> map) {
		logger.info("BoardServiceImpl insertBoardAnswer : {}",map);
		int n = dao.insertBoardAnswer(map);
		int m = dao.updateBoardAnswer(map);
		return (n>0||m>0)?1:0;
	}

	@Override
	public BoardVo selectBoardDetail(String seq) {
		logger.info("BoardServiceImpl selectBoardDetail : {}",seq);
		dao.updateReadcount(seq);
		return dao.selectBoardDetail(seq);
	}

	@Override
	public int updateBoardDetail(Map<String, Object> map) {
		logger.info("BoardServiceImpl updateBoardDetail : {}",map);
		return dao.updateBoardDetail(map);
	}

	@Override
	public int updateBoardDelflag(Map<String, String[]> seqs) {
		logger.info("BoardServiceImpl updateBoardDelflag : {}",seqs);
		return dao.updateBoardDelflag(seqs);
	}

	@Override
	public int deleteBoard(List<String> seqs) {
		logger.info("BoardServiceImpl deleteBoard ; {}",seqs);
		return dao.deleteBoard(seqs);
	}

	@Override
	public List<BoardVo> selectBoardAll(MemberVo mVo) {
		return dao.selectBoardAll(mVo);
	}
	
	@Override
	public List<BoardVo> selectBoardAllAdmin() {
		logger.info("BoardServiceImpl selectBoardAllAdmin");
		return dao.selectBoardAllAdmin();
	}

	@Override
	public List<BoardVo> selectBoardAllUser() {
		logger.info("BoardServiceImpl selectBoardAllUser");
		return dao.selectBoardAllUser();
	}

	@Override
	public List<BoardVo> deleteBoardSel(String seq) {
		logger.info("BoardServiceImpl deleteBoardSel");
		return dao.deleteBoardSel(seq);
	}

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
