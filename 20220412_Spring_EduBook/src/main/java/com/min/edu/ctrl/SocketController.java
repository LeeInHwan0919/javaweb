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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	//---------------洹몃９梨꾪똿----------------//
	@RequestMapping(value = "/groupChat.do",method = RequestMethod.GET)
	public String groupChat() {
		logger.info("洹몃９ 梨꾪똿 �씠�룞");
		return "groupChat";
	}
	
	//WebSocket 梨꾪똿 �젒�냽 �뻽�쓣 �븣
	@RequestMapping(value = "/socketOpenGr.do",method = RequestMethod.GET)
	public String socketOpenGr(HttpSession session, String mem_id, String gr_id, Model model) {
		logger.info("socketOpenGr �냼耳볧솕硫� �씠�룞 1) 由ъ뒪�듃�뿉 �젒�냽�옄 �꽔湲�");
		
		session.setAttribute("mem_id", mem_id);
		session.setAttribute("gr_id", gr_id);
		
		HashMap<String, String> chatList = (HashMap<String, String>)servletContext.getAttribute("chatList");
		if(chatList==null) {
			chatList = new HashMap<String, String>();
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList); //濡쒓렇�씤 �릺�뒗 媛앹껜留덈떎 map�뿉 �떞湲곌퀬 session�뿉 �떞湲대떎.
		}else {
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList); //map�쓽 �듅吏� 留덉�留됱쓽 媛믪쓣 �씤�젙? 
			
		}
		logger.info("socketOpenGr �냼耳볧솕硫� �씠�룞 2) 由ъ뒪�듃媛� �쟾�떖");
		return "groupChatView";
	}
	
	//WebSocket 梨꾪똿�씠 醫낅즺�릱�쓣�븣 
	@RequestMapping(value = "/socketOut.do",method = {RequestMethod.GET,RequestMethod.POST})
	public void socketOut(HttpSession session) {
		logger.info("socketOut �냼耳볦뿉�꽌 �굹�삤湲�");
		String mem_id = (String)session.getAttribute("mem_id");
		HashMap<String, String> chatList = (HashMap<String, String>)servletContext.getAttribute("chatList");
		
		System.out.println("湲곗〈 �젒�냽 �쉶�썝 由ъ뒪�듃 : "+chatList);
		
		if(chatList!=null) {
			chatList.remove(mem_id);
		}
		
		System.out.println("媛깆떊 �썑 �젒�냽 �쉶�썝 由ъ뒪�듃 : "+chatList);
		servletContext.setAttribute("chatList", chatList);
	}
	
	   @RequestMapping(value = "/viewChatList.do",method = RequestMethod.POST)
	   @ResponseBody
	   public Map<String, Map<String, String>>viewChatList(){
	      Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
	      HashMap<String, String>chatList= (HashMap<String, String>)servletContext.getAttribute("chatList");
	      map.put("list", chatList);
	      return map;
	   }


}
