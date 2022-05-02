package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;


@Repository
public class BoardDaoImpl implements IBoardDao {

	private final String NS = "com.min.edu.model.mapper.BoardDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertBoard(Map<String, Object> map) {
		return sqlSession.insert(NS+"insertBoard",map);
	}

	@Override
	public int replyUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"replyUpdate",map);
	}

	@Override
	public int replyInsert(Map<String, Object> map) {
		return sqlSession.insert(NS+"replyInsert",map);
	}

	@Override
	public BoardVo selectDetail(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"selectDetail",map);
	}

	@Override
	public int ReadCount(Map<String, Object> map) {
		return sqlSession.update(NS+"ReadCount",map);
	}

	@Override
	public int BoardUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"BoardUpdate",map);
	}

	

	@Override
	public int BoardDelete(Map<String, Object> map) {
		return sqlSession.delete(NS+"BoardDelete",map);
	}


	@Override
	public List<BoardVo> selectAllBoard() {
		return sqlSession.selectList(NS+"selectAllBoard");
	}

	@Override
	public List<BoardVo> selectDown(Map<String, Object> map) {
		return sqlSession.selectList(NS+"selectDown",map);
	}


	@Override
	public int MultipleDelete(Map<String, String[]> map) {
		return sqlSession.delete(NS+"MultipleDelete",map);
	}

	@Override
	public List<BoardVo> boardPaging(int page) {
		return sqlSession.selectList(NS+"boardPaging",page);
	}

	@Override
	public int rowCount() {
		return sqlSession.selectOne(NS+"rowCount");
	}

	


	

	
	
}
