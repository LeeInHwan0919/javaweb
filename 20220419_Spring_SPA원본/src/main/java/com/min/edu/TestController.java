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
import org.springframework.web.bind.annotation.SessionAttribute;
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
		return "값값";
	}

	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String memberList(Model model, RowNumVo vo) {
		logger.info("MemberController memberList 회원전체조회");
		List<MemberVo> lists = service.selectMemberAll(vo);
		model.addAttribute("memLists", lists);
		return "test";
	}
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(@RequestParam Map<String, Object> map, Model model) {
		logger.info("MemberController signup 회원가입" + map);
		int n = service.insertMember(map);
		model.addAttribute("isc", (n>0)?"성공":"실패");
		return "test";
	}
	
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	public String idCheck() {
		
		return "test";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(@RequestParam Map<String, Object> map, Model model, HttpSession session) {
		/*
		 * @SessionAttribute 의 선언된 객체는 Model 을 통해서 입력할 수 있다.
		 * 화면에서 사용할때는 sessionScope와 requestScope에 같은 이름으로 담기게 된다.
		 * 만약에 같은 이름으로 HttpSession 이 담겨 있다면 Model 의 객체가 우선시 된다.
		 */
//		MemberVo loginVo = service.loginMember(map);
//		model.addAttribute("mem", loginVo);
//		MemberVo testVo = new MemberVo("******","","","","");
//		session.setAttribute("mem2", testVo);
		
		MemberVo mVo = service.loginMember(map);
		session.setAttribute("mem2", mVo);
		return "test";
	}
	
	@RequestMapping(value = "/pwCheck.do", method = RequestMethod.GET)
	public String pwCheck() {
		
		return "test";
	}
	
	@RequestMapping(value = "/idLogin.do", method = RequestMethod.GET)
	public String idLogin() {
		
		return "test";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session
//			, @ModelAttribute MemberVo m
			, @ModelAttribute("val") String v
			, SessionStatus sessionStatus) {
		logger.info("MemberController logout 로그아웃 HttpSession : " + session.getAttribute("mem2"));
		logger.info("MemberController logout 로그아웃vvvvv @ModelAttribute : " + v);
		sessionStatus.setComplete();
		
//		session.removeAttribute("mem2");
//		session.invalidate();
		
		logger.info("MemberController logout 로그아웃 HttpSession : " + session.getAttribute("mem2"));
//		logger.info("MemberController logout 로그아웃 @ModelAttribute : " + m);
		return "test";
	}
	
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome! MemberConteroller {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
}
