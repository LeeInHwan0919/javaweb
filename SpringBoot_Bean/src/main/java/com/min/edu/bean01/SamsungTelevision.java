package com.min.edu.bean01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class SamsungTelevision implements RemoteController{

	public SamsungTelevision() {
		System.out.println("삼성 텔레비젼 호출");
	}
	@Override
	public FunctionExecution powerOn() {
		System.out.println("@Component으로 생성된 SamsungTelevision 의 powerOn");
		return new FunctionExecution("텔리비젼을 켜다", "에어콘");
	}

	@Override
	public FunctionExecution powerOff() {
		System.out.println("@Component으로 생성된 SamsungTelevision 의 powerOff");
		return new FunctionExecution("텔리비젼을 켜다", "에어콘");
	}

}
