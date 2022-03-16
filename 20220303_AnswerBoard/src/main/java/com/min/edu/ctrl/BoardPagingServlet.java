package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;
import com.min.edu.model.IPagingDao;
import com.min.edu.model.PagingDaoImpl;

public class BoardPagingServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5916152045030877901L;
	
	private Logger logger = Logger.getLogger(MainServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardPagingServlet doGet");
		
		IPagingDao dao = new PagingDaoImpl();

		logger.info("전체글 페이지 이동");
		int page = 0;
		if(req.getParameter("page")==null) {
			page = 1;
		}else {
			page = Integer.parseInt(req.getParameter("page"));
		}
		logger.info("입력된 페이지의 값 : " + page);
		
		int start = (page-1)*10;
		List<AnswerBoardDto> lists = dao.boardPaging(start);
		
		int count = dao.rowCount();
		
		req.setAttribute("lists", lists);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("/WEB-INF/views/boardListPaging.jsp").forward(req, resp);
	}

}
