package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.CalendarDto;
import com.min.edu.model.CalBoardDaoImpl;
import com.min.edu.model.ICalBoardDao;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class CalendarTest {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
//	private ICalBoardDao dao = new CalBoardDaoImpl();
	
//	@Before
	public void test() {
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
//	@Test
	public void getCalViewList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "BD001");
		map.put("yyyymm", "202203");
		SqlSession session = manager.openSession();
		List<CalendarDto> lists = session.selectList("com.min.edu.model.CalBoardDaoImpl.getCalViewList",map);
		System.out.println(lists);
	}
	
//	@Test
	public void insertCalBoard() {
		CalendarDto dto = new CalendarDto(12, "BD001", "7시인가?", "우리는 그저 열심히 했을 뿐이고...", "202203281000","");
		SqlSession session = manager.openSession(true);
		int cnt = session.insert("com.min.edu.model.CalBoardDaoImpl.insertCalBoard",dto);
		assertEquals(cnt,1);
	}
	
//	@Test
	public void getCalList() {
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("id", "BD001");
	  map.put("yyyymmdd", "20220325");
	  SqlSession session = manager.openSession();
	  List<CalendarDto> dtos = session.selectList("com.min.edu.model.CalBoardDaoImpl.getCalList",map);
	  System.out.println(dtos);
	}
	
//	@Test
	public void getCalCount(){
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("id", "BD001");
		 map.put("yyyymmdd", "20220325");
		 SqlSession session = manager.openSession();
		 Integer cnt = session.selectOne("com.min.edu.model.CalBoardDaoImpl.getCalCount",map);
		 System.out.println(cnt);
	}
	
//	@Test
	public void getCalDetail() {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", "BD001");
		map.put("yyyymmdd", "20220325");
		map.put("seq", "13");
		SqlSession session = manager.openSession();
		List<CalendarDto> lists = session.selectList("com.min.edu.model.CalBoardDaoImpl.getCalDetail",map);
		System.out.println(lists);
	}
	
	@Test
	public void multiDel() {
		SqlSession session = manager.openSession();
		int cnt = session.delete("com.min.edu.model.CalBoardDaoImpl.multiDel","10");
		assertEquals(cnt,1);
	}


}
