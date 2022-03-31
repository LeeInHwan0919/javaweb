package com.min.edu.aop05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyCCCAspect{
    
	//인터페이스 방법 pointCut을 선언하는 방법
	//같은 joinpoint가 아닌 여러개의 joinpoint를 선언하여 변수와 같은 방법으로 사용 할 수 있음
	@Pointcut("execution(public * *(..))")
	public void myClass(){}
	
	@Before("myClass()")
	public void beforeMethod() {
		System.out.println("메소드가 실행될 겁니다.");
	}

	@After("myClass()")
	public void afterMethod() {
		System.out.println("메소드가 종료 되었습니다.");
	}
	
}
