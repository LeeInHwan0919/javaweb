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

import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;
import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

public class BoardLoginServlet extends HttpServlet {
	private static final long serialVersionUID = -9037088838873333671L;
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
		String password = req.getParameter("password");
		
//		UserVo vo = new UserVo();
//		vo.setId(id);
//		vo.setName("세미콜론");
//		vo.setAuth("A");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		
		IUserInfoDao uDao = new UserInfoDaoImpl();
		UserVo vo = uDao.loginSelect(map);
		
		
		session.setAttribute("loginInfo", vo);
		
//		req.getRequestDispatcher("/boardInsert.do").forward(req, resp);
//		null을 String으로 받아옴
		if(loc==null) {
			resp.sendRedirect("./main.do");
		}else {
			resp.sendRedirect(loc);			
		}
		
		
		
	}

}
