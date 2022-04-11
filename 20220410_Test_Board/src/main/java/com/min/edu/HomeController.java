package com.min.edu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.service.IJobsService;
import com.min.edu.vo.JobsVo;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * 만약 반환이 null인 경우 메소드 명과 같은 값을 리턴한다 
	 */
	@RequestMapping(value = "/home.do",method = RequestMethod.GET)
	public String home(String name, Model model) {
		logger.info("home name:{}",name);
		model.addAttribute("name",name+"님 안녕하세요");
		return "home";
	}
	
//	@RequestMapping(value = "/info.do",method = RequestMethod.POST)
//	public String info(String name,int age,Model model) {
//		logger.info("info전달받은 파라미터 :{}",name+age);
//		model.addAttribute("info",name+age);
//		return "info";
//		
//	}
	
	@Autowired
	private IJobsService service;

	@RequestMapping(value = "/allJobs.do", method = RequestMethod.GET)
	public String jobSelect(Model model) {
	List<JobsVo> lists = service.jobSelect();
	model.addAttribute("lists", lists);
	return "allJobs";
	}
	



	
}
