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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;

/**
 * Handles requests for the application home page.
 */
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
	
	//회원 전체 조회 memberList
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String memberList(Model model) {
		logger.info("Welcome! MemberController 회원 전체 조회");
		List<MemberVo> lists = service.selectMemberAll();
		//model 은 spring container로 간다. 다른 model도 유지시키고 싶다면 modelAttribute사용하면 된다.
		model.addAttribute("memLists", lists);
		return "test";
	}
	
	//회원 가입 signup
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(@RequestParam Map<String, Object> map, Model model) {
		logger.info("Welcome! MemberController 회원 가입 : "+ map);
		int n = service.insertMember(map);
		model.addAttribute("isc", (n>0)?"회원가입성공":"실패");
		return "test";
	}
	
	//ID 중복 체크 idCheck
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	public String idCheck() {
		return "test";
	}
	
	//로그인 login
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(@RequestParam Map<String , Object> map, Model model, HttpSession session) {
		/*
		 * @SessionAttributes의 선언된 객체는 Model을 통해서 입력 함
		 * 화면에서 사용할때는 sessionScope와 requestScope에 같은 이름으로 담기게 됨
		 * 만약에 같은 이름으로 HttpSession이 담겨 있다면 Model의 객체가 우선시 됩니다
		 */
//		MemberVo loginVo =  service.loginMember(map);
//		model.addAttribute("mem", loginVo);
//		loginVo.setId("**********"); //passby reference라서 
//		MemberVo testVo = new MemberVo("******", "","", "", "");
//		session.setAttribute("mem", loginVo);
//		session.setAttribute("mem2", testVo);
		//session이 나중에 담긴다 httpSession 보다 container에서 우선동작하기때문에 bin이 우선이다. session의 값은 model에서 담은 아이 이고 이것은 request에도 담긴다.
		
		MemberVo mVo = service.loginMember(map);
		session.setAttribute("mem2", mVo);
		
		return "test";
	}
	
	//비밀번호확인 pwCheck
	@RequestMapping(value = "/pwCheck.do", method = RequestMethod.GET)
	public String pwCheck() {
		return "test";
	}
	
	//아이디 로그인 idLogin
	@RequestMapping(value = "/idLogin.do", method = RequestMethod.GET)
	public String idLogin() {
		return "test";
	}
	
	//modelAttribute 는 binding 객체 : 내부 객체를 다시 한번 담아줌 
	//mem은 sessionAttribute에 있었는데 그걸 param으로 modelAttribute가 받아주고 
	//logout을 했어 sessionstatus.setcomplete를 하면 controller에서 사용하는 모든 modelAttribute가 다 삭제되니깐 mem이라는 것이 다 사라져서 오류
	//@ModelAttribute MemberVo m 으로 사용하면 sessionAttribute - model  - httpSession : logout하면 sessionAttribute 삭제 두번째는 request객체이기때문에 사라지지 않음
	//f5를 누르면 model은 객체를 만들어주는 아이이기때문에 비어있는 bean객체가 만들어 진 것 : parameter 를 던진적도 parsing한적도 없는데 null 
	//session에 있는 애를 가지고와서 받아줌 

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, 
//			@ModelAttribute() MemberVo m, 
			@ModelAttribute("val") String v, 
			SessionStatus sessionStatus) {
//		public String logout(HttpSession session, 
////			@SessionAttribute("mem") MemberVo m, 
//				SessionStatus sessionStatus) {
//	public String logout(HttpSession session, @ModelAttribute("mem") MemberVo m, SessionStatus sessionStatus) {
		logger.info("Welcome! MemberController 로그 아웃 HttpSession : "+ session.getAttribute("mem2"));
//		logger.info("Welcome! MemberController 로그 아웃 @ModelAttribute : "+ m);
		logger.info("Welcome! MemberController vvvvvvvv @ModelAttribute : "+ v);
		
		sessionStatus.setComplete(); //@ModelAttribute 안지워짐
		
//		session.removeAttribute("mem2"); //HttpSession 지워짐 : null뜬다. 세션을 무효화시키진 않고 이름만 지움
//		session.invalidate(); //세션이 무효화됨
		
		logger.info("Welcome! MemberController 로그 아웃 HttpSession : "+ session.getAttribute("mem2"));
//		logger.info("Welcome! MemberController 로그 아웃 @ModelAttribute : "+ m);
		
		
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
