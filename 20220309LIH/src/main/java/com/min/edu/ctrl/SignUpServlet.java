package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = -7682680445236387979L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/signUp.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("로그인 값 받기");
		String name = req.getParameter("userName");
		String id = req.getParameter("userId");
		String pw = req.getParameter("userPw");
		boolean name_check = Pattern.matches("^[가-힣]{2,5}$", name);
		boolean id_check = Pattern.matches("\\w{8,16}", id);
		boolean pw_check = Pattern.matches("\\w{8,16}", pw);
		logger.info("BoardModifyServlet doPost 전송받은 Parameter :"+name+"/"+id+"/"+pw);
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		List<UserVo> idCheckList = dao.allUserId();
		int chkCnt = 0;
		for(int i = 0; i < idCheckList.size(); i++ ) {
			if(idCheckList.get(i).getId().equals(id)) {
				chkCnt++;
			}
		}
		if(chkCnt > 0) {
			StringBuffer sbj= new StringBuffer();
			sbj.append("<script>");
			sbj.append("alert('아이디가 중복입니다');");
			sbj.append("history.go(-1)();");
			sbj.append("</script>");
			resp.getWriter().println(sbj.toString());
		}else if(name_check == false) {
			StringBuffer sb1= new StringBuffer();
			sb1.append("<script>");
			sb1.append("alert('올바른 이름을 입력하세요');");
			sb1.append("history.go(-1)();");
			sb1.append("</script>");
			resp.getWriter().println(sb1.toString());
			}else if(id_check == false) {
				StringBuffer sb2= new StringBuffer();
				sb2.append("<script>");
				sb2.append("alert('올바른 아이디를 입력하세요');");
				sb2.append("history.go(-1)();");
				sb2.append("</script>");
				resp.getWriter().println(sb2.toString());
			}else if(pw_check == false) {
				StringBuffer sb3= new StringBuffer();
				sb3.append("<script>");
				sb3.append("alert('올바른 비밀번호를 입력하세요');");
				sb3.append("history.go(-1)();");
				sb3.append("</script>");
				resp.getWriter().println(sb3.toString());
			}else {
				UserVo vo = new UserVo();
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				dao.signUp(vo);
				StringBuffer sb4= new StringBuffer();
				sb4.append("<script>");
				sb4.append("alert('회원가입 성공!');");
				sb4.append("location.href='./index.jsp'");
				sb4.append("</script>");
				resp.getWriter().println(sb4.toString());
				
				
			}
		
		
	}
	
}









