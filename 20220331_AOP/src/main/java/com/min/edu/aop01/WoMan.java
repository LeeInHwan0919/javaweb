package com.min.edu.aop01;

public class WoMan {

	public void work() {
		System.out.println("Woman 들어옴"); //CCC 메소드 실행을 확인
		try {//CCC 예외가 발생되었을 때 처리 하기 위해서
			System.out.println("컴퓨터를 켠다"); //로직 //CC
		} catch (Exception e) {
			System.out.println("쉬는 날이다.");// CCC 예외가 발생되었을 때 로그 용도
		}finally {
			System.out.println("오늘 일정이 끝났다");// CCC 메소드 종료 전에 확인
		}
	}
}
