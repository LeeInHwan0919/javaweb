package com.min.edu.anno04;

import org.springframework.stereotype.Component;

@Component
public class Television implements RemoteControl {

	@Override
	public void powerOn() {
		System.out.println("텔레비젼 켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("텔레비젼 끄다");
	}

}
