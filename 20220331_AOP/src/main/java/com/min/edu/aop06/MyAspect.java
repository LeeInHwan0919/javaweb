package com.min.edu.aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
  
  @Pointcut("execution(public void com.min.edu.aop06.LeftBrain.*(..))")
  public void userPointCutLeftBrain() {}
  
  @Pointcut("execution(public void com.min.edu.aop06.RightBrain.*(..))")
  public void userPointCutRightBrain() {}
  
  @Pointcut("execution(public void com.min.edu.aop06.*.*(..))")
  public void userPointCutBrain() {}
  
  @Before("userPointCutBrain()") //모두 동작되도록?
  public void before() {
	  System.out.println("메소드 시작전 공통으로 실행됨");
  }
  
  @After("userPointCutLeftBrain()")
  public void afterLeft() {
	  System.out.println("난 왼쪽 뇌 after 입니다.");
  }
  
  @After("userPointCutRightBrain()")
  public void afterRight() {
	  System.out.println("난 오른쪽 뇌 after 입니다.");
  }
  
  @AfterReturning("execution(public * *(..))")
  public void afterReturning(JoinPoint join) {
	  System.out.println("$$$$"+join.getSignature().getName());
	  Object[] args = join.getArgs();
	  for (Object obj : args) {
		System.out.println("메소드를 실행하기 위한 Arguments : "+(String)obj);
	}
  }
  
  
}


