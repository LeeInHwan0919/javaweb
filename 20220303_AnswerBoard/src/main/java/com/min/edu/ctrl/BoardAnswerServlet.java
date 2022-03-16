package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.comm.JSFlow;
import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardAnswerServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3264143122039552633L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		logger.info("BoardInsertServlet doGet");
		
		String seq = req.getParameter("seq");
		logger.info("받은 seq는 " + seq);
		
		
		
		HttpSession session = req.getSession();
		if(session.getAttribute("loginInfo") == null) {
			PrintWriter out = resp.getWriter();
			String str = JSFlow.jsForward("로그인을 해주세요", "./boardLogin.do?loc=boardAnswer.do?seq="+seq);
			out.print(str);
		}else {
			IAnswerBoardDao dao = new AnswerBoardDaoImpl();
			AnswerBoardDto iDto = new AnswerBoardDto();
			iDto.setSeq(Integer.parseInt(seq));
			AnswerBoardDto dto = dao.selectDetailBoard(iDto);
//			dto.setSeq(Integer.parseInt(seq));
			req.setAttribute("dto", dto);
			logger.info("dto에서 출력된 값"+dto);
			req.getRequestDispatcher("/WEB-INF/views/boardAnswer.jsp").forward(req, resp);
		}
//		req.getRequestDispatcher("WEB-INF/views/boardAnswer.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = req.getSession();
		UserVo loginVo = (UserVo)session.getAttribute("loginInfo");
		
		logger.info("BoardInsertServlet doPost");
		
		String pSeq = req.getParameter("seq");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		logger.info("BoardInsertServlet doPost 전달받은 값 " + pSeq);
		logger.info("BoardInsertServlet doPost 전달받은 값 " + title);
		logger.info("BoardInsertServlet doPost 전달받은 값 " + content);
		
		AnswerBoardDto dto = new AnswerBoardDto();
		dto.setSeq(Integer.parseInt(pSeq));
		dto.setId(loginVo.getId());
		dto.setTitle(title);
		dto.setContent(content);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		
		boolean isc = dao.reply(dto);
		
		if(isc) {
			resp.sendRedirect("./boardDetail.do?seq="+dto.getSeq());
		}else {
			resp.sendRedirect("./logout.do");
		}
		
	}
}
