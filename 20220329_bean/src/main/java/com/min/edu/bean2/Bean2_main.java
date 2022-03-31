package com.min.edu.bean2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean2_main {

	public static void main(String[] args) {
		
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/bean2/beans.xml");
		Address myAddr01 = (Address) bean.getBean("myAddr01");
		Address myAddr11 = (Address) bean.getBean("myAddr11");
		Address myAddr02 = (Address) bean.getBean("myAddr02");
		Address myAddr03 = (Address) bean.getBean("myAddr03");
		System.out.println(myAddr01);
		System.out.println(myAddr11);
		System.out.println(myAddr02);
		System.out.println(myAddr03);
		
		jobAddress woo = (jobAddress) bean.getBean("woo");
		jobAddress jiwoo = (jobAddress) bean.getBean("jiwoo");
		jobAddress gora = (jobAddress) bean.getBean("gora");
		System.out.println(woo);
		System.out.println(jiwoo);
		System.out.println(gora);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/bean2/beans.xml");
//		jobAddress woo = bean.getBean("woo",jobAddress.class);
//		System.out.println(woo);
//		
//		Address myAddr01 = bean.getBean("myAddr01",Address.class);
//		System.out.println(myAddr01);
	}	

}
