package com.min.edu.anno03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno03_Main {

	public static void main(String[] args) {
		ApplicationContext bean =
				new ClassPathXmlApplicationContext("com/min/edu/anno03/ComponentScan.xml");
		Object obj = bean.getBean("nickNameProp");
		  System.out.println(obj);
		  Object obj2 = bean.getBean("nickName");
		  System.out.println(obj2);
	}

}
