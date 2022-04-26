package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MemberVo;

public interface IMemberService {

	//회원 전체 조회
	public List<MemberVo> selectMemberAll();
	//회원 가입
	public int insertMember(Map<String, Object> map);
	//로그인
	public MemberVo loginMember(Map<String, Object> map);
	//비밀번호 확인
	public int passwordCheck(String pw);
	//ID로 로그인
	public MemberVo enLogin(String id);
	//ID중복확인
	public int idCheck(String id);
	
	public boolean changeUser(Map<String, Object> map);
}
