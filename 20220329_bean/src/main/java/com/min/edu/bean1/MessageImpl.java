package com.min.edu.bean1;

// 은닉화 되어 있는 멤버필드를 가지고 있고 interface를 통해서 기능을 가진 => bean
public class MessageImpl implements IMessageBean {

	private String coffee;
	private String price;
	
	public MessageImpl() {//내부에서 default로 사용할 수 있는 생성자
		this.coffee = "케냐AA";
		this.price = "5000";
	}
	
	public MessageImpl(String coffee, String price) {// 외부에서 입력 할 수 있는 생성자
		super();
		this.coffee = coffee;
		this.price = price;
	}



	@Override
	public void call() {
		System.out.println(coffee+"의 가격은?" + price);
	}

}
