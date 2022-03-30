package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.BoardVo;
import com.min.edu.dto.UserVo;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import net.sf.json.JSONObject;


public class LoginAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LoginAjax doPost REST 처리");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.printf("아이디 : %s / 비밀번호 : %s \n",id,pw);
		
//		response.getWriter().print("성공"); // Text 전송
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
//		jsonObj.put("isc","실패");
//		response.getWriter().print(jsonObj.toString());
		
		IUserDao dao = new UserDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		JSONObject json = new JSONObject();
		if(dao.login(map) !=null) {
			json.put("isc", "성공");
			response.getWriter().print(json.toString());
		}else {
			json.put("isc", "실패");
			response.getWriter().print(json.toString());
		}
		
		
	}

}
