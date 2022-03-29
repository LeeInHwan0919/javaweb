package com.min.edu.mapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloHandler implements Handler {

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		logger.info("invoke에 의해서 실행된 메소드: "+this.getClass().getMethods());
		String param = request.getParameter("name");
		request.setAttribute("result", param+"싫어요 ㅜㅜ");
		return "hello";
	}

}
