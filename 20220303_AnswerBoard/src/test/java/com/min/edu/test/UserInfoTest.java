package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.UserVo;
import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

public class UserInfoTest {

	@Test
	public void test() {
		IUserInfoDao uDao = new UserInfoDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "jinro");
		map.put("password", "1234");
		UserVo loginInfo = uDao.loginSelect(map);
		assertNotNull(map);
	}

}
