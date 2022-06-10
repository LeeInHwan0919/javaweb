package com.min.edu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.vo.TestVo;

@Controller
public class MessageHandler {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Map<String, Object> map;
	
	public MessageHandler() {
		map = new HashMap<String, Object>();
	}
	
	@PostMapping(value="/urlAjax.do", produces = "application/text; charset=UTF-8")
//	@ResponseBody
	public String urlAjax(@RequestParam("url") String url, @RequestParam("name") String name, HttpSession session) {
		String[] strArr = url.split("/");
		String realSession = strArr[strArr.length-2];
		System.out.println(Arrays.toString(strArr));
		System.out.println(name);
		map.put(name, realSession);
		return "websocket";
	}
	
	@MessageMapping("/login")
	@SendTo("/sub/entr")
	public String test(String name){
		
		System.out.println("#################"+name);
		return name;
	}
	
	@MessageMapping("/apprMem/{susin}")
	@SendTo("/sub/approval/{susin}")
	@ResponseBody
	public String test2(@PathVariable(name = "susin") String susin, TestVo vo) {
		logger.info("vo 현 상태 : {}", vo);
		System.out.println("session 정보"+map);
		System.out.println("@@@@@@@@@@@@@@@@@@@"+susin);
		System.out.println(map.containsKey(vo.getSusin()));
//		if(map.containsKey(vo.getSusin())) {
			return vo.getBarsin();
//		}else {
//			return null;
//		}
	}
	
	@MessageMapping("/Comp/{susin}")
	@SendTo("/sub/Comp/{susin}")
	@ResponseBody
	public void compAppr(@PathVariable(name = "susin") String susin, TestVo vo) {
		logger.info("vo 현 상태 : {}", vo);
		System.out.println("session 정보"+map);
		System.out.println("@@@@@@@@@@@@@@@@@@@"+susin);
	}
	
	@MessageMapping("/logout")
	public void logout(TestVo vo) {
		map.remove(vo.getBarsin());
	}
}
