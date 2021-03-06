package com.min.edu.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {
	public static SqlSessionFactory factory;

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	static {
		String path = "com/min/edu/mybatis/Config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("Session 객체 생성 성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
