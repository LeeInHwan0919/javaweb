package com.min.edu.bean2;

public class jobAddress {

	private Address addr;
	private String poketmon;
	
	public jobAddress() {
		this.addr = new Address("고라파덕", "물", "054");
		this.poketmon = "오리포켓몬";
	}

	public jobAddress(Address addr, String poketmon) {
		this.addr = addr;
		this.poketmon = poketmon;
	}

	@Override
	public String toString() {
		return "jobAddress [addr=" + addr + ", poketmon=" + poketmon + "]";
	}
	
	
	
}
