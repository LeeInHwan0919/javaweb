package com.min.edu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.PlayerVo;

public class PlayerImpl implements IPlayer {
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFac();
	private final String NS = "com.min.edu.dao.PlayerImpl.";
	
	@Override
	public List<PlayerVo> showView(int startNum) {
		SqlSession session = manager.openSession();
		return session.selectList(NS+"showView", startNum);
	}

	@Override
	public Integer count() {
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"count");
	}

}
