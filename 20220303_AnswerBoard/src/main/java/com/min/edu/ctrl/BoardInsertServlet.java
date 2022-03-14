package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 2301030319178561574L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardInsertServlet doGET");
		HttpSession session = req.getSession();
		if(session.getAttribute("loginInfo")==null) {
			PrintWriter out = resp.getWriter();
			StringBuffer sb = new StringBuffer();
			sb.append("<script type=\"text/javascript\">");
			sb.append("alert(\"로그인을 해주세요\");");
//			sb.append("location.href=\"boardLogin.do\"");
			sb.append("</script>");
			out.print(sb.toString());
		}else {
		req.getRequestDispatcher("/WEB-INF/views/boardInsert.jsp").forward(req,resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardInsertServlet doPOST");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardInsertServlet doPost");
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		AnswerBoardDto dto = new AnswerBoardDto();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		logger.info("BoardModifyServlet doPost 전송받은 Parameter :"+dto);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc	= dao.insertBoard(dto);
	}
}
