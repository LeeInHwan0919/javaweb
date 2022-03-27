package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class RealSignUpController extends HttpServlet {

	private static final long serialVersionUID = 5489177374574325699L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String id = req.getParameter("id");
		String password = req.getPa                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  rameter("pw");
		String name = req.getParameter("name");
		
		UserDto dto = new UserDto(id, password, name);
		IUserDao dao = new UserDaoImpl();
		
		int cnt2 = dao.insertUser(dto);
		
		if(cnt2>0) {
			req.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(req,resp);
		}else {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>"
					+ "alert('회원가입에 실패하였습니다.');"
					+ "</script>");
			resp.getWriter().println(sb.toString());
		}
	}
}
