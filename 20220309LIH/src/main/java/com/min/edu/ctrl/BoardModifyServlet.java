package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1701687481306402544L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/boardModify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardModifyServlet doPost");
		
		HttpSession session = req.getSession();
		String seq = (String) session.getAttribute("seq");
		String content = req.getParameter("content");
		logger.info("BoardModifyServlet doPost 전송받은 Parameter :"+seq+"/"+content);
		
		AnswerBoardDto dto = new AnswerBoardDto(Integer.parseInt(seq),content);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc	= dao.modifyBoard(dto);
		
		if (isc) {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>");
			sb.append("alert('수정이 완료되었습니다.');");
			sb.append("location.href='./main.do'");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		} else {
			req.getRequestDispatcher("/WEB-INF/views/boardError.jsp").forward(req, resp);
			;
		}
	}

}
