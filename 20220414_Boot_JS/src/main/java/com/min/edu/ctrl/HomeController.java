package com.min.edu.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.service.IJobsService;

@Controller
public class HomeController {
	
	@Autowired
	IJobsService service;

	@RequestMapping(value = "/")
	@ResponseBody
	public String home() {
		
		return service.selectTest();
	}
}
