package com.min.edu.aop06;

import org.springframework.stereotype.Component;

@Component
public class RightBrain implements Person, ETC {

	@Override
	public void thinking() {
		System.out.println("오른쪽 뇌 작동 하여 생각하였습니다.");
	}
	
	/*
	 * aop는 상위 부모에서 가지고 있는 메소드만을 VMI 로 실행시킨다.
	 * 따라서 interface에 구성이 되어 있지 않다면 작동의 대상이 되지 않는다.
	 */
	@Override
	public String use(String action) {
		System.out.println("반환과 argument를 가지고 있는 메소드");
		return action+"한다";
	}

}
