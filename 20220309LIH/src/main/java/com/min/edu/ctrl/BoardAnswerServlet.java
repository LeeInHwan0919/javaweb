package com.min.edu.ctrl;

import java.io.IOException;

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

public class BoardAnswerServlet extends HttpServlet {

	private static final long serialVersionUID = -3264143122039552633L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/boardAnswer.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardAnswerServlet doPost");

		HttpSession session = req.getSession();
		String seq = (String)session.getAttribute("seq");
		logger.info("settttseq값" + seq);
		
		UserVo vo = (UserVo)session.getAttribute("loginInfo");
		String id = vo.getId();
		logger.info("seq값" + vo.getId());
		
		String title = req.getParameter("title");
		logger.info("seq값" + title);
		
		String content = req.getParameter("content");
		logger.info("seq값" + content);
		
		AnswerBoardDto dto = new AnswerBoardDto(Integer.parseInt(seq), id, title, content);
		logger.info("BoardModifyServlet doPost 전송받은 Parameter :" + dto);

		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc = dao.reply(dto);

		if (isc) {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>");
			sb.append("alert('답글 작성이 완료되었습니다.');");
			sb.append("location.href='./main.do'");
			sb.append("</script>");
			
			resp.getWriter().println(sb.toString());
		} else {
			req.getRequestDispatcher("/WEB-INF/views/boardError.jsp").forward(req, resp);
			
		}
	}

}
