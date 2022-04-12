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
import com.min.edu.vo.JobsVO;

@Controller
public class JobsController {
	
	private static final Logger logger = LoggerFactory.getLogger(JobsController.class);
	@Autowired
	private IJobsService service;
	
	@RequestMapping(value = "/allJob.do", method = RequestMethod.GET)
	public String selectAllJob(Model model) {
		List<JobsVO> lists = service.selectJobAll();
		model.addAttribute("lists", lists);
		return null;
	}
	
	@RequestMapping(value = "/insertJob.do", method = RequestMethod.GET)
	public String insertJob() {
		return null;
	}
	
	@RequestMapping(value = "/insertJob.do", method = RequestMethod.POST)
	public String inserJob(JobsVO vo) {
		int i = service.insertJob(vo);
		if(i > 0) {
			logger.info("inserJob 성공");
		}else {
			logger.info("inserJob 실패");
		}
		return "redirect:/allJob.do";
	}
}
