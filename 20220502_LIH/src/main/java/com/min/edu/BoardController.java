package com.min.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private IBoardService iService;

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/loginForm.do";
	}

	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model, HttpSession session) {

		MemberVo mVo = (MemberVo) session.getAttribute("member");
		logger.info("Board_Controller 세션 확인 : {} ", mVo);

		logger.info("!!!!MemberController boardList 페이지 넘김");
		List<BoardVo> lists = null;
		RowNumVo rowVo = null;

		if (session.getAttribute("row") == null) {
			rowVo = new RowNumVo();
		} else {
			rowVo = (RowNumVo) session.getAttribute("row");
		}
		if (mVo.getAuth().equals("U")) {
			rowVo.setTotal(iService.userBoardListTotal());
			lists = iService.userBoardListRow(rowVo);
		} else if (mVo.getAuth().equals("A")) {
			rowVo.setTotal(iService.adminBoardListTotal());
			lists = iService.adminBoardListRow(rowVo);
		}
		model.addAttribute("lists", lists);
		model.addAttribute("row", rowVo);
		return "boardList";
	}

	@RequestMapping(value = "/multiDel.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String meltiDel(HttpServletRequest req, @RequestParam ArrayList<String> chk,
			@SessionAttribute("member") MemberVo mVo, HttpServletResponse response) throws IOException {

		logger.info("BoardController meltiDel : {}", chk);
		int n = 0;

		if (mVo.getAuth().equals("A")) {
			String[] seqs = chk.toArray(new String[chk.size()]);
			Map<String, String[]> map = new HashMap<String, String[]>();
			map.put("seqs", seqs);
			n = iService.MultipleDelete(map);
		}

		return (n > 0) ? "redirect:/boardList.do" : "redirect:/logout.do";
	}



	@RequestMapping(value = "/Delete.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String Delete(@RequestParam String seq, @SessionAttribute("member") MemberVo mVo,HttpServletRequest req, Model model) {
		logger.info("seq의 값은 {}", seq);
		int n = 0;
		BoardVo vo = iService.selectDetail(seq);
		if (vo.getId().equals(mVo.getId())) {
			n = iService.Delete(seq);
		}
		return (n > 0) ? "redirect:/boardList.do" : "redirect:/logout.do";
	}

	@RequestMapping(value = "/boardDetail.do", method = RequestMethod.POST)
	public String boardDetail(@RequestParam("seq") int seq, HttpSession session) {
		logger.info("!!!!MemberController boardDetail POST seq값 $$${}", seq);
		BoardVo vo = new BoardVo();
		vo.setSeq(seq);
		return "redirect:/boardDetail.do?=" + vo.getSeq();
	}

	@RequestMapping(value = "/boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(@RequestParam("seq") String seq, Model model) {
		logger.info("!!!!MemberController boardDetail GET seq값 {}", seq);
		BoardVo list = iService.selectDetail(seq);
		model.addAttribute("list", list);
		return "boardDetail";
	}

	@RequestMapping(value = "/reply.do", method = RequestMethod.GET)
	public String reply(HttpServletRequest req, Model model) {
		logger.info("!!!!MemberController reply 페이지이동");
		String seq = req.getParameter("seq");
		logger.info("seq의 값은 {}", seq);
		model.addAttribute("seq", seq);
		return "reply";
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.GET)
	public String updateBoard(HttpServletRequest req, Model model) {
		logger.info("!!!!MemberController updateBoard 페이지이동");
		String seq = req.getParameter("seq");
		logger.info("seq의 값은 {}", seq);
		model.addAttribute("seq", seq);
		return "updateBoard";
	}

	@RequestMapping(value = "/reply.do", method = RequestMethod.POST)
	public String reply(String seq, @RequestParam Map<String, Object> map, Model model, HttpSession session) {
		logger.info("!!!!MemberController reply POST seq값 $$${}", seq);
		logger.info("!!!!MemberController reply POST map값 $$${}", map);
		MemberVo mVo = (MemberVo) session.getAttribute("member");
		model.addAttribute("member", mVo);
		iService.reply(seq, map);
		System.out.println("#@!#@!reply성공");
		return "redirect:/boardList.do";
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(String seq, @RequestParam Map<String, Object> map) {
		logger.info("!!!!MemberController updateBoard POST seq값 $$${}", seq);
		logger.info("!!!!MemberController updateBoard POST map값 $$${}", map);
		iService.BoardUpdate(map);
		System.out.println("#@!#@!updateBoard성공");
		return "redirect:/boardList.do";

	}
}
