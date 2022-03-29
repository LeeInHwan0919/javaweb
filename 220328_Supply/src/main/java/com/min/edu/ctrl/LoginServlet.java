package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(this.getClass());
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LoginServlet doPost");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		response.getWriter().print("성공"); // Text 전송
//		response.getWriter().print("{\"isc\":\"테스트\"}"); // {"isc":"테스트"}
		
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("isc", "JSON값");
//		response.getWriter().print(jsonObj.toString());
		
		//맵 형식으로
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("check", "Map 값");
//		jsonObj.putAll(map);//이러면 알아서 JSON 형식으로
//		response.getWriter().print(jsonObj.toString());
		
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("isc","성공");
//		response.getWriter().print(jsonObj.toString());
		
		
	}

}
