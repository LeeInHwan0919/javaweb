package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherCtrl extends HttpServlet {

	private static final long serialVersionUID = -5982128587639515540L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("사용되는 Protocol : {}", "doGet 입니다.");
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("사용되는 Protocol : {}", "doPost 입니다.");
		doProcess(req, resp);
		
	}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doProcess 처리");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String code = request.getParameter("zone");
		logger.info("전달받은 Parameter {} ",code);
		
		PrintWriter out = response.getWriter(); //요청된 화면으로 값만 보내줌
//		out.print("안녕");
//		out.print("{\"rdata\":\"안녕\"}");
//		jobj.put("rdata", "클레오파트라");
		Map<String, String> map = new HashMap<String, String>();
		map.put("test", "테스트");
		JSONObject jobj = new JSONObject(map);
		System.out.println(jobj.toJSONString());
		
		request.setAttribute("zone",code);
		request.getRequestDispatcher("/weatherInfo.jsp").forward(request, response);
		
	}
}








