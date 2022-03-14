package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//로그아웃을 작업 함
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 3835213824178628890L;

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate(); //session 객체를 지움 => 이걸 주로 씀

//		session.removeAttribute("loginInfo");//session의 정보를 지움
		req.getRequestDispatcher("WEB-INF/views/boardLogin.jsp").forward(req, resp);
	}
}
