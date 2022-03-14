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

import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1701687481306402544L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("BoardModifyServlet doPost");
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		logger.info("BoardModifyServlet doPost 전송받은 Parameter :"+seq+"/"+content);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		map.put("con", content);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc	= dao.modifyBoard(map);
		
	}

}
