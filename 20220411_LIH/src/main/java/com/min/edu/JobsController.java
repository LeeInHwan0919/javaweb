package com.min.edu;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class JobsController {

	@Autowired
	private IJobsService service;
	
	private Logger logger = LoggerFactory.getLogger(JobsController.class);
	
	@RequestMapping(value="/allJobs.do" , method = RequestMethod.GET)
	public String allJobs(Model model, HttpServletRequest req) {
		
		logger.info("JobsController allJobs 이동");
		List<JobsVo> lists = service.JobsAllSelect();
		model.addAttribute("lists",lists);
//		String url = req.getRequestURI();
//		String qs = req.getQueryString();
//		System.out.println("URL : "+url+", QueryString : " + qs);
		return "allJobs";
	}
	
	@RequestMapping(value="/JobsInsert.do" , method = RequestMethod.GET)
	public String JobsInsert() {
		logger.info("JobsController JobsInsert GET페이지 이동");
		return "JobsInsert";
	}
	
	@RequestMapping(value="/JobsInsert.do" , method = RequestMethod.POST)
	public String JobsInsert(JobsVo vo) {
		logger.info("JobsController JobsInsert POST등록하기");
		int cnt = service.JobsInsert(vo);
		if(cnt==1) {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>alert('입력이 완료 되었습니다.');</script>");
			return "redirect:/allJobs.do";
		}else {
			StringBuffer sb = new StringBuffer();
			sb.append("<script>alert('입력이 되지 않았습니다.');</script>");
			return "redirect:/JobsInsert.do";
		}
	}
	
	@RequestMapping(value="/jobsDetail.do",method=RequestMethod.GET)
	public String jobsDetail() {
		return "jobsDetail";
	}
	
	
	
}
