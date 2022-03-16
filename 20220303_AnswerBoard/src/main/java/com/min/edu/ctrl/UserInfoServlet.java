package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class UserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 6777807851843178524L;
	private Logger logger = Logger.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("UserInfoServlet doGet");
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		List<UserVo> lists = dao.userInfoAll();
		logger.info("UserInfoServlet doGet 전달받은 lists : "+lists);
		
		req.setAttribute("userList", lists);
		
		req.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(req, resp);
	}
}
