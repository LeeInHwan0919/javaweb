package com.min.edu.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.CalendarDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class CalBoardDaoImpl implements ICalBoardDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.CalBoardDaoImpl.";
	
	@Override
	public List<CalendarDto> getCalViewList(Map<String, Object> map) {
		logger.info("각 달 일별 리스트 : "+map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getCalViewList",map);
	}

	@Override
	public boolean insertCalBoard(CalendarDto dto) {
		logger.info("일정 추가"+dto);
		SqlSession session = manager.openSession(true);
		int cnt = session.insert(NS+"insertCalBoard",dto);
		return (cnt>0)?true:false;
	}

	@Override
	public List<CalendarDto> getCalList(Map<String, Object> map) {
		logger.info("일정 게시글 조회"+map);
		SqlSession session = manager.openSession(true);
		return session.selectList(NS+"getCalList",map);
	}

	@Override
	public int getCalCount(Map<String, Object> map) {
		logger.info("일정 갯수");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getCalCount",map);
	}

	@Override
	public CalendarDto getCalDetail(Map<String, Object> map) {
		logger.info("일정 상세"+map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getCalDetail",map);
	}

	@Override
	public boolean multiDel(String[] seqs) {
		logger.info("다중 일정 삭제"+Arrays.toString(seqs));
		int cnt = 0;
		SqlSession session = manager.openSession(false);
		
		try {
			for (String s : seqs) {
				cnt += session.delete(NS+"multiDel",s);
			}
			session.commit();
			session.close();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		
		return (cnt>0)?true:false;
	}

}
