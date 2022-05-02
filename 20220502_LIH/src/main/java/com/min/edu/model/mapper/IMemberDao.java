package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MemberVo;

public interface IMemberDao {

	public List<MemberVo> selectAllMember();
	
	public int signUp(Map<String, Object> map);
	
	public int login(Map<String, Object> map);
	
	public String confirmPw(String id);
	
	//아이디 찾기
	public String findID(Map<String, Object> map);
}
