package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";
	@Override
	public List<MemberVo> selectMemberAll(RowNumVo vo) {
		return sqlSession.selectList(NS+"selectMemberAll",vo);
	}

	@Override
	public int insertMember(Map<String, Object> map) {
		//Spring Security 비밀번호 암호화 작업
		String enPassword = passwordEncoder.encode((String)map.get("pw"));
		map.put("pw", enPassword);
		System.out.println("Spring Security에 의해서 암호화된 비밀번호 :"+map.get("pw"));
		
		return sqlSession.insert(NS+"insertMember",map);
//		return 1;
	}

	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		MemberVo vo = null;
		
		System.out.println("스프링 암호화 로그인 실행 중");
		System.out.println("화면에서 전달 받은 요청 값 \t:"+ map.get("pw"));
		String enPw = passwordEncoder.encode((String)map.get("pw"));
		System.out.println("화면에서 전달 받은 값을 암호화 처리 \t:"+enPw);
		
		// 전달 받은 값은 Spring Security를 통해서 암호화 하면 항상 다른 값이 나옴
		// 따라서 DB의 입력된 값과 비교를 하면 반드시 false가 나옴
		// 처리 방법은 Spring Security를 통해서 값을 확인하여 같은 값을 찾아 주는 matches 함수를 사용해야 한다
		String dbPw = sqlSession.selectOne(NS+"passwordCheck",map.get("id"));
		
		if(passwordEncoder.matches((String)map.get("pw"), dbPw)) {
		  vo = sqlSession.selectOne(NS+"enLogin",map.get("id"));
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
	public boolean changeUser(Map<String, Object> map) {
		return sqlSession.update(NS+"changeUser",map) > 0 ?true:false;
	}

	@Override
	public int idCheck(String id) {
		return sqlSession.selectOne(NS+"idCheck",id);
	}

	@Override
	public List<MemberVo> memberListRow(RowNumVo vo) {
		return sqlSession.selectList(NS+"memberListRow",vo);
	}

	@Override
	public int memberTotal() {
		return sqlSession.selectOne(NS+"memberTotal");
	}

}
