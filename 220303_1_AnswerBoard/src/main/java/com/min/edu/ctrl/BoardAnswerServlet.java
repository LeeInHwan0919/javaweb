package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardAnswerServlet extends HttpServlet {

	private static final long serialVersionUID = -1153767239244098087L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		logger.info("받은 seq는 " + seq);
		
		req.setAttribute("seq",seq);
//		req.getRequestDispatcher("WEB-INF/views/boardAnswer.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardInsertServlet doPost");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String seq = req.getParameter("seq");
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		AnswerBoardDto dto = new AnswerBoardDto();
		dto.setSeq(Integer.parseInt(seq));
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		
		logger.info("BoardInsertServlet doPost 전송 받은 파라미터");
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		Boolean isc = dao.reply(dto);
	}
}
