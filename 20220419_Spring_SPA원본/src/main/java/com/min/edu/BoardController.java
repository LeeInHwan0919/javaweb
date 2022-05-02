package com.min.edu;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.spring.util.Utility;

@Controller
public class BoardController {
   private Logger logger = LoggerFactory.getLogger(this.getClass());
   
   @Autowired
   private IBoardService iService;
   
   //TODo 018 이동된 로그아웃
   @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/loginForm.do";
	}
   
   //TODO 005 Member_controller.java.의 62줄(004)에서 redirect로 요청
   
   @RequestMapping(value = "/boardList.do",method = RequestMethod.GET)
   public String boardList(HttpSession session ,/*@SessionAttribute("mem2") MemberVo mVo*/Model model) {
	  MemberVo mVo =(MemberVo) session.getAttribute("mem2");
      logger.info("Board_Controller boardList");
      logger.info("Board_Controller 세션 확인 : {} ",mVo);
      
//      List<BoardVo> lists = iService.selectBoardAll(mVo);
//      model.addAttribute("lists",lists);
      
      List<BoardVo> lists = null;
      RowNumVo rowVo = null;
      
      if(session.getAttribute("row") == null) {
         //처음에 BoardList를 요청했을 경우
         rowVo = new RowNumVo();
      }else {
         //두번째 요청부터는 Session의 값을 사용
         rowVo = (RowNumVo)session.getAttribute("row");
      }
      //각 사용자의 권한에 따라서 실행되는 SErvice를 분기
      if(mVo.getAuth().equals("U")) {
         //TODO 012페이징 BoardList User
         rowVo.setTotal(iService.userBoardListTotal());
         lists = iService.userBoardListRow(rowVo);
      }else if(mVo.getAuth().equals("A")){
         //TODO 012페이징 BoardList Admin
         rowVo.setTotal(iService.adminBoardListTotal());
         lists = iService.adminBoardListRow(rowVo);
      }
      model.addAttribute("lists", lists);
      model.addAttribute("row", rowVo);
      
      return "boardList";
   }
   
   //TODO 013 다중 삭제
      @RequestMapping(value="/multiDel.do", method= {RequestMethod.POST,RequestMethod.GET})
      public String meltiDel(@RequestParam ArrayList<String> chk, @SessionAttribute("mem2") MemberVo mVo,HttpServletResponse response) throws IOException {
         logger.info("BoardController meltiDel : {}",chk);
         int n = 0;
         
         if(mVo.getAuth().equals("A")) { //관리자 권한은 모두 삭제
           n = iService.deleteBoard(chk);
         }else {
           BoardVo vo =  iService.selectBoardDetail(chk.get(0));
           if(vo.getId().equals(mVo.getId())) {//사용자 중에서 자신의 글
              //List -> String[]
              System.out.println("==========="+vo.getId()==mVo.getId());
              String[] seqs = chk.toArray(new String[chk.size()]);
              Map<String, String[]> map = new HashMap<String, String[]>();
              map.put("seqs", seqs);
              n = iService.updateBoardDelflag(map); 
           }else {
              Utility.servlet_alert(response, "잘못 요청 아이디", "logout.do");
              return null;
           }
         }
         return (n>0)?"redirect:/boardList.do":"redirect:/logout.do";
//         return null;
      }
      
      //TODO 014 새글 입력
      @RequestMapping(value = "/write.do", method = RequestMethod.POST)
      public String write(@RequestParam Map<String,Object> map,@SessionAttribute("mem2") MemberVo mVo,HttpServletResponse response,HttpSession session) throws IOException {
         map.put("id", mVo.getId());
         logger.info("Board_Controller write : {}",map);
         int n = iService.insertBoardRoot(map);
         if(n>0) {
            session.removeAttribute("row");
            Utility.servlet_alert(response, "성공적으로 입력되었습니다", "boardList.do");
         }else {
            Utility.servlet_alert(response, "처리가 실패하였습니다", "logout.do");
         }
         
         
         return null;
      }
      
      //TODO 015  글 수정을 위한 ajax값 구현
      @SuppressWarnings("unchecked")
      @RequestMapping(value = "/modifyForm.do",method = RequestMethod.POST,produces = "application/text;charset=UTF-8;")
      @ResponseBody
      public String modifyForm(String seq, @SessionAttribute("mem2") MemberVo mVo) {
         logger.info("Board_Controller modifyForm : {}",seq);
         BoardVo vo = iService.selectBoardDetail(seq);
         JSONObject json = new JSONObject();
         //문자열 객체 - Date 타입의 객체로 변경
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
         System.out.println(json.toString());
         return json.toString();
      }
      
      
      
      //TODO 016 글수정 값을 DB에 저장 
      @RequestMapping(value = "/modify.do",method = RequestMethod.POST)
      @ResponseBody
      public Map<String, String> modify(@RequestParam Map<String,Object> map){
         logger.info("Board_Controller modify : {}",map);
         Map<String, String> rMap = new HashMap<String, String>();
         int n = iService.updateBoardDetail(map);
         rMap.put("isc", (n==1)?"true":"false");
         return rMap;
      }
      
      
      
      
      //TODO 017 답글 모달에 부모글 값을 전달/replyForm.do
      @RequestMapping(value = "/replyForm.do",method = RequestMethod.POST)
      @ResponseBody
      public Map<String, Object> replyForm(String seq, @SessionAttribute("mem2") MemberVo mVo){
    	  logger.info("Board_Controller replyForm : {}",seq);
    	  Map<String, Object> map = new HashMap<String, Object>();
    	  BoardVo vo =  iService.selectBoardDetail(seq);
    	  
    	  map.put("obj", vo);
    	  map.put("sessionId", mVo.getId());
    	  
    	  
    	  return map;
      }
      
    
      @RequestMapping(value = "/reply.do", method = RequestMethod.POST)
      @ResponseBody
      public Map<String, String> reply(@RequestParam Map<String, Object> map, @SessionAttribute ("mem2") MemberVo mVo){
          logger.info("Board_Controller reply : {}", map);
         Map<String, String> rMap = new HashMap<String, String>();
         map.put("id", mVo.getId());
         
         int n = iService.boardAnswer(map);
         rMap.put("isc", (n>0)?"true":"false");
         
         return rMap;
      }
      
      
      
      
      
      
      
   
}