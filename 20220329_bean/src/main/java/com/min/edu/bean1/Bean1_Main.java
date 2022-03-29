package com.min.edu.bean1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean1_Main {

	public static void main(String[] args) {
		//Spring Container에 Spring Bean을 등록을 해야함
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/bean1/beans.xml");
		
		IMessageBean coffee1 = bean.getBean("Kenya", IMessageBean.class);
		coffee1.call();
		
		IMessageBean coffee2 = bean.getBean("Americano", IMessageBean.class);
		coffee2.call();
		
		IMessageBean coffee3 = bean.getBean("Arabica", IMessageBean.class);
		coffee3.call();
	}

}
