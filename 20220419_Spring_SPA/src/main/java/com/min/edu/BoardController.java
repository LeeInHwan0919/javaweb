package com.min.edu;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBoardService iService;
	
	//TODO 005 MemberController.java 64번째 줄(004)에서 Redirect 로 요청한 페이지
	//TODO 012 페이징 처리되는 BoardList
//	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
//	public String boardList(HttpSession session, @SessionAttribute("mem2") MemberVo mVo, Model model) {
//		logger.info("BoardController boardList");
//		logger.info("BoardController 세션 확인 {}", mVo);
//		
////		List<BoardVo> lists = iService.selectBoardAll(mVo);
////		model.addAttribute("lists", lists);
//		
//		List<BoardVo> lists = null;
//		RowNumVo rowVo = null;
//		
//		if(session.getAttribute("row") == null) {
//			// 처음 BoardList 를 요청했을 경우
//			rowVo = new RowNumVo();
//		}else {
//			// 두번째 요청부터는 Session 의 값을 사용
//			rowVo = (RowNumVo)session.getAttribute("row");
//		}
//		
//		// 각 사용자에 권한에 따라서 실행되는 Service 를 분기한다.
//		if(mVo.getAuth().equals("U")) {
//			//TODO 012 페이징 처리되는 BoardList User
//			rowVo.setTotal(iService.userBoardListTotal());
//			lists = iService.userBoardListRow(rowVo);
//		}else if(mVo.getAuth().equals("A")) {
//			//TODO 012 페이징 처리되는 BoardList Admin
//			rowVo.setTotal(iService.adminBoardListTotal());
//			lists = iService.adminBoardListRow(rowVo);
//		}
//		
//		model.addAttribute("lists", lists);
//		model.addAttribute("row", rowVo);
//		
//		return "boardList";
//	}
	
//	@RequestMapping(value="./multiDel.do",method=RequestMethod.POST)
//	public String multiDel(@RequestParam List<String> chk) {
//		logger.info("BoardController chk값 {}", chk.toArray().toString());
//		iService.deleteBoard(chk);
//		return "redirect:/boardList.do";
//	}
	
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(@RequestParam Map<String, Object> map, @SessionAttribute("mem2") MemberVo mVo,
			HttpServletResponse response, HttpSession session) throws IOException {
		map.put("id", mVo.getId());
		logger.info("BoardController write : {}",map);
		int n = iService.insertBoardRoot(map);
		if(n>0) {
			session.removeAttribute("row");
//			Utility.servlet_alert(response, "성공적으로 입력되었습니다.", "boardList.do");
			return "redirect:/boardList.do";
		}else {
//			Utility.servlet_alert(response, "처리가 잘 못 되 었 습니다.", "logout.do");
			return "redirect:/logout.do";
		}
		
	}
	
	

	
}
