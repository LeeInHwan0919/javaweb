package com.min.edu.bean3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean3_Main {

	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/bean3/beans.xml");
		System.out.println(bean.getBean("now"));
		System.out.println(bean.getBean("myDate"));
		
		UserDto dto = bean.getBean("myDto",UserDto.class);
		System.out.println(dto);
		System.out.println(dto.getName());
		System.out.println(dto.getPer());
		
		//UserServiceImpl 객체를 만들고
		//위에서 가져온 UserDto 객체를 AddUser();
		UserServiceImpl service = bean.getBean("userServiceImpl",UserServiceImpl.class);
		service.addUser(dto);
		
	}

}
