package com.min.edu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService service;
	
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("BoardController 전체조회 boardList");
		List<BoardVo> lists = service.userBoardList();
		model.addAttribute("lists",lists);
		return "boardList";
	}
}
