package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.BikeDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class BikeDaoImpl implements IBikeDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.BikeDaoImpl.";
	
	@Override
	public int bikeInsert(List<BikeDto> dtos) {
		logger.info("BikeDaoImpl bikeInsert: "+dtos.size());
		int cnt=0;
		SqlSession session = manager.openSession();
		for (BikeDto dto : dtos) {
			cnt += session.insert(NS+"bikeInsert",dto);
		}
		session.commit();
		return cnt;
	}

	@Override
	public int bikeDelete() {
		logger.info("BikeDaoImpl BikeDelete");
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"bikeDelete");
	}

}
