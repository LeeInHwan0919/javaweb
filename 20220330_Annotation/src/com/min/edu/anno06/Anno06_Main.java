package com.min.edu.anno06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno06_Main {
	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/anno06/Application.xml");
		UserServiceImpl user = bean.getBean("UserServiceImpl",UserServiceImpl.class);
		user.addUser();
	}
}
