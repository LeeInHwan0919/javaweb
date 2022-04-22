package com.min.edu;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;

@Controller
@SessionAttributes("mem2")
public class Member_Controller {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMemberService iService;
	
	//TODO 001 로그인 화면 이동
	@RequestMapping(value="/loginForm.do" , method = RequestMethod.GET)
	public String loginForm() {
		logger.info("Welcome! Member_Controller loginForm GET 로그인창 이동 ");
		return "loginForm";
	}
	
	//TODO 002 로그인 화면에서 비동기식 로그인 정보 확인 : Text 반환
	@RequestMapping(value="/loginCheckText.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String loginCheckText(@RequestParam Map<String, Object> map) {
		logger.info("Welcome! Member_Controller loginCheckText POST : {} ",map);
//		return "성공";
		return "{\"isc\":\"성공\"}";
	}
	
	//TODO 003 로그인 화면에서 비동기식 로그인 정보 확인 : Map 반환
	// Jackson databind가 자동으로 Map의 데이터를 JSON 형태로 변경하여 전송함
	@RequestMapping(value="/loginCheckMap.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, String> loginCheckMap(@RequestParam Map<String, Object> map){
		Map<String, String> rMap = new HashMap<String, String>();
		logger.info("Welcome! Member_Controller loginCheckMap  : {} ",map);
		MemberVo mVo = iService.loginMember(map);
		logger.info("Welcome! Member_Controller loginCheckMap 로그인 정보  : {} ",mVo);
		if(mVo == null) {
			rMap.put("isc", "실패");
		}else {
			rMap.put("isc", "성공");
		}
		return rMap;
	}
	
	//TODO 004 로그인 정보가 Ajax로 확인된 후 @SessionAttribute에 담고 첫 페이지가 되는 곳으로 이동
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map,Model model) {
	logger.info("Welcome! Member_Controller login  : {} ",map);
	MemberVo mVo = iService.loginMember(map);
	model.addAttribute("mem2",mVo);
//	return "boardList";
	return "redirect:/boardList.do";
	}
	
	//TODO 006 로그아웃 기능
	@RequestMapping(value="/logout.do",method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus, @SessionAttribute("mem2") MemberVo mVo) {
		logger.info("Welcome! Member_Controller logout전:{}",mVo);
		sessionStatus.setComplete();
		logger.info("Welcome! Member_Controller logout 후  : {} ",mVo);
		return "redirect:/loginForm.do";
	}
	
	//TODO 007 회원 가입 화면 이동
	@GetMapping(value="/signup.do")
	public String singupForm() {
		logger.info("Welcome! Member_Controller singupForm 회원가입 화면 이동");
		return "singupForm";
	}
	
	//TODO 008 아이디 중복 검사
	@RequestMapping(value="/idCheck.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> idCheck(String id){
      Map<String, String> map = new HashMap<String, String>();
	  logger.info("Welcome! Member_Controller idCheck id:{}",id);
	  int n = iService.idCheck(id);
	  map.put("isc",n+"");
	  return map;
	}
	
}
