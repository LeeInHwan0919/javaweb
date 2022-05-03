package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.RowNumVo;


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
	public BoardVo selectDetail(String chk) {
		return sqlSession.selectOne(NS+"selectDetail",chk);
	}

	@Override
	public int ReadCount(String chk) {
		return sqlSession.update(NS+"ReadCount",chk);
	}

	@Override
	public int BoardUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"BoardUpdate",map);
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
		return sqlSession.update(NS+"MultipleDelete",map);
	}

	/*
	 * 페이징 처리
	 */
	@Override
	public List<BoardVo> adminBoardListRow(RowNumVo vo) {
		return sqlSession.selectList(NS+"adminBoardListRow", vo);
	}
	
	@Override
	public int adminBoardListTotal() {
		return sqlSession.selectOne(NS+"adminBoardListTotal");
	}
	
	@Override
	public List<BoardVo> userBoardListRow(RowNumVo vo) {
		return sqlSession.selectList(NS+"userBoardListRow", vo);
	}
	
	@Override
	public int userBoardListTotal() {
		return sqlSession.selectOne(NS+"userBoardListTotal");
	}

	


	

	
	
}
