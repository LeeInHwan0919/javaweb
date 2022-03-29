package com.min.edu.bean2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean2_main {

	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/bean2/beans.xml");
		jobAddress woo = bean.getBean("woo",jobAddress.class);
		System.out.println(woo);
		
		Address myAddr01 = bean.getBean("myAddr01",Address.class);
		System.out.println(myAddr01);
	}	

}
