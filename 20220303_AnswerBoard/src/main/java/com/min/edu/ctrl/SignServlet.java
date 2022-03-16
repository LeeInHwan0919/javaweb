package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class SignServlet extends HttpServlet {

	private static final long serialVersionUID = -1625198131526380821L;
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		String idPattern = "\\w{5,10}";
		String passwordPattern = "\\w{8,15}";

		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		List<UserVo> lists = dao.userInfoAll();
		logger.info(lists);
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		int cnt = 0;
		for(int i=0; i<lists.size(); i++) {
			if(lists.get(i).getId().equals(id)) {
				cnt++;
			}
		}

		if (cnt>0) {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>");
			sb.append("alert('중복된 아이디입니다.');");
			sb.append("history.go(-1)();");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		} else 
			if (!Pattern.matches(idPattern, id)) {
			StringBuffer sb3 = new StringBuffer();
			sb3.append("<script>");
			sb3.append("alert('회원가입 실패 아이디를 정확히 입력해 주세요');");
			sb3.append("history.go(-1)();");
			sb3.append("</script>");
			resp.getWriter().println(sb3.toString());
		} else if (!Pattern.matches(passwordPattern, password)) {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>");
			sb.append("alert('회원가입 실패 비밀번호를 정확히 입력해 주세요');");
			sb.append("history.go(-1)();");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		} else {
			logger.info("인서트 성공한 행의 갯수 : " + id + password + name);
			dao.signUpInsert(new UserVo(name, id, password));
			StringBuffer sb2 = new StringBuffer();
			sb2.append("<script>");
			sb2.append("alert('회원가입이 완료되었습니다.');");
			sb2.append("location.href='./boardLogin.do'");
			sb2.append("</script>");
			resp.getWriter().println(sb2.toString());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/signForm.jsp").forward(req, resp);
	}
}
