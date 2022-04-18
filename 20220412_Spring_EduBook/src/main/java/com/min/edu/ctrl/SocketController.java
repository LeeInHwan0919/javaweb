package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletConfigAware;

@Controller
public class SocketController implements ServletConfigAware {
	
	private ServletContext servletContext;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		servletContext = servletConfig.getServletContext();
	}
	@RequestMapping(value = "socketOpen.do", method = RequestMethod.GET)
	public String socketOpen() {
		return "socket";
		
	}
	
	//---------------그룹채팅----------------//
	@RequestMapping(value = "/groupChat.do",method = RequestMethod.GET)
	public String groupChat() {
		logger.info("그룹 채팅 이동");
		return "groupChat";
	}
	
	//WebSocket 채팅 접속 했을 때
	@RequestMapping(value = "/socketOpenGr.do",method = RequestMethod.GET)
	public String socketOpenGr(HttpSession session, String mem_id, String gr_id, Model model) {
		logger.info("socketOpenGr 소켓화면 이동 1) 리스트에 접속자 넣기");
		
		session.setAttribute("mem_id", mem_id);
		session.setAttribute("gr_id", gr_id);
		
		HashMap<String, String> chatList = (HashMap<String, String>)servletContext.getAttribute("chatList");
		if(chatList==null) {
			chatList = new HashMap<String, String>();
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList); //로그인 되는 객체마다 map에 담기고 session에 담긴다.
		}else {
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList); //map의 특징 마지막의 값을 인정? 
			
		}
		logger.info("socketOpenGr 소켓화면 이동 2) 리스트값 전달");
		return "groupChatView";
	}
	
	//WebSocket 채팅이 종료됐을때 
	@RequestMapping(value = "/socketOut.do",method = {RequestMethod.GET,RequestMethod.POST})
	public void socketOut(HttpSession session) {
		logger.info("socketOut 소켓에서 나오기");
		String mem_id = (String)session.getAttribute("mem_id");
		HashMap<String, String> chatList = (HashMap<String, String>)servletContext.getAttribute("chatList");
		
		System.out.println("기존 접속 회원 리스트 : "+chatList);
		
		if(chatList!=null) {
			chatList.remove(mem_id);
		}
		
		System.out.println("갱신 후 접속 회원 리스트 : "+chatList);
		servletContext.setAttribute("chatList", chatList);
	}


}
