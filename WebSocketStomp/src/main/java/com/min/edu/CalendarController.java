package com.min.edu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.TestVo;

@Controller
public class CalendarController {

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@Autowired
	private IMemberService iService;

	@RequestMapping(value = "/websocket.do", method = RequestMethod.GET)
	public String list() {
		logger.info("CalendarController list");
		return "websocket";
	}
	
	@RequestMapping(value = "/makeSession.do", method = {RequestMethod.POST, RequestMethod.GET})
//	@ResponseBody
	public String makeSession(HttpSession session, String name) {
		if(name == null) {
			return "makeSession";
		}
		session.setAttribute("name", name);
		return "websocket";
	}
	
	@RequestMapping(value = "/comp.do", method = RequestMethod.GET)
	public String apprDisplay() {
		
		return "comp";
	}
	
	@RequestMapping(value = "/test.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8;")
	@ResponseBody
	public String test(HttpSession session, @RequestParam Map<String, Object> map) {
		logger.info("CalendarController test name : {}",map.get("name"));
//		session.setAttribute("name", map.get("name"));
		logger.info("CalendarController test name : {}",map.get("name"));
		return "성공";
	}
	
	

}
