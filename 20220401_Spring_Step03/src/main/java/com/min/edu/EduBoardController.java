package com.min.edu;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.IEduBoardService;
import com.min.edu.vo.EduVo;

@Controller
public class EduBoardController {
  
  private static final Logger logger = LoggerFactory.getLogger(EduBoardController.class);
  
  @Autowired
  private IEduBoardService service;
  
  @RequestMapping(value="/selectBoard.do", method = RequestMethod.GET)
  public String selectBoard(Model model) {
	  logger.info("Welcome EduBoardController, @GET방식 selectBoard {}", new Date());
	  List<EduVo> lists = service.selectBoard();
	  model.addAttribute("lists", lists);
	  return "boardList";
  }
  
  
}
