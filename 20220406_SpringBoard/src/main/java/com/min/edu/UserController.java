package com.min.edu;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private IUserService service;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("Welcome 로그인 화면 이동 loginForm");
		return "loginForm";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session, HttpServletResponse response)
			throws IOException {
		logger.info("Welcome 로그인 처리 후 이동 login");
		response.setContentType("text/html;charset=UTF-8;");

		UserVo loginVo = service.getLogin(map);
		if (loginVo != null) {
			session.setAttribute("loginVo", loginVo);
			session.setMaxInactiveInterval(60 * 5);

			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인이 되었습니다.'); location.href='./boardList.do';</script>");
			out.flush();
			return null;// 반드시 널이어야됨 화면처리가 먼저되어버리기때문
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 정보가 없습니다'); location.href='./loginForm.do';</script>");
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
		out.print("<script>alert('로그아웃이 되었습니다. 로그인 화면으로 이동합니다.'); location.href='./loginForm.do';</script>");
		out.flush();
		return null;
	}

	@RequestMapping(value="/signupForm",method=RequestMethod.GET)
	public String signupForm() {
		logger.info("Welcome 회원가입 화면 이동 signupForm");
		return "signupForm";
	}
	
	@RequestMapping(value="/signupForm", method = RequestMethod.POST)
	public String signupForm(UserVo vo, HttpServletResponse resp) throws IOException{
		logger.info("Welcome 회원가입 입력 : {}",vo);
		int cnt = service.signupMember(vo);
//		int cnt = 0;
		if(cnt == 1) {
			return "redirect:/loginForm.do";
		}else {
			resp.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('회원가입에 실패하였습니다.'); location.href='./loginForm.do';</script>");
			return null;
		}
	}
	
	@RequestMapping(value="/duplication.do", method=RequestMethod.GET)
	public String duplication() {
		logger.info("Welcome 아이디 중복 검사 화면");
		return "duplicate";
	}
	
	@RequestMapping(value="/duplicationAjax.do", method=RequestMethod.POST)
	@ResponseBody
	public String duplicationAjax(String checkId) {
		logger.info("Welcome 아이디 중복 체크 : {}",checkId);
		int cnt = service.isDuplicateCheck(checkId);
		return (cnt>0?"true":"false");
	}
	@RequestMapping(value="/findIdWindow.do", method=RequestMethod.GET)
	public String findIdWindow() {
		
		return "findId";
	}
	
	@RequestMapping(value="/findId.do", method=RequestMethod.POST)
	@ResponseBody
	public String findId(String name, String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("email", email);
		String id = service.findId(map);
		return (id==null)?"":id;
	}
	
	@RequestMapping(value="/managementUser.do", method=RequestMethod.GET)
	public String managementUser(Model model) {
		logger.info("전체 회원 조회");
		List<UserVo> listsVo = service.getAllUser();
		model.addAttribute("listsVo",listsVo);
		return "managementUser";
	}
	
	@RequestMapping(value="/managementUser.do", method=RequestMethod.POST)
	public String changeUser(String[] chksId, String btnChk)  {
		logger.info("회원 관리");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", chksId);
		
		if(btnChk.equals("toAuth")) {
			service.changeAuthToA(map);
			return "managementUser";
		}else if(btnChk.equals("toUser")) {
			service.changeAuthToU(map);
			return "managementUser";
		}else if(btnChk.equals("inactiveUser")) {
			service.changeAuthToY(map);
			return "managementUser";
		}else {
			service.changeAuthToN(map);
			return "managementUser";
		}
		
	}
}
