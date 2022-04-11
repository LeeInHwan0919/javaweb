package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;

@Repository
public class BoardDaoImpl implements IBoardDao {

	private final String NS="com.min.edu.model.mapper.BoardDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
		
	@Override
	public List<BoardVo> userBoardList() {
		return sqlSession.selectList(NS+"userBoardList");
	}

	@Override
	public int deflagBoard(Map<String, String[]> map) {
		return sqlSession.update(NS+"deflagBoard", map);
	}

	@Override
	public int writeBoard(BoardVo vo) {
		return 0;
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		return (BoardVo) sqlSession.selectList(NS+"getOneBoard", seq).get(0);
	}

	@Override
	public int replyUpdate(String seq) {
		return sqlSession.update(NS+"replyUpdate",seq);
	}

	@Override
	public int replyInsert(BoardVo vo) {
		return sqlSession.insert(NS+"replyInsert",vo);
	}

	@Override
	public List<BoardVo> restoreBoard() {
		return sqlSession.selectList(NS+"restoreBoard");
	}

	@Override
	public int restoreDelflag(String seq) {
		return sqlSession.update(NS+"restoreDelflag",seq);
	}

}
