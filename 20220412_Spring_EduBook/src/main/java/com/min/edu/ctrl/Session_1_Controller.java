package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("sessionTest")
public class Session_1_Controller {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/init.do")
	public String init(Model model, HttpSession session) {
		logger.info("Session_1_Controller 세션 + @세션 값 입력");
		model.addAttribute("sessionTest","init.do에서 추가된 @SessionAttribute");
		session.setAttribute("httpsessionTest", "init.do에서 추가된 @HttpSession");
		
		return "sessionCheck";
	}
	

	@GetMapping(value = "/test01.do")
	public String test01(SessionStatus sessionStatus) {
		//@SessionAttribute 삭제
		System.out.println("############# @SessionAttribute 를 삭제 #############");
		sessionStatus.setComplete();
		return "sessionCheck";
	}
	
	
	@GetMapping(value = "/test02.do")
	public String test02(HttpSession session) {
		//Httpsession 삭제
		System.out.println("############# HttpSession 를 삭제 #############");
		session.invalidate();
		return "sessionCheck";
	}
	
	@GetMapping(value = "/result01.do")
	public String result01(HttpSession session, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("HttpSession과 @SessionAttribute를 출력");
		System.out.println("------------- HttpSession -------------"+session.getAttribute("httpsessionTest"));
		System.out.println("------------- @SessionAttribute -------------"+sessionTest);
		return "sessionCheck";
	}
	
	@GetMapping(value = "/result02.do")
	public String result02(HttpSession session) {
		logger.info("HttpSession을 출력");
		System.out.println("------------- HttpSession -------------"+session.getAttribute("httpsessionTest"));
		return "sessionCheck";
	}
}
