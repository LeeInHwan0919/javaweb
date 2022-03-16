package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.AnswerBoardDto;

public class PagingDaoImpl implements IPagingDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.PagingDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	@Override
	public List<AnswerBoardDto> boardPaging(int page) {
		logger.info("페이징 보드 리스트 : "+page);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"boardPaging",page);
	}

	@Override
	public Integer rowCount() {
		logger.info("게시판 전체 글 갯수");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"rowCount");
	}
	
}
