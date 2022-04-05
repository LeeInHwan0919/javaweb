package com.min.edu;


/*
 * JUnit Test를 Spring Container에 맞춰 실행 할 수 있도록 설정한다.
 * 4.12이상의 JUnit과 Spring-Test 라이브러리를 필요로 한다. 
 * 
 * Spring의 구조에서는 모든 환경설정을 Spring Container가 동작시킬 수 있도록 Spring Bean COnfiguration.xml파일에 작성하여
 * DispatcherServlet에 의해 읽혀진다 
 * (java main에서는 ApplicationContext 객체가 읽어 줌)
 * 
 * Bean을 테스트 하기 위해서 ApplicationContext 객체가 필요함 & Application 객체를 환경설정인 xml을 입력받아 가지고 있어야 함
 * POJO 인 Main Class에서는 ClassPathXMLApplicationContext를 통해서 만들어줬음
 * 
 * JUnit Spring Test에서는 @ContextConfiguration을 통해서 읽고 사용할 수 있다
 * 만약 Spring의 설정 bean configuration이 여러개인 경우  {xml위치, xml위치}
 * @ContextConfiguration 물리적인 위치 : src/~~ 부터 가져옴
 * 
 * 
 */
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //**하위 모든 것, *모든 것

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.IEduBoardDao;
import com.min.edu.vo.EduVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml") 
//application-context.xml만 JUnit의 대상이 되도록 읽어옴
public class Test {
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private IEduBoardDao dao;
	
	@Before
	public void before() {
		System.out.println("spring junit Test 시작");
	}
	
	@After
	public void after() {
		System.out.println("spring junit Test 종료");
	}
	//JUnit + Spring : spring bean configuration을 Junit에서 사용하여 Application에 관련된(Persistence Layer)를 세팅을 테스트함
//	@org.junit.Test
	public void dbConnectTest() {
		SqlSessionTemplate session = context.getBean("sqlSessionTemplate",SqlSessionTemplate.class);
		System.out.println(session.toString());
	}
	//생성된 SqlSessionTemplate 객체(DataSource+SqlSessionFactory+MyBatis Setting)사용
//	@org.junit.Test
	public void selectBoardTest() {
		List<EduVo>lists=sqlSession.selectList("com.min.edu.model.EduDaoImpl.selectBoard");
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	@org.junit.Test
	public void daoTest() {
		List<EduVo> lists = dao.selectBoard();
		System.out.println(lists);
	}

}
