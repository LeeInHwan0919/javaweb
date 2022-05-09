package com.min.edu;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.min.edu.bean01.FunctionExecution;
import com.min.edu.bean01.SamsungAirCon;
import com.min.edu.bean01.SamsungTelevision;
import com.min.edu.inject.UseBean;


@SpringBootApplication
public class SpringBootBeanApplication implements CommandLineRunner{

	//@Autowired
	@Resource //반환타입이 두개라서 두개가 찾아짐 Qualifier사용해야함
	private UseBean useBean;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanApplication.class, args);
		
		
		// 컨테이너 생성
//		ApplicationContext context =
//                new AnnotationConfigApplicationContext(SamsungAirCon.class);
		
		//bean 호출 및 실행
//		FunctionExecution ariconON = context.getBean("ariconON", FunctionExecution.class);
//		FunctionExecution ariconOff = context.getBean("powerOff", FunctionExecution.class);
//		
//		System.out.println(ariconON.toString());
//		System.out.println(ariconOff.toString());
		
		
//		ApplicationContext context =
//              new AnnotationConfigApplicationContext(SamsungTelevision.class);
//		SamsungTelevision tv = context.getBean("samsungTelevision", SamsungTelevision.class);
//		tv.powerOn();
//		tv.powerOff();
//
		
//		ApplicationContext context =
//              new AnnotationConfigApplicationContext(UseBean.class);
//		UseBean ub = context.getBean("UseBean", UseBean.class);
//		ub.print();

	}

	@Override
	public void run(String... args) throws Exception {
		useBean.print();
	}

}
