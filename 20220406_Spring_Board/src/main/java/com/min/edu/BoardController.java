package com.min.edu;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService service;
	
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("BoardController 전체조회 boardList");
		List<BoardVo> lists =service.userBoardList();
		for (BoardVo vo : lists) {
			String content = vo.getContent();
			content = content.replaceAll("<", "&lt;"); 
			content = content.replaceAll(">", "&gt;");
			vo.setContent(content);
		}
		model.addAttribute("lists", lists);
		return "boardList";
	}
	
	
	@RequestMapping(value = "/multiDel.do" , method = {RequestMethod.POST,RequestMethod.GET})
	public String multiDel(String[] chkVal) {
		logger.info("BoardController 다중글삭제 multiDel : {}", Arrays.toString(chkVal));
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", chkVal);
		int n = service.deflagBoard(map);
		logger.info("다중글삭제 multiDel 삭제 갯수 : {}",n);
		return "redirect:/boardList.do";
	}
	
	
	@RequestMapping(value = "/detailBoard.do", method = RequestMethod.GET)
	public String detailBoard(@RequestParam("seq") String id, Model model) {
		logger.info("BoardController 글상세 detailBoard : {}", id);
		BoardVo vo = service.getOneBoard(id);
		model.addAttribute("vo", vo);
		return "detailBoard";
	}
	
	@RequestMapping(value="/replyInsert.do", method = RequestMethod.GET)
	public String replyInsert() {
		logger.info("BoardController 답글 입력 폼 이동");
		return "replyInsert";
	}
	@RequestMapping(value="/replyInsert.do", method = RequestMethod.POST)
	public String replyInsert(BoardVo vo, HttpSession session) { // 화면의 값이 seq는 부모의 seq담겨 있고 , 화면에서 입력된 값 title content
		logger.info("BoardController 답글 입력 입력 처리 {}", vo);
 		UserVo loginVo =  (UserVo)session.getAttribute("loginVo");
 		vo.setId(loginVo.getId());
 		
  		int n = service.replyInsert(vo);
 		
		if(n!=0) {
			return "redirect:/boardList.do";
		}else {
			return "redirect:/replyInsert.do?chkVal="+vo.getSeq();
		}
	}
	
	@RequestMapping(value="/restoreBoard.do", method = RequestMethod.GET)
	public String restoreBoard(Model model) {
		List<BoardVo> lists = service.restoreBoard();
		model.addAttribute("lists",lists);
		return "boardDelList";
	}
	
	@RequestMapping(value ="/restoreDetailBoard.do", method = RequestMethod.GET)
	public String restoreDetailBoard(@RequestParam("seq") String id, Model model) {
		BoardVo vo = service.getOneBoard(id);
		model.addAttribute("vo", vo);
		return "restoreDetailBoard";
	}
	
	@RequestMapping(value="/restoreDelflag.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String restoreDelflag(String chkVal) {
		service.restoreDelflag(chkVal);
		return "redirect:/restoreBoard.do";
	}

	
}






