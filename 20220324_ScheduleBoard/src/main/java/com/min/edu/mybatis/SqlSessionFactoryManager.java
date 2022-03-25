package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class SqlSessionFactoryManager {

    private static SqlSessionFactory factory;

    public static SqlSessionFactory getFactory() {
        return factory;
    }

    static {
        String path="com/min/edu/mybatis/Configure.xml";
        try {
            Reader reader = Resources.getResourceAsReader(path);
            factory = new SqlSessionFactoryBuilder().build(reader);
            System.out.println("객체 생성완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}