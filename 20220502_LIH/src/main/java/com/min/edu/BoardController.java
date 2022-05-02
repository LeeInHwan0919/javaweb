package com.min.edu;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService iService;
	
	@RequestMapping(value="/boardList.do",method=RequestMethod.GET)
	public String boardList(Model model, HttpSession session) {
		
		MemberVo mVo =(MemberVo) session.getAttribute("member");
		logger.info("Board_Controller 세션 확인 : {} ",mVo);
		
		logger.info("!!!!MemberController boardList 페이지 넘김");
		List<BoardVo> lists = iService.selectAllBoard();
		model.addAttribute("lists",lists);
		return "boardList";
	}
}
