package com.min.edu;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@RestController
public class Page_Controller {
   
   private static final Logger logger = LoggerFactory.getLogger(Page_Controller.class);
   
   @Autowired
   private IBoardService iService;
   
   @RequestMapping(value = "/page.do",method = RequestMethod.POST,produces="application/text;charset=UTF-8;")
   public String page(HttpSession session,
//         @SessionAttribute("mem2") MemberVo mem,
//         @SessionAttribute("row") RowNumVo row,
         RowNumVo rowVo) {
      logger.info("Page_Controller \t 세션값 확인 mem2 : {}",session.getAttribute("mem2"));
      logger.info("Page_Controller \t 세션값 확인 row : {}",session.getAttribute("row"));
      logger.info("Page_Controller \t 요청값 확인 row : {}",rowVo);
      
      MemberVo mVo = (MemberVo)session.getAttribute("mem2");
      JSONObject json = null;
      
      if(mVo.getAuth().equalsIgnoreCase("U")) {//사용자
         rowVo.setTotal(iService.userBoardListTotal());
         json = jsonForm(iService.userBoardListRow(rowVo),rowVo,mVo); //현재 index의 글 start, last, 요청 row,사용자 정보
      }else {//관리자
         rowVo.setTotal(iService.adminBoardListTotal());
         json = jsonForm(iService.adminBoardListRow(rowVo),rowVo,mVo); //현재 index의 글 start, last, 요청 row,사용자 정보
      }
      
      session.removeAttribute("row");
      session.setAttribute("row", rowVo);
      
//      return null;
//      return "{\"test\":\"sunny\"}";
      
      logger.info(json.toJSONString());
      
      return json.toJSONString();
   }

   /*
    * 생성된 글 리스트(boardListRow)와 화면에서 요청된 페이징값(rowVo),세션의 정보(mVo) 
    * 반환을 map으로 생성하고 jackson-databind.jar을 사용하여 자동으로 JSON으로 처리
    * text -> javascript JSON처리
    * 1) dataType: "json"
    * 2) dataType: "json"
    *       var jObj = JSON.parse("값");
    */
   
//   @ResponseBody
   @SuppressWarnings("unchecked")
   private JSONObject jsonForm(List<BoardVo> boardListRow, RowNumVo rowVo, MemberVo mVo) {
      //최종 형태 {"lists":[{"id":"홍길동","title":"도술","content":"아수랍라발타"},{"id":"전우치","title":"마술","content":"부적"}],
//      "row":{"index":"1","pageNum":"1","listNum":"5"}}
      
      JSONObject json = new JSONObject();//전송(반환)객체
      
      JSONArray jList = new JSONArray(); //글을 담는 객체
      JSONObject jRow = new JSONObject();//페이지를 담는 객체
      
      for(BoardVo bVo : boardListRow) {
         JSONObject obj = new JSONObject();
         obj.put("seq", bVo.getSeq());
         obj.put("id", bVo.getId());
         obj.put("title", bVo.getTitle());
         obj.put("content", bVo.getContent());
         obj.put("readcount", bVo.getReadcount());
         obj.put("regdate", bVo.getRegdate());
         obj.put("delflag", bVo.getDelflag());
         obj.put("memid", mVo.getId());
         jList.add(obj);
      }
      
      logger.info("JSON으로 변경된 글 리스트: {}", jList.toString());
      
      //페이지
      jRow.put("pageList", rowVo.getPageList());
      jRow.put("index", rowVo.getIndex());
      jRow.put("pageNum", rowVo.getPageNum());
      jRow.put("listNum", rowVo.getListNum());
      jRow.put("total", rowVo.getTotal());
      jRow.put("count", rowVo.getCount());
      
      json.put("lists", jList);
      json.put("row", jRow);
      
      return json;
   }
   
   //================================================================
   
   
   
}