package com.min.edu.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * Spring mvc:interceptor 를 통해서 특정한 RequestMapping 전에 실행되어 로직으로 수행하고
 * 결과에 따른 흐름제어가 가능하도록 함
 * 로그인이 되어야만 호출되는 페이지를 interceptor
 */
public class LoginChcekInterceptors extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// RequestMapping 전체 호출 되는 Handler
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("← ← ← ← 인터섹터 시작← ← ← ←");
		try {
			if(request.getSession().getAttribute("mem2")==null) {
				response.sendRedirect("./logout.do");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("← ←😊😊 ← ← 인터셉터 요청 확인이 필요← ←😊😊 ← ←");
		}
		return true;
	}
	
	// RequestMapping 실행 후에 호출 되는 Handler
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("😊😊😊😊인터셉터 종료😊😊😊😊");
		response.setHeader("Expires","0");
		response.setHeader("Pragma","no-cache");//Http 1.0
		response.setHeader("Cache-Control","no-cache, no-store"); //HTTP 1.1
		super.postHandle(request, response, handler, modelAndView);
	}

	// view렌더링이 끝난 직후 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("→ → → → →인터셉터 View 렌더링이 끝난 직후→ → → → →");
		super.afterCompletion(request, response, handler, ex);
	}

	// 비동기(rest = ResponseBody)식 호출 되었을 때 실행
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	
}
