package com.min.edu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService service;
	
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model, BoardVo vo) {
		logger.info("BoardController 전체조회 boardList");
		List<BoardVo> lists = service.userBoardList();
		model.addAttribute("lists",lists);
		
		for (BoardVo bvo : lists) {
			String content = bvo.getContent();
			content = content.replaceAll("<", "&lt;");
			content = content.replaceAll(">", "&gt;");
			bvo.setContent(content);
		}
		
		return "boardList";
	}
	
	@RequestMapping(value="/multiDel.do",method = {RequestMethod.POST,RequestMethod.GET})
	public String multiDel(String[] chkVal) {
		logger.info("BoardController 다중글 삭제 multiDel : {}",Arrays.toString(chkVal));
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", chkVal);
		int n = service.delflagBoard(map);
		logger.info("다중글 삭제 multiDel 삭제 갯수 : {}",n);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value="/detailBoard.do", method = RequestMethod.GET)
	public String detailBoard(@RequestParam("seq") String id, Model model) {
		logger.info("BoardController 글상세 보기 detailBoard : {}",id);
		BoardVo vo = service.getOneBoard(id);
		model.addAttribute("vo",vo);
		return "detailBoard";
	}
	
	
	
	@RequestMapping(value="/replyBoard.do", method = RequestMethod.GET)
	public String replyBoard(HttpServletRequest req, Model model) {
		logger.info("BoardController 답글 입력 폼 replyBoard");
		String seq = req.getParameter("chkVal");
		model.addAttribute("seq", seq);
		
		return "replyBoard";
	}
	
	@RequestMapping(value="/replyBoard.do", method = RequestMethod.POST)
	public String replyBoard(HttpServletRequest req ,String seq, BoardVo vo) {
		System.out.println("seq의 값은? : {}"+seq);
		int n = service.replyInsert(vo, seq);
		if(n!=0) {
			System.out.println("성공");
			return "redirect:/boardList.do";
		}else {
			System.out.println("실패");
			return "redirect:/replyBoard.do?chkVal="+vo.getSeq();
		}
	}
	
	
}
