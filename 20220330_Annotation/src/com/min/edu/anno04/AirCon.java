package com.min.edu.anno04;

import org.springframework.stereotype.Component;

@Component(value="samsung")
public class AirCon implements RemoteControl {

	@Override
	public void powerOn() {
		System.out.println("에어컨 켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("에어컨 끄다");
	}

}
