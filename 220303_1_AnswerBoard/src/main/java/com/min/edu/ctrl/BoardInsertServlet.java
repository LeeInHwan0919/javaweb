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

public class BoardInsertServlet extends HttpServlet{

	private static final long serialVersionUID = -5914456013961547459L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		logger.info("BoardInsertServlet doGet");
		HttpSession session = req.getSession();
		logger.info("은는이가"+session.getAttribute("loginInfo"));
		if(session.getAttribute("loginInfo")==null) { // 로그인이 안되어있다면
	         PrintWriter out= resp.getWriter();
	         StringBuffer sb = new StringBuffer();
	         sb.append("<script type=\"text/javascript\">");
	         sb.append("alert(\"로그인을 해주세요\");");
	         sb.append("location.href=\"./boardLogin.do?loc="+"boardInsert.do"+"\";");
	         sb.append("</script>");
	         out.print(sb.toString());
	         logger.info("script 실행" + sb.toString());
		}else { //로그인이 되어 있다면
			 req.getRequestDispatcher("/WEB-INF/views/boardInsert.jsp").forward(req, resp); 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardInsertServlet doPost");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");		
		String ir1 = req.getParameter("ir1");
		System.out.println(ir1);
		
//		String content = req.getParameter("content");
//		
		//정규화는 화면에서 DB는 저장만 java는 서버 사이드만
//		ir1 = content.replaceAll("(\r\n|\n\r)", "<br>");
//		content = content.replaceAll("(>)", "&gt;");
//		content = content.replaceAll("(<)", "&lt;");		
//		
		AnswerBoardDto dto = new AnswerBoardDto();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(ir1);
//		
		logger.info("BoardInsertServlet doPost 전송 받은 파라미터" + dto);
//		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		Boolean isc = dao.insertBoard(dto);
//		
		if(isc) {
//			resp.sendRedirect("./main.do");
			resp.sendRedirect("./boardDetail.do?seq="+dto.getSeq());
		}else {
			resp.sendRedirect("./logout.do");
		}
	}
}
