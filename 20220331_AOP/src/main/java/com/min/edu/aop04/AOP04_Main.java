package com.min.edu.aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP04_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop04/AOP-Context.xml");
		Human w = context.getBean("woman",Human.class);
		Human m = context.getBean("man",Human.class);
		
		w.classWork();
		m.classWork();
	}

}
