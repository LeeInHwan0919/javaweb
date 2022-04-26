package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

public interface IMemberService {

	public List<MemberVo> selectMemberAll(RowNumVo vo);
	public int insertMember(Map<String, Object> map);
	public MemberVo loginMember(Map<String, Object> map);
	public int passwordCheck(String pw);
	public MemberVo enLogin(String id);
	public boolean changeUser(Map<String, Object> map);
	public int idCheck(String id);
	
	public List<MemberVo> memberListRow(RowNumVo vo);
	public int memberTotal();
}
