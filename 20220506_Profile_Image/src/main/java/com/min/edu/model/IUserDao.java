package com.min.edu.model;

import com.min.edu.vo.UserVo;

public interface IUserDao {

	/**
	 * 사용자 정보 입력
	 * @param 아이디, 비밀번호, 프로필사진
	 * @return 성공(true), 실패(false)
	 * @author LeeInHwan
	 * @since 2022.05.06.
	 */
	public boolean insertUser(UserVo vo);
}
