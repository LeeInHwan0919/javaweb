package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private IUserService service;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/signIn.do", method = RequestMethod.GET)
	public String signIn() {
		logger.info("Welcome 로그인 화면 이동 signIn");
		return "signIn";
	}

	@RequestMapping(value = "/signIn.do", method = RequestMethod.POST)
	public String signIn(UserVo vo, HttpSession session, HttpServletResponse response) throws IOException {
		logger.info("Welcome 로그인 처리 후 이동 signIn{}", vo);
		response.setContentType("text/html;charset=UTF-8;");

		List<UserVo> loginVo = service.signIn(vo);
		if (loginVo != null) {
			session.setAttribute("loginVo", loginVo);
			session.setMaxInactiveInterval(60 * 5);

			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인이 되었습니다.'); location.href='./allJobs.do';</script>");
			out.flush();
			return null;
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 정보가 없습니다'); location.href='./signIn.do';</script>");
			out.flush();
			return null;
		}
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletResponse response, HttpSession session) throws IOException {
		logger.info("Welcome 로그아웃 이동 logout");

		session.setMaxInactiveInterval(60 * 5);

		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.print("<script>alert('로그아웃이 되었습니다. 로그인 화면으로 이동합니다.'); location.href='./signIn.do';</script>");
		out.flush();
		return null;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		logger.info("Welcome 회원가입 화면 이동 signUp get");
		return "signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(UserVo vo, HttpServletResponse resp) throws IOException {
		logger.info("Welcome 회원가입 입력 signUp post: {}", vo);
		int cnt = service.signUp(vo);
		if (cnt == 1) {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>");
			sb.append("alert('회원가입이 완료되었습니다.');");
			sb.append("location.href='./signIn.do'");
			sb.append("</script>");
			return null;
		} else {
			resp.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = resp.getWriter();
			out.println(
					"<script>alert('회원가입에 실패하였습니다. \n 정규화 형식에 맞추어 작성해주세요.'); location.href='./signUp.do';</script>");
			return null;
		}
	}

}
