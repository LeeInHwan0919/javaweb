package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 7517861360834801966L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("로그인 값 받기");
		String id = req.getParameter("userId");
		String pw = req.getParameter("userPw");
		logger.info("BoardModifyServlet doPost 전송받은 Parameter :"+id+"/"+pw);
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		UserVo vo = dao.checkUser(map);
		System.out.println(vo);
		
		if(vo == null) {
			StringBuffer sb= new StringBuffer();
			sb.append("<script>");
			sb.append("alert('로그인 실패');");
			sb.append("history.go(-1)();");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		}else {
			System.out.println("else실행");
			HttpSession session =  req.getSession();
			session.setAttribute("loginInfo", vo);
			StringBuffer sb2= new StringBuffer();
			sb2.append("<script>");
			sb2.append("alert('환영합니다');");
			sb2.append("location.href='./main.do'");
			sb2.append("</script>");
			resp.getWriter().println(sb2.toString());
			
		}
	}

}
