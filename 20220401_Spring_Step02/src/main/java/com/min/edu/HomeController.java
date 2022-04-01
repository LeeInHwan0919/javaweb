package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * 만약에 반환이 null인 경우 메소드명과 같은 값을 리턴합니다.
	 */
	@RequestMapping(value="/home.do" , method = RequestMethod.GET)
	public String home(String name, Model model) {
		logger.info("home메소드 실행 , 전달받은 param : "+name);
		model.addAttribute("name",name+"님 안녕하세요.");
		return "home";
	}
	
	@RequestMapping(value="/info.do", method = RequestMethod.POST)
	public String info(String name, int age, Model model) {
		logger.info("info 메서드 ,전달 받은 파라미터 : {} " , (name+age));
		model.addAttribute("infoname", name);
		model.addAttribute("infoage", age);
		return "info";
	}
}
