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
public class MamberDaoImpl implements IMemberDao {

	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<MemberVo> selectAllMember() {
		return sqlSession.selectList(NS+"selectAllMember");
	}

	@Override
	public int signUp(Map<String, Object> map) {
		String enPw = passwordEncoder.encode((String)map.get("pw"));
		map.put("pw", enPw);
		System.out.println("암호화된 비밀번호 : " + map.get("pw"));
		return sqlSession.insert(NS+"signUp",map);
	}

	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		MemberVo vo = null;
		String dbPw = sqlSession.selectOne(NS + "passwordCheck", map.get("id"));
		if(passwordEncoder.matches((String)map.get("pw"), dbPw)) {
			vo = sqlSession.selectOne(NS+"enLogin", map.get("id"));
		}
		return vo;
	}


	@Override
	public String findID(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"findID",map);
	}

	@Override
	public String passwordCheck(String id) {
		return sqlSession.selectOne(NS+"passwordCheck",id);
	}

	@Override
	public MemberVo enLogin(String id) {
		return sqlSession.selectOne(NS+"enLogin",id);
	}

	@Override
	public List<MemberVo> memberListRow(RowNumVo vo) {
		return sqlSession.selectList(NS+"memberListRow",vo);
	}

	@Override
	public int memberListTotal() {
		return sqlSession.selectOne(NS+"memberListTotal");
	}

	
	

	
	
}
