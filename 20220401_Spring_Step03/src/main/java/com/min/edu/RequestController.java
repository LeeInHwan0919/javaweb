package com.min.edu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class RequestController {
	
	@RequestMapping(value = "/logout.do",method = {RequestMethod.GET,RequestMethod.POST})
	public String requestCtrl() {
		return "ctrl";
	}
}
