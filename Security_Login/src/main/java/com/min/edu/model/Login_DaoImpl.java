package com.min.edu.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.min.edu.dtos.MemberDto;

@Repository
public class Login_DaoImpl implements Login_IDao{

	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final String NS = "com.min.login.";

	@Override
	public MemberDto loginChk(String id) {
		MemberDto dto = session.selectOne(NS+"loginChk", id);
		System.out.println("DTO : " + dto);
		
		return dto;
	}

	@Override
	public boolean signUp(MemberDto dto) {
		// 화면에서 입력된 비밀번호를 암호화
		String encodePw = passwordEncoder.encode(dto.getPw());
		// 암호화된 비밀번호를 저장
		dto.setPw(encodePw);
		
		return session.insert(NS+"signUp", dto) > 0 ? true : false;
	}

}
