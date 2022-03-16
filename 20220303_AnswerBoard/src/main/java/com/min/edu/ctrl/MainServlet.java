package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = -5877269302886917396L;
	
	private Logger logger = Logger.getLogger(MainServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("MainServlet doGet");
		//요구사항에 따라 로그인된 ID로 글을 입력 할 수 있도록 해달라는 요청
		//가상으로 값을 담아서 게시판 구성하는 역할로 사용하겠다
//		HttpSession session =  req.getSession();
//		session.setAttribute("loginInfo", new UserVo("두꺼비","Q002","A"));
		
		//첫번째 흐름인 게시글의 모든 글 출력
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		List<AnswerBoardDto> lists =dao.selectAllBoard();
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/boardMain.jsp").forward(req, resp);
	}

}
