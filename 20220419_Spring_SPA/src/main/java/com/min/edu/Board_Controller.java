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
import org.springframework.web.bind.annotation.SessionAttribute;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@Controller
public class Board_Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBoardService iService;
	
	//controller 위에다가 root잡는 것 
	//TODO 005 Member_Controller.java의 66번째 줄(004)에서 Redirect로 요청한 페이지 

	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET) //redirect는 GET
	public String boardList(@SessionAttribute("mem2") MemberVo mVo, Model model, HttpSession session) {
		logger.info("Board_Controller boardList");
		logger.info("Board_Controller 세션 확인 : {}",  mVo);
		
//		List<BoardVo> lists =  iService.selectBoardAll(mVo);
//		model.addAttribute("lists", lists);
		
		List<BoardVo> lists = null;
		RowNumVo rowVo = null;
		
		if(session.getAttribute("row")==null) {
			//처음에 BoardList를 요청했을 경우
			rowVo = new RowNumVo();
			
		}else {
			//두번째 요청부터는 Session의 값을 사용
			rowVo =(RowNumVo) session.getAttribute("row");
		}
		
		//각 사용자에 따라서 실행되는 service를 분기
		if(mVo.getAuth().equals("U")) {
			//TODO 012 페이징 처리되는 BoardList User
			rowVo.setTotal(iService.userBoardListTotal());
			lists = iService.userBoardListRow(rowVo);
		
		}else if(mVo.getAuth().equals("A")) {
			//TODO 012 페이징 처리되는 BoardList Admin
		rowVo.setTotal(iService.adminBoardListTotal());
		lists = iService.adminBoardListRow(rowVo);
		}
		
		model.addAttribute("lists",lists);
		model.addAttribute("row",rowVo);
		
		return "boardList";
	}
	
	
}













