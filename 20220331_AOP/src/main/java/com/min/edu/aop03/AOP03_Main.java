package com.min.edu.aop03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP03_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop03/AOP-context.xml");
		Human w = context.getBean("woman",Human.class);
		Human m = context.getBean("man",Human.class);
		w.classWork();
		System.out.println("====================");
		m.classWork();
	}

}
