package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserVo;

public class AnswerBoardDaoImpl implements IAnswerBoardDao {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.AnswerBoardDaoImpl.";
	private SqlSessionFactory manager;

	public AnswerBoardDaoImpl() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Override
	public List<AnswerBoardDto> selectAllBoard() {
		logger.info(this.getClass().getSigners()+"selectAllBoard 전체 검색");
		 SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllBoard");
	}

	@Override
	public AnswerBoardDto selectDetailBoard(AnswerBoardDto dto) {
		logger.info(this.getClass().getSigners()+"selectDetailBoard 전체 검색"+ dto);
		SqlSession session = manager.openSession();
		return (AnswerBoardDto) session.selectList(NS+"selectDetailBoard",dto).get(0);
	}

	@Override
	public boolean reply(AnswerBoardDto dto) {
		logger.info(this.getClass().getSigners()+"reply 답글작성: 부모seq("+ dto.getSeq()+",)"+dto);
		SqlSession session = manager.openSession();
		int cntU = session.update(NS+"replyUpdate", dto);
		int cntI = session.insert(NS+"replyInsert", dto);
		session.commit();
		return (cntU+cntI)>0? true:false;
	}


	@Override
	public boolean deleteBoard(String[] seq) {
		logger.info(this.getClass().getSigners()+"deleteBoard 글삭제"+seq);
		SqlSession session = manager.openSession(false);
		int cnt =0;
		for (String s: seq) {
			cnt += session.delete(NS+"deleteBoard",s);
		}
		session.commit();
		return cnt>0? true:false;
	}

	@Override
	public boolean modifyBoard(AnswerBoardDto dto) {
		logger.info(this.getClass().getSigners()+"modifyBoard 글수정"+dto);
		SqlSession session = manager.openSession(true);
		int cnt = session.update(NS+"modifyBoard", dto);
		return cnt>0? true:false;
	}

	@Override
	public boolean insertBoard(AnswerBoardDto dto) {
		logger.info(this.getClass().getSigners()+"insertBoard 새글입력"+dto);
		SqlSession session = manager.openSession(true);
		int cnt = session.update(NS+"insertBoard", dto);
		return cnt>0? true:false;
	}

	@Override
	public UserVo checkUser(Map<String, String> map) {
		logger.info("회원 로그인");
		SqlSession session = manager.openSession();
		UserVo vo = session.selectOne(NS+"checkUser", map);
		return vo;
	}

	@Override
	public int signUp(UserVo vo) {
		logger.info("회원가입");
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"signUp", vo);
		return row;
	}

	@Override
	public List<UserVo> allUserId() {
		logger.info("중복검사를 하기 위한 id 리스트 출력");
		 SqlSession session = manager.openSession();
		return session.selectList(NS+"allUserId");
	}
	
	

}
