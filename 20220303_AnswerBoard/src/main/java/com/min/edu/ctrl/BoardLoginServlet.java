package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;

public class BoardLoginServlet extends HttpServlet {
	private static final long serialVersionUID = -9037088838873333671L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loc = req.getParameter("loc");
		System.out.println(loc);
		logger.info("BoardLoginServlet doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardLoginServlet doPost");
	
		//null을 String으로 받아옴
	String loc = req.getParameter("loc");
	
	HttpSession session = req.getSession();
	
	String id = req.getParameter("id");
	String password = req.getParameter("password");
	
	UserVo vo = new UserVo("테스트", id, "U");
	session.setAttribute("logininfo",vo);
	
//	req.getRequestDispatcher("/boardInsert.do").forward(req, resp);
	resp.sendRedirect("loc");
	}

}
