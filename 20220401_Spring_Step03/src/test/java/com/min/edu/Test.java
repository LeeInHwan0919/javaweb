 package com.min.edu;

 /*
  * JUnit Test를 Spring Container에 맞춰 실행 할 수 있도록 설정한다.
  * 4.12이상의 JUnit과 Spring-Test 라이브러리를 필요로 함
  * 
  * Spring의 구조에서는 모든 환경설정을 Spring Container가 동작시킬 수 있도록 Spring Bean Configuration xml 파일에 작성하여 
  * DispatcherServlet에 의해서 읽혀진다.
  * 
  * Bean을 테스트 하기 위해서 ApplicationContext객체가 필요함 그리고 Application 객체를 환경 설정인 xml을 입력받아  가지고 있어야 함
  * POJO인 Main Class에서는 ClassPathXMLApplicationContext를 통해서 만들어 줬음
  * 
  * JUnit Spring Test에서는 @ContextConfiguration을 통해서 읽고 사용 할 수 있다.
  * 만약에 Spring의 설정 bean configuration이 여러개인 경우{xml위치, xml위치}
  * @ContextConfiguration 물리적인 위치 src/~~~
  */
 // @ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) ** 하위 모든것 , * 모든것 (디렉토리 포함하냐 안하냐)
 
 
 
import static org.junit.Assert.*;

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
//Application-context.xml만 JUnit의 대상이 되도록 읽어 옴
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml")
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})//** 하위 디렉토리 모두 포함, {} 여러개의 경우 배열을 갖고옴 ,{}안쓰고 콤마처리해도 됨
public class Test {

	@Autowired
	private ApplicationContext context;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IEduBoardDao dao;
	
	@Before
	public void before() {
		System.out.println("spring Junit Test 시작 (before)");
	}
	
	@After
	public void after() {
		System.out.println("Spring Junit Test 종료(After)");
	}
	
	// JUnit + Spring : spring bean configuration을 JUnit에서 사용하여 Application에 관련된(Persistence layer) 세팅을 테스트 함
//	@org.junit.Test
	public void dbDonnecTest() {
	  SqlSessionTemplate session = context.getBean("SqlSessionTemplate",SqlSessionTemplate.class);
	  System.out.println(session.toString());
	}
	
	//생성된 SqlSessionTemplate 객체(DataSource + SqlSessionFactory + MyBatis Setting) 사용
//	@org.junit.Test
	public void selectBoardTest() {
		List<EduVo> lists =  sqlSession.selectList("com.min.edu.model.EduDaoImpl.selectBoard");
		System.out.println(lists);
		assertNotNull(lists);
	}
		
	@org.junit.Test
	public void daoTest() {
		List<EduVo> lists = dao.selectBoard();
		System.out.println(lists);
	}
}
