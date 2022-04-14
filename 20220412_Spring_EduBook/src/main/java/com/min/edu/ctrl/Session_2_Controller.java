package com.min.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class Session_2_Controller {

	private Logger logger = LoggerFactory.getLogger(Session_2_Controller.class);
	
	@GetMapping(value="/test03.do")
	public String test03(SessionStatus sessionStatus) {
		//@SessionAttribute를 삭제
		System.out.println("###########@SessionAttribute를 삭제#########");
		sessionStatus.setComplete();
		return "sessionCheck";
	}
	
	@GetMapping(value="/test04.do")
	public String test04(HttpSession session) {
		//HttpSession을 삭제
		System.out.println("########### HttpSession을 삭제 ########");
		session.invalidate();
		return "sessionCheck";
	}
	
	@GetMapping(value="/result03.do")
	public String result03(HttpSession session, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("HttpSession과 @SessionAttribute를 출력");
		System.out.println("--------------HttpSession--------------"+session.getAttribute("httpsessionTest"));
		System.out.println("--------------@SessionAttribute--------------"+sessionTest);
		return "sessionCheck";
	}
	
	@GetMapping(value="/result04.do")
	public String result04(HttpSession session) {
		logger.info("HttpSession를 출력");
		System.out.println("--------------HttpSession--------------"+session.getAttribute("httpsessionTest"));
		return "sessionCheck";
	}
}
