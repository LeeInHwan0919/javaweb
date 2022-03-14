package com.min.edu.loginctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVO;

public class BoardLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 8512633581453199379L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardLoginServlet doGet");
		
		String loc = req.getParameter("loc");
		logger.info("BoardLoginServlet doPost : " + loc);
		
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardLoginServlet doPost");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String loc = req.getParameter("loc");
		
		logger.info("BoardLoginServlet doPost : " + loc);
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String passowrd = req.getParameter("password");
		
		UserVO vo = new UserVO("테스트", id, "U");
		session.setAttribute("loginInfo", vo);
		
//		req.getRequestDispatcher("/boardInsert.do").forward(req, resp);
		//null을 String으로 받아옴
		if(loc.equals("null")) {
			logger.info("여기 찍어야돼 양반아");
			resp.sendRedirect("./main.do");
		}else {
			resp.sendRedirect(loc);			
		}
	}
}
