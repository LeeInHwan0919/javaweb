package com.min.edu;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JS_TestController {
	
	@RequestMapping(value = "/jsTest.do", method = RequestMethod.GET)
	public String goTest() {
		
		return "JS_test";
	}

	
	@RequestMapping(value = "/test.do", method = RequestMethod.POST, produces = "html/text; charset=utf-8")
	@ResponseBody
	public String test(@RequestParam String test) {
		System.out.println(test);
		return test;
	}
}
