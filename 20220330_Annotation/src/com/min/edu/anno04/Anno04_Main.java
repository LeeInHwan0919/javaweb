package com.min.edu.anno04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno04_Main {

	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/anno04/Application.xml");
		RemoteControl rc = (RemoteControl) bean.getBean("television");
		rc.powerOff();
		rc = bean.getBean("samsung",RemoteControl.class);
		rc.powerOn();
		
	}

}
