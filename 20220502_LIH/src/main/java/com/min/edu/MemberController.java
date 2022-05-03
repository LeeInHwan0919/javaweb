package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private IMemberService iService;
	
	@RequestMapping(value="/loginForm.do", method=RequestMethod.GET)
	public String loginForm() {
		logger.info("!!!!MemberController loginForm 페이지 넘김");
		return "loginForm";
	}
	@RequestMapping(value="/signUpForm.do", method = RequestMethod.GET)
	public String signUp() {
		logger.info("!!!!MemberController signUp 페이지 넘김");
		return "signUp";
	}
	@RequestMapping(value="/findIdForm.do", method = RequestMethod.GET)
	public String findID() {
		logger.info("!!!!MemberController findID 페이지 넘김");
		return "findID";
	}
	@RequestMapping(value="/findPwForm.do", method = RequestMethod.GET)
	public String findPW() {
		logger.info("!!!!MemberController findPW 페이지 넘김");
		return "findPW";
	}
	
	@RequestMapping(value="/login.do",method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, Model model){
		logger.info("!!!!MemberController login.do map의 값 {}",map);
		MemberVo mVo = iService.loginMember(map);
		model.addAttribute("member", mVo);
		logger.info("!!!cnt의 값 {}",mVo);
		if(mVo!=null) {
			return "redirect:/boardList.do";
		}else {
			return "redirect:/loginForm.do";
		}
	}
	
	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public void signUp(@RequestParam Map<String, Object> map, HttpServletResponse response) throws IOException {
		logger.info("!!!!MemberController signUp map의 값 {}",map);
		int cnt = iService.signUp(map);
		logger.info("!!!!MemberController signUp cnt의 값 {}",cnt);
		if(cnt>0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입에 성공하였습니다. 로그인 화면으로 이동합니다.'); location.href='./loginForm.do'</script>;");
			out.flush();
		}
	}
	
	@RequestMapping(value="/findID.do", method=RequestMethod.POST)
	public void findID(@RequestParam Map<String, Object> map, HttpServletResponse response) throws IOException {
		
		logger.info("!!!!MemberController signUp map의 값 {}",map);
		String id = iService.findID(map);
		logger.info("!!!!MemberController signUp cnt의 값 {}",id);
		if(id!=null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디는 "+id+"입니다. 로그인화면으로 이동합니다.'); location.href='./loginForm.do'</script>;");
			out.flush();
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이름과 이메일을 다시 확인해 주세요.'); location.href='./findIdForm.do'</script>;");
			out.flush();
		}
	}
	
}
