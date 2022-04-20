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
	public int insertBoard(BoardVo vo) {
		return sqlSession.insert(NS+"insertBoard",vo);
	}

	@Override
	public int replyUpdate(BoardVo vo) {
		return sqlSession.update(NS+"replyUpdate",vo);
	}

	@Override
	public int replyInsert(BoardVo vo) {
		return sqlSession.insert(NS+"replyInsert",vo);
	}

	@Override
	public BoardVo selectDetail(BoardVo vo) {
		return sqlSession.selectOne(NS+"selectDetail",vo);
	}

	@Override
	public int ReadCount(BoardVo vo) {
		return sqlSession.update(NS+"ReadCount",vo);
	}

	@Override
	public int BoardUpdate(BoardVo vo) {
		return sqlSession.update(NS+"BoardUpdate",vo);
	}

	@Override
	public int BoardUpdateDelflag(BoardVo vo) {
		return sqlSession.update(NS+"BoardUpdateDelflag",vo);
	}
	

	@Override
	public int BoardDelete(BoardVo vo) {
		return sqlSession.delete(NS+"BoardDelete",vo);
	}


	@Override
	public List<BoardVo> selectAllBoard() {
		return sqlSession.selectList(NS+"selectAllBoard");
	}

	@Override
	public List<BoardVo> selectDown(BoardVo vo) {
		return sqlSession.selectList(NS+"selectDown",vo);
	}

	@Override
	public int delfalgUpdate(Map<String, String[]> map) {
		return sqlSession.update(NS+"delfalgUpdate",map);
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
