package com.min.edu.socket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component(value = "wsChatGr.do")
public class MySocketHandlerGr extends TextWebSocketHandler{
	
	private final Logger logger = LoggerFactory.getLogger(MySocketHandlerGr.class);
	
	private ArrayList<WebSocketSession> list; //WebSocket Session을 담는 객체
	
	public MySocketHandlerGr() {
		list = new ArrayList<WebSocketSession>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("afterConnectionEstablished() 실행 {}", session);
		super.afterConnectionEstablished(session);
		
		list.add(session); //전체 접속자 리스트에 새로운 접속자 추가
		System.out.println("Client session cnt : "+list.size());
		System.out.println("Session connected : "+session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("handleTextMessage() 실행");
		String msg = message.getPayload();
		String txt = "";
		
		Map<String, Object> mySession = session.getAttributes(); //WebSocketSession의 값을 HttpSession값으로 변경
		String myGrSession = (String)mySession.get("gr_id"); //접속 그룹 아이디
		String myMemSession = (String)mySession.get("mem_id"); //접속자 아이디
		
		if(msg!=null && !msg.equals("")) {
			if(msg.indexOf("#$nick_")>-1) {
				for (WebSocketSession s : list) {
					Map<String, Object> sessionMap = s.getAttributes();
					String otherGrSession = (String)sessionMap.get("gr_id");
					String otherMemSession = (String)sessionMap.get("mem_id");
					
					System.out.println("그룹아이디 : "+myGrSession);
					System.out.println("멤버아이디 : "+otherMemSession);
					
					if(myGrSession.equals(otherGrSession)) { //같은 그룹
						s.sendMessage(new TextMessage("<font color='pink', size='5px'>"+myMemSession+"님이 입장했습니다. </font>"));
					}
					
				}
			}else {
				String msg2 = msg.substring(0,msg.indexOf(":")).trim();
				for (WebSocketSession s : list) {
					Map<String, Object> sessionMap = s.getAttributes();
					String otherGrSession = (String)sessionMap.get("gr_id");
					String otherMemSession = (String)sessionMap.get("mem_id");
					if(myGrSession.equals(otherGrSession)) { //같은 그룹
							if(msg2.equals(otherMemSession)) {
								String newMsg = "[나]"+msg.replace(msg.substring(0, msg.trim().indexOf(":")+1),"");
								System.out.println("newMsg"+ newMsg);
								txt=newMsg;
							}else {
								String part1 = msg.substring(0, msg.trim().indexOf(":")).trim();
								String part2 = "["+part1+"]\n"+msg.substring(msg.trim().indexOf(":")+1);
								txt = part2;
							}
						s.sendMessage(new TextMessage(txt));
					}
				}
			}
		}
		super.handleTextMessage(session, message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("afterConnectionClosed() 실행 {}");
		super.afterConnectionClosed(session, status);
		
		Map<String, Object> mySession = session.getAttributes();
		String myGrSession = (String)mySession.get("gr_id");
		String myMemSession = (String)mySession.get("mem_id");
		
		System.out.println("세션 삭제 확인 전 : "+list.contains(session));
		System.out.println("세션 삭제 확인 전 : "+myGrSession);
		System.out.println("세션 삭제 확인 전 : "+myMemSession);
		
		list.remove(session);
		System.out.println("세션 삭제 확인 전 : "+list.contains(session));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH 24시 mm분");
		String now = sdf.format(new Date());
		
		for (WebSocketSession s : list) {
			Map<String, Object> sessionMap = s.getAttributes();
			String otherGrSession = (String)sessionMap.get("gr_id");
			
			if(myGrSession.equals(otherGrSession)) {
				s.sendMessage(new TextMessage("<font color='blue' size='2px'>"+myMemSession+"님이 퇴장하였습니다("+now+")</font>"));
			}
		}
		
	}
}


