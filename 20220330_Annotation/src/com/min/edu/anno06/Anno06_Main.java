package com.min.edu.anno06;

import javax.annotation.security.DeclareRoles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class Anno06_Main {
	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/anno06/Application.xml");
		
		UserServiceImpl user1 = bean.getBean("userServiceImpl",UserServiceImpl.class);
		user1.addUser();
	}
}
