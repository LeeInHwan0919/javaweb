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


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(this.getClass());
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LoginServlet logout doGet");
		HttpSession session = request.getSession();
		session.invalidate();//세션을 삭제 
		response.sendRedirect("./loginForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LoginServlet login doPost");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		IUserDao dao = new UserDaoImpl();
		UserVo loginVo = dao.login(map);
		if(loginVo==null) {
			response.getWriter().print("<script>alert('잘못된 로그인 정보입니다'); location.href='./loginForm.jsp';</script>");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginVo", loginVo);
			
			IBoardDao bDao = new BoardDaoImpl();
			List<BoardVo> lists = bDao.getAllBoard();
			request.setAttribute("lists", lists);
			request.setAttribute("category", "b");
			
			request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
		}
	}

}
