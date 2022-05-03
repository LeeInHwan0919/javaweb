package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MemberVo;

public interface IMemberService {
	
public List<MemberVo> selectAllMember();
	
	public int signUp(Map<String, Object> map);
	
	public MemberVo loginMember(Map<String, Object> map);
	
	public String passwordCheck(String id);
	public MemberVo enLogin(String id);
	
	//아이디 찾기
	public String findID(Map<String, Object> map);
}
