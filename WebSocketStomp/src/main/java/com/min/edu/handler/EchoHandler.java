package com.min.edu.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class EchoHandler extends TextWebSocketHandler{

	private List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	private Map<String, WebSocketSession> map = new HashMap<String, WebSocketSession>();
	private String id;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	public EchoHandler() {
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		logger.info("session 정보 : {}", session);
		Map<String, Object> session2 = session.getAttributes();
		String name = (String) session2.get("name");
		logger.info("################## name {}",name);
		map.put(name, session);
		this.id = name;
		super.afterConnectionEstablished(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("session 삭제 : {}", session);
		list.remove(session);
		map.remove(id);
		super.afterConnectionClosed(session, status);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(" 들어옴");
		String msg = message.getPayload();
		
		String[] id = msg.split(",");
		System.out.println(Arrays.toString(id));
		String category = id[0];
		String balsin = id[1];
		String susin = id[2];
		
		WebSocketSession balsinSession = map.get(balsin);
		WebSocketSession susinSession = map.get(susin);
		System.out.println(balsinSession);
		System.out.println(susinSession);
		
		logger.info("메시지 세션 정보 list : {}", list);
		logger.info("메시지 세션 정보 map : {}", map);
		
		logger.info("###### 받은 메시지 : {}", msg);
		if(category.equals("결재")) {
				susinSession.sendMessage(new TextMessage(balsin+"님이 "+susin+"님에게 결재를 요청하였습니다"));
		}else {
			for (WebSocketSession s : list) {
				s.sendMessage(new TextMessage("전체 알림입니다."));
			}
		}
		super.handleTextMessage(session, message);
	}
}
