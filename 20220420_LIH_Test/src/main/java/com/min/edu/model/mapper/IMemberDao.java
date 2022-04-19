package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.MemberVo;

public interface IMemberDao {

	public List<MemberVo> selectAllMember();
	
	public int signUp(MemberVo vo);
	
	public int login(MemberVo vo);
	
	public String confirmPw(String id);
}
