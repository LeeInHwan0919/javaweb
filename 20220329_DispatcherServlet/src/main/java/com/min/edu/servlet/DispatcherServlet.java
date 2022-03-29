package com.min.edu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.mapping.Handler;


public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = -508950263840233540L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  logger.info("DispatcherServlet doGet");
	  handleRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      logger.info("DispatcherServlet doPost");
      handleRequest(req, resp);
	}
	
	private void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		logger.info("handleRequest");
		/*
		 *  1. 요청된 주소에서 정보를 추출
		 *   http://localhost:8099/20220329_DispatcherServlet/app/Hello.do?name=coffee
		 *   위에 주소에서 Hello 단어를 추출
		 *   Hello => com.min.edu.mapping.HelloHandler
		 *   처리가 되면 Invoke 실행 Reflection으로 해당 객체를 만들어 줌
		 */
		
		try {
			Handler handler =  handlerMapping(request);
			System.out.println("생성된 Handler 객체 : "+handler);
			
			/*
			 * 2. 생성된 Class에 있는 메소드를 선언하여 invoke를 통해 실행한다.
			 *    실행 후 결과를 이동 화면의 이름만 받는다.
			 */
			String viewName = handlerAdapter(handler, request, response);
			logger.info("이동 할 화면의 이름 : "+viewName);
			helperView(viewName,request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	

	private Handler handlerMapping(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String uri = request.getRequestURI();
		logger.info("요청받은 URI : " + uri);
		//20220329_DispatcherServlet/app/Hello?name=coffee
		
		String handlerName = "com.min.edu.mapping."+uri.substring(uri.lastIndexOf("/")+1)+"Handler";
		logger.info("요청한 invoke 클래스의 위치 : "+handlerName);
		
		Class handlerClass = Class.forName(handlerName);
		return (Handler)handlerClass.newInstance();
	}
	
	
	private String handlerAdapter(Handler handler, HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//입력받은 handler의 메소드인 handle을 실행시키면 VMI
		//원래 생성되었던 클래스의 기능이 실행된다
		//invoke를 통해서 Reflection의 결과를 받아냄
		
		Method handlerMethod = handler.getClass().getMethod("handle", HttpServletRequest.class, HttpServletResponse.class);
		return (String)handlerMethod.invoke(handler, request, response);
	}
	
	private void helperView(String viewName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Resolver
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		String uri = prefix+viewName+suffix;
		request.getRequestDispatcher(uri).forward(request, response);
	}
}
