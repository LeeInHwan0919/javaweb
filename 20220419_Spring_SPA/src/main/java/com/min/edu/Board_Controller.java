package com.min.edu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;

@Controller
public class Board_Controller {

	private Logger logger = LoggerFactory.getLogger(Board_Controller.class);
	
	@Autowired
	private IBoardService iService;
	
	//TODO 005 Member_Controller.java의 62번째 줄(004)에서 Redirect로 요청
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String boardList(@SessionAttribute("mem2") MemberVo mVo,Model model) {
		logger.info("Board_Controller boardList");
		logger.info("Board_Controller boardList 세션확인 :{}",mVo);

		List<BoardVo> lists = iService.selectBoardAll(mVo);
		model.addAttribute("lists",lists);
		
		return "boardList";
	}
	
}
