package com.min.edu.aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP02_Main {

	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/aop02/AOP-Context.xml");
		
		Human w = bean.getBean("woman",Human.class);
		Human m = bean.getBean("man",Human.class);
		
		//아직은 만들지 못한것
		// 메소드가 실행된 전(before), 후(after)는 만들지 못했음
//		System.out.println("Woman 실행"); // Before
//		w.classWork();
		
		m.classWork();
		
				}

}
