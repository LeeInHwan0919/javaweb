package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@Repository
public class BoardDaoImpl implements IBoardDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.edu.model.mapper.BoardDaoImpl.";
	
	@Override
	public int insertBoardRoot(Map<String, Object> map) {
		return sqlSession.insert(NS+"insertBoardRoot",map);
	}

	@Override
	public int insertBoardAnswer(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"insertBoardAnswer",map);
	}

	@Override
	public BoardVo selectBoardDetail(String seq) {
		return sqlSession.selectOne(NS+"selectBoardDetail",seq);
	}

	@Override
	public int updateReadcount(String seq) {
		return sqlSession.update(NS+"updateReadcount",seq);
	}

	@Override
	public int updateBoardDetail(Map<String, Object> map) {
		return sqlSession.update(NS+"updateBoardDetail",map);
	}

	@Override
	public int updateBoardDelflag(Map<String, String[]> seqs) {
		return sqlSession.update(NS+"updateBoardDelflag",seqs);
	}

	@Override
	public int deleteBoard(List<String> seqs) {
		return sqlSession.delete(NS+"deleteBoard",seqs);
	}
	
	@Override
	public List<BoardVo> selectBoardAll(MemberVo mVo) {
		return sqlSession.selectList(NS+"selectBoardAll",mVo);
	}

	@Override
	public List<BoardVo> selectBoardAllAdmin() {
		return sqlSession.selectList(NS+"selectBoardAllAdmin");
	}

	@Override
	public List<BoardVo> selectBoardAllUser() {
		return sqlSession.selectList(NS+"selectBoardAllUser");
	}

	@Override
	public int updateBoardAnswer(Map<String, Object> map) {
		return sqlSession.update(NS+"updateBoardAnswer",map);
	}

	@Override
	public List<BoardVo> deleteBoardSel(String seq) {
	  return sqlSession.selectList(NS+"deleteBoardSel",seq);
	}
	
	

	@Override
	public List<BoardVo> adminBoardListRow(RowNumVo vo) {
		return sqlSession.selectList(NS+"adminBoardListRow",vo);
	}

	@Override
	public int adminBoardListTotal() {
		return sqlSession.selectOne(NS+"adminBoardListTotal");
	}

	@Override
	public List<BoardVo> userBoardListRow(RowNumVo vo) {
		return sqlSession.selectList(NS+"userBoardListRow",vo);
	}

	@Override
	public int userBoardListTotal() {
		return sqlSession.selectOne(NS+"userBoardListTotal");
	}

	

	

}
