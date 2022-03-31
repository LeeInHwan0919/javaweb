package com.min.edu.aop06;

import org.springframework.stereotype.Component;

@Component
public class LeftBrain implements Person {

	@Override
	public void thinking() {
		System.out.println("왼쪽 뇌 작동 하여 생각하였습니다.");
	}

}
