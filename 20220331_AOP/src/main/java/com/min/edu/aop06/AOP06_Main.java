package com.min.edu.aop06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP06_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop06/application-context.xml");
		Person l = context.getBean("leftBrain",Person.class);
		l.thinking();
		
		System.out.println("-----------------------------");
		
		ETC r = context.getBean("rightBrain",ETC.class);
		String result = r.use("달리기");
		System.out.println("결과 : " + result);
		
		System.out.println("-----------------------------");
		
		Person rr = context.getBean("rightBrain",Person.class);
		rr.thinking();
		
	}

}
