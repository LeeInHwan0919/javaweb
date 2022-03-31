package com.min.edu.aop04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;

public class MyCCCAspect{

	public void beforeMethod() {
		System.out.println("메소드가 실행될 겁니다.");
	}

	
	public void afterMethod() {
		System.out.println("메소드가 종료 되었습니다.");
	}
	
}
