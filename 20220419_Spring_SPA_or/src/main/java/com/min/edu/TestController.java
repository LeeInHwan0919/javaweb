package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

//@Controller
//@SessionAttributes("mem")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private IMemberService service;
	
	@ModelAttribute("val")
	public String model() {
		return "값";
	}
	
	@RequestMapping(value="/memberList", method = RequestMethod.GET)
	public String memberList(Model model,RowNumVo vo) {
		logger.info("Welcome! MemberController 회원 전체 조회");
		List<MemberVo> lists = service.selectMemberAll(vo);
		model.addAttribute("memLists",lists);
		return "test";
	}
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public String signUp(@RequestParam Map<String, Object> map, Model model) {
		logger.info("Welcome! MemberController 회원 가입 : {}",map);
		int n = service.insertMember(map);
		model.addAttribute("isc",(n>0)?"성공":"실패");
		return "test";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login(@RequestParam Map<String, Object> map, Model model, HttpSession session) {
		/*
		 * @SessionAttribute의 선언된 객체를 Model을 통해서 입력 함
		 * 화면에서 사용할 때는 sessionScope와 requestScope에 같은 이름으로 담기게 됨
		 * 만약에 같은 이름으로 HttpSession이 담겨 있다면 Model의 객체가 우선시 됩니다.
		 */
//		logger.info("Welcome! MemberController 로그인 : {}",map);
//		MemberVo loginVo =  service.loginMember(map);
//		model.addAttribute("mem",loginVo);
//		MemberVo testVo = new MemberVo("********","","","","");
//		session.setAttribute("mem2", testVo);
		
		MemberVo mVo = service.loginMember(map);
		session.setAttribute("mem2", mVo);
		
		return "test";
	}
	
	@RequestMapping(value="/pwCheck.do", method = RequestMethod.GET)
	public String pwCheck() {
		
		return "test";
	}
	
	@RequestMapping(value="/idLogin.do", method = RequestMethod.GET)
	public String idLogin() {
		
		return "test";
	}
	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session,
//			@ModelAttribute() MemberVo m,
			@ModelAttribute("val") String v,
			SessionStatus sessionStatus) {
		logger.info("Welcome! logout HttpSession : {}",session.getAttribute("mem2"));
//		logger.info("Welcome! logout @ModelAttribute : {}",m);
		logger.info("Welcome! logoutvvvvvv @ModelAttribute : {}",v);
		sessionStatus.setComplete();
		
//		session.removeAttribute("mem2");
//		session.invalidate();
		
		logger.info("Welcome! logout HttpSession : {}",session.getAttribute("mem2"));
//		logger.info("Welcome! logout @ModelAttribute : {}",m);
		return "test";
	}
	
	
	
	
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome! MemberController : {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
