package com.min.edu.socket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component(value = "wsChat.do")
public class MySocketHandler extends TextWebSocketHandler {
   
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   
   private ArrayList<WebSocketSession> list; //웹소켓 세션을 담아주는 객체 ( 체팅 대상을담음)
   private Map<WebSocketSession, String> map = new HashMap<WebSocketSession, String>();//이름
   
   public MySocketHandler() {
      list = new ArrayList<WebSocketSession>();
   }

   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      logger.info("웹소켓 커넥션 생성 afterConnectionEstablished");
      super.afterConnectionEstablished(session);
      list.add(session);
      logger.info("웹소켓 커넥션이 생성되어 참여하고 있는 SessionID :{}",session.getId());
   }
   
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      logger.info("웹소켓 session 삭제 afterConnectionClosed");
      
      super.afterConnectionClosed(session, status);
      //채팅창이 닫기거나 웹소켓 에서 close()ㄹㄹ 했다면 
      //WebSocketSession을 삭제하여 데이터가 전송되지 않도록함 
      logger.info("웹소켓 session 삭제 ",session);
      list.remove(session);
      
      
      //화면에 메세지 보내주기
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
      String out = sdf.format(new Date());
      for (WebSocketSession s : list) {
         s.sendMessage(new TextMessage("<font sytle = 'color:tomato; size:5px;'>"+map.get(session)+"님이 방을 나갔습니다("+out+")</font>"));
      }
      logger.info("session 이름 삭제 :{}",map.get(session));
      map.remove(session);
      
   }
   
   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      logger.info("웹소켓 메세지 전달 :handleTextMessage");
      String msg = message.getPayload();
      String msgToString = message.toString();
      
      logger.info("전달 된 메시지 getPayload() :{}",msg);
      logger.info("전달 된 메시지 toString()  :{}",msgToString);
      
      if(msg!=null && !msg.equals("")) {
         if(msg.indexOf("#&nick_")!=-1) { //머릿말 "#&nick_"가 포함되어 있다면 , 참여하고 있는 모든 사람들에게 입장메세지를 보내준다 (Brodcasting) 
                                             // "#&nick_비둘기"=>비둘기 단어만 추출해서 WebSocketSession과 비둘기가 쌍으로 Map에 담아둬야함  
            map.put(session, msg.replace("#&nick_", ""));
            logger.info(session +"의 이름 :{}",map.get(session));
            
            
            
            for (WebSocketSession s : list) {
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
               String out = sdf.format(new Date());
               
               s.sendMessage(new TextMessage("<font sytle = 'color:green; size:5px;'>"+map.get(session)+"님이 입장하셨습니다("+out+")</font>"));
            }
            
            
         }else {//머릿말이 "#&nick_"가 없아면 채팅글이기 떄문에 모든 참여자에게 메세지를 보낸다 
            for (WebSocketSession s : list) {
               String m = "<font sytle = 'color:tomato; size:5px;'>"+msg+"</font>";
               s.sendMessage(new TextMessage(m));
               
            }
         }
      }
      
      super.handleTextMessage(session, message);
   }
   
   
   
   
   
   
   
   
   
   
   
}