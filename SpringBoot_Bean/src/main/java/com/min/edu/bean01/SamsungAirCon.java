package com.min.edu.bean01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SamsungAirCon /* implements RemoteController */{

	public SamsungAirCon() {
		System.out.println("SamsungAirCon");
	}
	
	// bean name을 작성하여 등록
	@Bean(name = "ariconON")
	public FunctionExecution powerOn() {
		System.out.println("@Bean으로 생성된 SamsungAirCon 의 powerOn");
		return new FunctionExecution("에어콘 켜다", "에어콘");
	}
	
	@Bean
	public FunctionExecution powerOff() {
		System.out.println("@Bean으로 생성된 SamsungAirCon 의 powerOff");
		return new FunctionExecution("에어콘 끄다", "에어콘");
	}

}
