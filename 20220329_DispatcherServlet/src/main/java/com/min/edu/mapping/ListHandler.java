package com.min.edu.mapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ListHandler implements Handler {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		logger.info("List 실행");
		
		return "list";
	}
	
	

}
