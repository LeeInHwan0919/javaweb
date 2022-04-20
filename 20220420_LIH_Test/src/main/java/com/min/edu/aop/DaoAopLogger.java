package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoAopLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(DaoAopLogger.class);
	
	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.warn("====@aop@ Method 실행 전 ====");
		
		Object [] obj = j.getArgs();
		
		if(obj != null) {
			logger.warn("====@aop@ {} ====", j.getSignature().getName());
			
			for(int i = 0; i < obj.length; i++) {
				logger.warn(i+"번째 args : " + String.valueOf(obj[i]));
			}
			
			logger.warn("====@aop@ {} ====", j.getSignature().getName());
		}
	}
	
}
