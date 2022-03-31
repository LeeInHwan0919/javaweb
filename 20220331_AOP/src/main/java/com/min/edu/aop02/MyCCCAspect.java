package com.min.edu.aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 
 *  주관심사 클래스인 Man과 Women의 주 기능인 classWork를 감싸서 CCC로 처리
 *  -> 기존에는 CC에 포함하여 CCC를 작성해줘야 함
 *     CC는 코드만을 작성하고 CCC를 공통으로 만들어서 CC에 적용함
 *
 */
public class MyCCCAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object resultObj = null;
		
		System.out.println("메소드를 실행 한다.");
		
		try {
			resultObj = invocation.proceed(); //CC를 끌고 오게됨 proxy 설정
		} catch (Throwable e) {
			System.out.println("오류가 발생 했다.");
		}finally {
			System.out.println("메소드가 종료되었따.");
		}	
		return resultObj;
	}

	
}
