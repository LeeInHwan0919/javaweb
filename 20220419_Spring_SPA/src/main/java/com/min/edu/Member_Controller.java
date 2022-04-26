package com.min.edu;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.MemberVo;

@Controller
@SessionAttributes("mem2")
public class Member_Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); //this는 자기자신의 객체인데 메모리에 올라가있는 static은 클래스명.class()
	
	@Autowired
	private IMemberService iService;
	
	//연산이 많이 발생하면 stackOverFlow / 객체가 많이 생성되면 outOfMemory
	
	//TODO 001 로그인 화면으로 이동
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm () {
		logger.info("Welcome Member_Controller loginForm" );
		
		return "loginForm";
	}
	
	//TODO 002 로그인 화면에서 비동기식 로그인 정보 확인 : Text 반환 : 헤더정보에서 값의 타입을 보내줘야함
	@RequestMapping(value = "/loginCheckText.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String loginCheckText(@RequestParam Map<String, Object> map) {
		logger.info("Welcome Member_Controller loginCheckText : {}", map );
//		return "성공";
		return "{\"isc\":\"성공\"}";
	}
	
	//TODO 003 로그인 화면에서 비동기식 로그인 정보 확인 : Map 반환 
	//Map으로 보낼수는 없음 (객체이기 때문에 text만 보낼 수 있음) 
	//만약 반환타입이 DTO 면?  DTO 가 JSON으로 변환되는건 jackson Mapper 를 사용해야 함 - getter, setter 가 있다는 전제하에
	//Jackson databind 이 자동으로 Map의 데이터를 JSON형태로 변경하여 전송함
	@RequestMapping(value = "/loginCheckMap.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> loginCheckMap(@RequestParam Map<String, Object> map){
		Map<String, String> rMap = new HashMap<String, String>();
		logger.info("Welcome Member_Controller loginCheckMap : {}", map );
	    MemberVo mVo =  iService.loginMember(map);
	    logger.info("Welcome Member_Controller loginCheckMap 로그인 정보 : {}", mVo );
	    if(mVo == null) { //selectList 는 size를 판단해야하고 selectOne은 null판단을해줘야함
	    	rMap.put("isc", "실패");
	    }else {
	    	rMap.put("isc", "성공");
	    }
		return rMap;
	}
	
	//TODO 004 로그인 정보가 Ajax로 확인된 후 @SessionAttributes에 담고 첫페이지가 되는 곳으로 이동
	//만들고 난 후 boardList.do라고 하는 전체 게시글을 가지고 오는 애를 redirect 처리해줄 것
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, Model model) {
		logger.info("Welcome Member_Controller login : {}", map );
		MemberVo mVo =  iService.loginMember(map);
		model.addAttribute("mem2", mVo);
		//response 의 redirect와 여기서의 redirect의 차이점
//		reponse는 response가 보내주는데 얘는 text로 보내줌
//		왜 Sping에서는 String으로 처리할까 return을 dispatcher Servlet이 해주기때문ㅇ ㅔ-> resolver -> prefix, suffix 를 만들어 줌
//		자기가 가지고있는 container의 bean을 호출해줌 
//		return "boardList";
		return "redirect:/boardList.do";
	}
	
	//TODO 006 로그아웃 기능
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus, @SessionAttribute("mem2") MemberVo mVo) {
		logger.info("Welcome Member_Controller logout 전 : {}", mVo );
		sessionStatus.setComplete();
		logger.info("Welcome Member_Controller logout 후 : {}", mVo );

		return "redirect:/loginFrom.do";
	}
	
	//TODO 007 회원가입 화면 이동
	@GetMapping(value = "/signupForm.do")
	public String signupForm() {
		logger.info("Welcome Member_Controller signupForm");
		
		return "signupForm";
	}
	
	//TODO 008 아이디 중복 검사 (beforesend걸어주면 좋음)
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	public Map<String, String> idCheck(String id){
		Map<String, String> map = new HashMap<String, String>();
		logger.info("Welcome Member_Controller idCheck : {}", id);
		
		int n = iService.idCheck(id);
		map.put("isc", n+"");
		return map;
	}
	
	//TODO 009 회원가입
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(@RequestParam Map<String, Object> map) {
		logger.info("Welcome Member_Controller signup : {}", map);
		int n = iService.insertMember(map);
		
		return (n==1)?"redirect:/loginForm.do":"redirect:/signupForm.do";
	}
	
	//TODO 010 관리자가 회원전체의 정보를 조회하는 기능
	//ModelAndView 객체를 사용해본다 
	//값과 화면을 묶어서 보내기 때문에 ajax에서 사용하지 않는다
	@RequestMapping(value = "/memberListMAV.do", method = RequestMethod.GET)
	public ModelAndView memberListMAV() {
		ModelAndView mav = new ModelAndView();
		logger.info("Welcome Member_Controller memberListMAV ");
		List<MemberVo> mLists =  iService.selectMemberAll();
		//Model And View 객체는 Model(MVC의 Model이 아닌 Spring이 가지고있는 bean객체)+View(binding이 될) 를 한 객체에 담아서 DispatcherServlet에 봬줌
		//										전달값 																							페이지
		
		mav.addObject("mLists", mLists);
		mav.setViewName("memberList");
		
		return mav;
	}
	
	//TODO 011 회원상태 변경 Ajax 
	//값은 id Map
	//SQL 문 Simple CASE 사용해서 N->Y, Y->N 변경되게 만듬
	//반환 값은 Map -> Jackson databind -> JSON 
 	@RequestMapping(value = "/changeUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> changeUser(@RequestParam Map<String, Object> map){
		logger.info("Welcome Member_Controller changeUser : {} ", map);
		Map<String, String> rMap = new HashMap<String, String>();
		boolean isc =  iService.changeUser(map);
		rMap.put("isc", String.valueOf(isc));
		return rMap;
	}
	
}







