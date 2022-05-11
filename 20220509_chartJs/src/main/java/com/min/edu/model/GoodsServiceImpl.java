package com.min.edu.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.vo.GraphVo;

@Service
public class GoodsServiceImpl implements IGoodsService {

	private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS="com.min.edu.model.GoodsServiceImpl.";
	
	@Override
	public List<GraphVo> countGoods() {
		logger.info("GoodsServiceImpl countGoods 실행");
		return sqlSession.selectList(NS+"countGoods");
	} 
	
	
	
	

}
