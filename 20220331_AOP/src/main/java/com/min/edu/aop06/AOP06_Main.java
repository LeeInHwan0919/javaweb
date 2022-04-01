package com.min.edu.aop06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP06_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop06/application-context.xml");
		Person l = context.getBean("leftBrain",Person.class);
		l.thinking();
		
		System.out.println("-----------------------------");
		
		// Paerson : 부모의 타입을 자식을 VMI로 동작을 했지만
		// use: use는 부모가 가지고 있는 메소드가 아님 그래서 Spring AOP는 동작 안됨
		// spring bean configuration에 proxy-target-class="true"을 false로 변경하면
		// spring proxy가 아닌 JDK의 Proxy로 동작이 된다.(bean을 따라가지 않는다?)
		ETC r = context.getBean("rightBrain",ETC.class);
		String result = r.use("달리기");
		System.out.println("결과 : " + result);
		
		System.out.println("-----------------------------");
		
		Person rr = context.getBean("rightBrain",Person.class);
		rr.thinking();
		
	}

}
