package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.TestVo;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";
	
	@Override
	public List<TestVo> calenList() {
		return sqlSession.selectList(NS+"calenList");
	}

	@Override
	public boolean insertCal(Map<String, Object> map) {
		return sqlSession.insert(NS+"insertCal", map)>0?true:false;
	}

	@Override
	public int dragUpdateCal(Map<String, Object> map) {
		return sqlSession.update(NS+"dragUpdateCal", map);
	}
	
}
