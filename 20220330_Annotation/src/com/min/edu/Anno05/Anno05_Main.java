package com.min.edu.Anno05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno05_Main {

	public static void main(String[] args) {
	  ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/Anno05/Application.xml");
	  School obj = (School) bean.getBean("school");
	  System.out.println(obj);
			  }

}
