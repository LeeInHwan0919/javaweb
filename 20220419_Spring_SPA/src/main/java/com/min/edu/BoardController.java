package com.min.edu;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IBoardService iService;
	
	//TODO 018 로그아웃 이동
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/loginForm.do";
	}

	// TODO 005 MemberController.java 64번째 줄(004)에서 Redirect 로 요청한 페이지
	// TODO 012 페이징 처리되는 BoardList
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(HttpSession session, /* @SessionAttribute("mem2") MemberVo mVo, */ Model model) {
		MemberVo mVo = (MemberVo)session.getAttribute("mem2");
		logger.info("BoardController boardList");
		logger.info("BoardController 세션 확인 {}", mVo);

//		List<BoardVo> lists = iService.selectBoardAll(mVo);
//		model.addAttribute("lists", lists);

		List<BoardVo> lists = null;
		RowNumVo rowVo = null;

		if (session.getAttribute("row") == null) {
			// 처음 BoardList 를 요청했을 경우
			rowVo = new RowNumVo();
		} else {
			// 두번째 요청부터는 Session 의 값을 사용
			rowVo = (RowNumVo) session.getAttribute("row");
		}

		// 각 사용자에 권한에 따라서 실행되는 Service 를 분기한다.
		if (mVo.getAuth().equals("U")) {
			// TODO 012 페이징 처리되는 BoardList User
			rowVo.setTotal(iService.userBoardListTotal());
			lists = iService.userBoardListRow(rowVo);
		} else if (mVo.getAuth().equals("A")) {
			// TODO 012 페이징 처리되는 BoardList Admin
			rowVo.setTotal(iService.adminBoardListTotal());
			lists = iService.adminBoardListRow(rowVo);
		}

		model.addAttribute("lists", lists);
		model.addAttribute("row", rowVo);

		return "boardList";
	}

	

	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String write(@RequestParam Map<String, Object> map, @SessionAttribute("mem2") MemberVo mVo,
			HttpServletResponse response, HttpSession session) throws IOException {
		map.put("id", mVo.getId());
		logger.info("BoardController write : {}", map);
		int n = iService.insertBoardRoot(map);
		if (n > 0) {
			session.removeAttribute("row");
//			Utility.servlet_alert(response, "성공적으로 입력되었습니다.", "boardList.do");
			return "redirect:/boardList.do";
		} else {
//			Utility.servlet_alert(response, "처리가 잘 못 되 었 습니다.", "logout.do");
			return "redirect:/logout.do";
		}

	}


	
   //TODO 015 글 수정을 위한 값 ajax 구현
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/modifyForm.do", method=RequestMethod.POST,produces = "application/text;charset=UTF-8;")
	@ResponseBody
	public String modifyForm(String seq, @SessionAttribute("mem2") MemberVo mVo) {
		logger.info("BoardController modifyForm seq값 : {}", seq);
		BoardVo vo = iService.selectBoardDetail(seq);
		JSONObject json = new JSONObject();
		
		//문자열의 객체를 Date 타입 객체로 변경
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(vo.getRegdate(),fomatter);
		System.out.println(date.toLocalDate());
		
		
		if(mVo.getId().equals(vo.getId())) {
			json.put("isc", "true");
			json.put("id", vo.getId());
			json.put("seq", vo.getSeq()+"");
			json.put("title", vo.getTitle());
			json.put("content", vo.getContent());
			json.put("regdate", date.toLocalDate().toString());
		}else {
			json.put("isc", "false");
		}
			return json.toString();
			//toString과 toJSONString은 같다.
	}
	
	//TODO 016 글 수정 값을 DB에 저장
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> modify(@RequestParam Map<String, Object> map){
		Map<String, String> rMap = new HashMap<String, String>();
		int n = iService.updateBoardDetail(map);
		rMap.put("isc", (n==1)?"true":"false");
		return rMap;
	}//수정 모달
	
	
	//==========답글 모달============
	//TODO 017 답글 모달에 부모글 값을 전달
		@RequestMapping(value="/replyForm.do", method=RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> replyForm(String seq, @SessionAttribute("mem2") MemberVo mVo) {
			logger.info("BoardController replyForm seq값 : {}", seq);
			Map<String, Object> map = new HashMap<String, Object>();
			BoardVo vo = iService.selectBoardDetail(seq);
			
			map.put("obj", vo);
			map.put("sessionId", mVo.getId());
			
				return map;
				//toString과 toJSONString은 같다.
		}
		
		@RequestMapping(value="/reply.do", method=RequestMethod.POST)
		@ResponseBody
		public Map<String, String> reply(@RequestParam Map<String, Object> map, @SessionAttribute("mem2") MemberVo mVo){
			Map<String, String> rMap = new HashMap<String, String>();
   		    map.put("id", mVo.getId());
   		    int n = iService.boardAnswer(map);
   		    rMap.put("isc", (n>0)?"true":"false");
			logger.info("RMAP"+rMap);
			return rMap;
		}
	
	
}
