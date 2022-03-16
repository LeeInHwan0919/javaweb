package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.UserVo;

public interface IUserInfoDao {
	
	/**
	 * 화면의 아이디와 비밀번호를 입력받아 정보를 반환함
	 * @param id와 password의 키를 가진 Map 객체
	 * @return 회원 정보
	 */
	public UserVo loginSelect(Map<String, Object> map);
}
