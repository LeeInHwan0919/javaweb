package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;


public class LoginController extends HttpServlet {
	
	private Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = -3442429939286760666L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		logger.info("login do Post");
		
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		
		logger.info(id+password);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		
		IUserDao uDao = new UserDaoImpl();
		int cnt = uDao.selectUser(map);
		if(cnt>0) {
			resp.sendRedirect("./loginSuccess.do");
		}else {
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
	}

}
