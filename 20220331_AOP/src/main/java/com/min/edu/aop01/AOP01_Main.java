package com.min.edu.aop01;

public class AOP01_Main {

	public static void main(String[] args) {
		// 기능의 목적은 work를 실행
		//  Man 클래스의 work는 개발자가 원했던 결과 "컴퓨터를 켠다"
		Man m = new Man();
		m.work();
		
		//Woman 실행이 되면서 실행 순서와 상황 조건을 확인
		System.out.println("Woman 클래스를 실행하겠습니다.");
		WoMan w = new WoMan();
		w.work();
	}

}
