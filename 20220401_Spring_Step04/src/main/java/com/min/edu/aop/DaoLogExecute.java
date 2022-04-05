package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoLogExecute {
	
	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("시작");
		
		Object[] obj = j.getArgs();
		if(obj!=null) {
			logger.info("method \t {}",j.getSignature().getName()); //j.getSignature().getName()메소드명
			for (int i = 0; i < obj.length; i++) {
				logger.info(i+"번째:\t"+obj[i]);
			}
			logger.info("method \t {}",j.getSignature().getName());
		}
	}
	
	public void afterReturning(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("끝");
	}
	
	//다시 예외작성을 해줘야 함
	public void error(JoinPoint j, Exception exception) throws Exception{
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("에러 \t{}",j.getArgs());
		logger.info("에러 \t{}",exception.toString());
	}
}
