package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.BoardVo;
import com.min.edu.dto.UserVo;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class BoardDaoImpl implements IBoardDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS ="com.min.edu.model.BoardDaoImpl.";
	
	@Override
	public List<BoardVo> getAllBoard() {
		logger.info("게시판 모두 보기");
		SqlSession session = manager.openSession();
		List<BoardVo> lists = session.selectOne(NS+"getAllBoard");
		session.close();
		return lists;
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		logger.info("게시판 한개 보기");
		SqlSession session = manager.openSession();
		BoardVo vo = session.selectOne(NS+"getOneBoard",seq);
		session.close();
		return vo;
	}

}
