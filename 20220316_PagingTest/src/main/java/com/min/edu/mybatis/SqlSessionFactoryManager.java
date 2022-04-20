package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {
	private static SqlSessionFactory fac;

	public static SqlSessionFactory getFac() {
		return fac;
	}
	
	static {
		String path = "properties/Config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			fac = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
