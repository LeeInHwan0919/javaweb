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

public class BoardDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 5439537080009220204L;
	
	private Logger logger = Logger.getLogger(BoardDetailServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardDetailServlet doGet");
		String seq = req.getParameter("seq");
		logger.info("BoardDetailServlet doGet 전송받은 parameter :" + seq);
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		AnswerBoardDto dto = new AnswerBoardDto();
		dto.setSeq(Integer.parseInt(seq));
		AnswerBoardDto resultDto = dao.selectDetailBoard(dto);
		req.setAttribute("dto", resultDto);
		req.getRequestDispatcher("/WEB-INF/views/boardDetail.jsp").forward(req, resp);
		
//		req.setAttribute("dto", resultDto);
//		req.getRequestDispatcher("/WEB-INF/views/boardDetail.jsp").forward(req, resp);
	}
}
