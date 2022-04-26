package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.MemberVo;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";
	@Override
	public List<MemberVo> selectMemberAll() {
		return sqlSession.selectList(NS+"selectMemberAll");
	}

	@Override
	public int insertMember(Map<String, Object> map) {
		//Spring Security 비밀번호 암호화 작업 -> 로그인이 바뀔 것이다 
		String enPassword = passwordEncoder.encode((String)map.get("pw")); //charSequence 로 되어 있는 애를 찾아재는 것 : //문자열//, array -> 형변환 해줘야함
		map.put("pw", enPassword);
		System.out.println("Spring Security에 의해서 암호화 된 비밀번호 : " + map.get("pw")); //30라인에서는 casting 해주는데 왜 안해줄까 object에서 String 을 실행시키는 것이기 때문에
		//syso는 형태를 찍어줘야하기때문에 자동으로 찍어주기도 함
		
		
		return sqlSession.insert(NS+"insertMember",map);
	}

	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		MemberVo vo = null;
		System.out.println("스프링 암호화 로그인 실행 중"); 
		System.out.println("화면에서 전달받은 요청 값 \t : " + map.get("pw"));
		String enPw = passwordEncoder.encode((String)map.get("pw"));
		System.out.println("화면에서 전달받은 값을 암호화 처리 \t : " +  enPw);
		
		//전달 받은 값은 Spring Security를 통해서 암호화하면 항상 다른 값이 나옴
		//따라서 DB의 입력된 값과 비교를 하면 반드시 false가 나옴
		//처리방법은 Spring Security를 통해 값을 확인하여 같은 값을 찾아주는 matches 함수를 사용해야 한다
		String dbPw = sqlSession.selectOne(NS+"passwordCheck", map.get("id"));
		
		if(passwordEncoder.matches((String)map.get("pw"), dbPw)) { //암호화된 것은 =으로 비교 안되니깐 matches로 비교해야함
			vo = sqlSession.selectOne(NS+"enLogin", map.get("id"));
		}
		return vo;		
	}

	@Override
	public int passwordCheck(String pw) {
		return sqlSession.selectOne(NS+"passwordCheck",pw);
	}

	@Override
	public MemberVo enLogin(String id) {
		return sqlSession.selectOne(NS+"enLogin",id);
	}

	@Override
	public int idCheck(String id) {
		return  sqlSession.selectOne(NS+"idCheck",id);
	}

	@Override
	public boolean changeUser(Map<String, Object> map) {
		return sqlSession.update(NS+"changeUser",map) > 0?true:false;
	}


}
