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

public class BoardInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 2301030319178561574L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		HttpSession session =  req.getSession();
		UserVo loginInfo = (UserVo) session.getAttribute("loginInfo");
		if(loginInfo == null) {
			StringBuffer sb= new StringBuffer();
			sb.append("<script>");
			sb.append("alert('회원 서비스입니다!');");
			sb.append("history.go(-1)();");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		}else {
		req.getRequestDispatcher("/WEB-INF/views/boardInsert.jsp").forward(req,resp);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardInsertServlet doPost");
		
		HttpSession session = req.getSession();
		UserVo vo = (UserVo)session.getAttribute("loginInfo");
		String id = vo.getId();
		logger.info("아이디가져옴"+id);
		String title = req.getParameter("title");
		logger.info("title가져옴"+title);
		String content = req.getParameter("content");
		AnswerBoardDto dto = new AnswerBoardDto(id, title, content);
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		logger.info("BoardModifyServlet doPost 전송받은 Parameter :"+dto);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc	= dao.insertBoard(dto);
		
		if(isc) {
			StringBuffer sb= new StringBuffer();
			sb.append("<script>");
			sb.append("alert('글 입력이 완료 되었습니다.!');");
			sb.append("location.href='./main.do'");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		}else {
			req.getRequestDispatcher("/WEB-INF/views/boardError.jsp").forward(req, resp);
		}
	}
}
