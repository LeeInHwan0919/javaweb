package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7862508891108010812L;
	private Logger logger = Logger.getLogger(BoardDeleteServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardDeleteServlet doGet");
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		String[] seq = req.getParameterValues("seq");
		logger.info("BoardDeleteServlet doGet 전송받은 Parametervalues :" + Arrays.toString(seq));
		boolean isc = dao.deleteBoard(seq);
		
		if(isc) {
			resp.sendRedirect("./main.do");
		}else {
			req.getRequestDispatcher("/WEB-INF/views/boardError.jsp").forward(req, resp);;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardDeleteServlet doPost");
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		String[] seq = req.getParameterValues("ch");
		logger.info("BoardDeleteServlet doPost 전송받은 Parametervalues :" + Arrays.toString(seq));
		boolean isc = dao.deleteBoard(seq);
		
		if(isc) {
//			resp.sendRedirect("./main.do");
			StringBuffer sb= new StringBuffer();
			sb.append("<script>");
			sb.append("alert('삭제가 완료되었습니다!');");
			sb.append("location.href='./main.do'");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		}else {
			req.getRequestDispatcher("/WEB-INF/views/boardError.jsp").forward(req, resp);;
		}
		
	}
	
	
	
	
}
