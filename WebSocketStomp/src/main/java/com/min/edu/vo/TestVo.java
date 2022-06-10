package com.min.edu.vo;

import java.io.Serializable;

public class TestVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String susin;
	private String barsin;
	
	public TestVo() {
	}

	public String getSusin() {
		return susin;
	}

	public void setSusin(String susin) {
		this.susin = susin;
	}

	public String getBarsin() {
		return barsin;
	}

	public void setBarsin(String barsin) {
		this.barsin = barsin;
	}

	@Override
	public String toString() {
		return "TestVo [susin=" + susin + ", barsin=" + barsin + "]";
	}
	
	
	
}
