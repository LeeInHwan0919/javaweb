package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.catalina.Manager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.AnswerBoardDto;

public class AnswerBoardDaoImpl implements IAnswerBoardDao {

	//junit 단일 테스트
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.AnswerBoardDaoImpl.";
	private SqlSessionFactory manager;
	
	public AnswerBoardDaoImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public List<AnswerBoardDto> selectAllBoard() {
		logger.info(this.getClass().getSigners() + "selectAllBoard(전체 검색)");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllBoard");
	}

	@Override
	public AnswerBoardDto selectDetailBoard(AnswerBoardDto dto) {
		logger.info(this.getClass().getSigners() + "selectAllBoard(전체 검색)");
		SqlSession session = manager.openSession();
		return (AnswerBoardDto)session.selectList(NS+"selectDetailBoard", dto).get(0);
		//
	}

	@Override
	public boolean reply(AnswerBoardDto dto) {
		logger.info(this.getClass().getSigners()+ "reply 답글 작성 : 부모seq(" + dto.getSeq()+")"+dto);
		SqlSession session = manager.openSession();
		int cntUp = session.update(NS+"replyUpdate",dto);
		int cntIn = session.insert(NS+"replyInsert",dto);
		session.commit();
		return (cntUp+cntIn) > 0 ? true : false;
	}

	@Override
	public boolean deleteBoard(String[] seq) {
		logger.info(this.getClass().getSigners()+ "deleteBoard 글삭제: " + seq);
 		SqlSession session = manager.openSession();
 		int cnt = 0;
 		for (String s : seq) {
 			cnt += session.update(NS+"deleteBoard",s);			
		}
 		session.commit();
		return cnt > 0? true:false;
	}

	@Override
	public boolean modifyBoard(Map<String, String> map) {
		logger.info(this.getClass().getSigners()+ "modifyBoard 글 수정 : " + map);
		SqlSession session = manager.openSession(true);
		int cnt = session.update(NS+"modifyBoard",map);
		session.commit();
		return cnt > 0? true:false;
	}

	@Override
	public boolean insertBoard(AnswerBoardDto dto) {
		logger.info(this.getClass().getSigners()+ "insertBoard 글 입력 : " + dto);
		SqlSession session = manager.openSession(true);
		int cnt = session.update(NS+"insertBoard",dto);
		return cnt > 0? true:false;
	}
}