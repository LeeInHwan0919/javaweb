package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserVO;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardModifyServlet extends HttpServlet {

	private static final long serialVersionUID = -7303674362118819017L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardModifyServlet Doget");
		String seq = req.getParameter("seq");
		logger.info("BoardModifyServlet Doget 전송받은 파라미터 "+ seq);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		AnswerBoardDto tmpDto = new AnswerBoardDto();
		tmpDto.setSeq(Integer.parseInt(seq));
		AnswerBoardDto dto = dao.selectDetailBoard(tmpDto);
		logger.info("BoardModifyServlet doGet 선택된 글 상세 정보" + dto);
		UserVO loginVo = (UserVO)req.getSession().getAttribute("loginInfo");
		if(loginVo.getId().equals(dto.getId())) {
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/WEB-INF/views/boardModify.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("./logout.do");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardModifyServlet doPost");
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		logger.info("BoardModifyServlet doPost 전송받은 paprameter는 " + seq + " / " + content);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		map.put("con", content);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc = dao.modifyBoard(map);
		
		if(isc) {
			resp.sendRedirect("./boardDetail.do?seq="+seq);
		}else {
			resp.sendRedirect("./logout.do");
		}
	}
}