package com.min.edu.bean01;

public class FunctionExecution {

	private String msg;
	private String device;
	
	public FunctionExecution() {
	}

	public FunctionExecution(String msg, String device) {
		super();
		this.msg = msg;
		this.device = device;
	}

	@Override
	public String toString() {
		return "실행되는 장치는  [device=" + device + "/  msg=" + msg+ "]";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
	
	
}
