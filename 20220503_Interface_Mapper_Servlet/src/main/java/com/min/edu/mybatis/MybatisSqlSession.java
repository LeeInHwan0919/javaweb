package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.min.edu.sqls.SqlJobsInterface_Mapper;

@SuppressWarnings("unchecked")
public class MybatisSqlSession {

	private static SqlSessionFactory factory;
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	static {
		String path = "com/min/edu/mybatis/Configuration.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
			//Sql Interface Mapper 연결
			@SuppressWarnings("rawtypes")
			Class[] mappers = {SqlJobsInterface_Mapper.class};
			
			for (@SuppressWarnings("rawtypes") Class c : mappers) {
				factory.getConfiguration().addMapper(c);
			}
			
			
			System.out.println("SqlSessionFactory 객체 생성");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
