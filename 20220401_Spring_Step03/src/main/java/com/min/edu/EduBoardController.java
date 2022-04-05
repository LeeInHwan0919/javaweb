package com.min.edu;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.IEduBoardService;
import com.min.edu.vo.EduVo;

@Controller
public class EduBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(EduBoardController.class);
	
	@Autowired
	private IEduBoardService service;
	
	@RequestMapping(value = "/selectBoard.do",method = RequestMethod.GET)
	public String selectBoard(Model model) {
		logger.info("Welcome EduBoardController selectBoard{}", new Date());
		List<EduVo> lists = service.selectBoard();
		model.addAttribute("lists",lists);
		return "boardList";
	}
	
	@RequestMapping(value = "/insertBoardVO.do", method = RequestMethod.POST)
	public String insertBoard(EduVo vo) {
		logger.info("Welcome VO의 setter를 통해서 자동으로 Parameter 전송 : {}",vo);
		int n = service.insertBoard(vo);
		if(n>0) {
			return "redirect:/selectBoard.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value = "/insertBoardMap.do", method = RequestMethod.POST)
//	public String insertBoardMap(String id, String title, String content) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", id);
//		map.put("title", title);
//		map.put("content", content);
//		logger.info("Welcome String을 Map으로 입력하여 사용: {}",map);
	
	
	public String insertBoardMap(@RequestParam Map<String, String> paramMap) {
		logger.info("Welcome String을 paramMap으로 입력하여 사용: {}",paramMap);
		
		return "redierct:/selectBoard.do";
	}
	/*
	 * @RequestPara(value="화면name",defualtValue="null이면 입력")String 사용변수
	 * 입력받은 name이 없다면 defaultValue입력하여 변수를 생성해준다
	 * 
	 * 만약에 입력되는 변수가 Paging처리처럼 처음에는 값이 없다면 예외를 발생시킨다
	 * 따라서 반드시 defaultValue처리를 통해서 값을 초기화 해줘야 한다
	 * 
	 * ex) Content가 필수값이 아닌 경우
	 */
	@RequestMapping(value = "/insertBoardRequestParam.do", method = RequestMethod.POST)
	public String insertBoardRequestParam(
			@RequestParam("a")String id,
			@RequestParam("b")String title,
			@RequestParam("c")String content,
			@RequestParam(value="page",defaultValue="1")String paging
			) {
		logger.info("Welcome @RequestParam으로 값 처리 a {}",id);
		logger.info("Welcome @RequestParam으로 값 처리 b {}",title);
		logger.info("Welcome @RequestParam으로 값 처리 c {}",content);
		logger.info("Welcome @RequestParam으로 값 처리 d {}",paging);
		return "redirect:/selectBoard.do";
	}
	
	@RequestMapping(value = "/com/min/{login}/paramValue.do",method = RequestMethod.GET)
	public String pathVariable(@PathVariable("login")String path) {
		logger.info("Welcome @PathVariable을 통한 전송 : ");
		return path+"/main";
	}

}
