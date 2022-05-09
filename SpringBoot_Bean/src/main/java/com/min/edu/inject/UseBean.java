package com.min.edu.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.min.edu.bean01.RemoteController;
import com.min.edu.bean01.SamsungTelevision;

@Component
public class UseBean {

	@Autowired
	private RemoteController samsungTelevision;
	
	public UseBean(RemoteController samsungTelevision) {
		this.samsungTelevision = samsungTelevision;
		System.out.println("주입된 객체 실행");
		print();
	}
	
	public void print() {
		System.out.println("UseBean 프린트 실행");
		System.out.println(samsungTelevision.powerOff());
		System.out.println(samsungTelevision.powerOn());
		
	}
}
