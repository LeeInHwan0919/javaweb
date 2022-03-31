package com.min.edu.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyCCCAspect{

	/**
	 * 메소드가 실행되기 전에 자동 실행되는 CCC
	 */
	@Before("execution(public void com.min.edu.aop03.*.*(..))")
	public void beforeMethod() {
		System.out.println("메소드가 실행될 겁니다.");
	}
	
	/**
	 * 메소드가 예외가 발생 했을때 자동 실행되는 CCC
	 */
	@AfterThrowing(pointcut = "execution(public void com.min.edu.aop03.*.*(..))", throwing = "e")
	public void exceptionMethod() {
		System.out.println("메소드 실행 중 예외가 발생 했습니다.");
	}
	
	/**
	 * 메소드가 실행완료 된 후에 자동 실행되는 CCC
	 */
	@After("execution(public void com.min.edu.aop03.Woman.*(..))")
	public void afterMethod() {
		System.out.println("메소드가 종료 되었습니다.");
	}
	
}
