package com.min.edu.anno02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno02_Main {

	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/anno02/ApplicationContext.xml");
		NickNameProp prop = bean.getBean("nickNameProp",NickNameProp.class);
		System.out.println(prop);
	}

}
