package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

public interface IMemberDao {

	public List<MemberVo> selectMemberAll(RowNumVo vo);
	public int insertMember(Map<String, Object> map);
	public MemberVo loginMember(Map<String, Object> map);
	public int passwordCheck(String pw);
	public MemberVo enLogin(String id);
	public int idCheck(String id);
	public boolean changeUser(Map<String, Object> map);
	
	/*
	 * member 페이징
	 */
	public List<MemberVo> memberListRow(RowNumVo vo);
	public int memberTotal();
}
