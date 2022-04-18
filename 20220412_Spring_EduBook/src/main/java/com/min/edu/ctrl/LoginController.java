package com.min.edu.ctrl;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

@Controller
@SessionAttributes("loginVo") //현재 컨트롤러의 모든 곳에서 사용이 가능하다 
public class LoginController {

	private static final Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IUserService service;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVo vo, Model model,HttpSession session) {
		logger.info("Welcome LoginController 로그인 값 : {}",vo);
		UserVo loginVo = service.login(vo);
		if(loginVo == null) {
			return "redirect:/main.do";
		}else {
			logger.info("$$$$ 로그인 loginVo 값 : {}",loginVo);
//			model.addAttribute("loginVo",loginVo); // model은 spring Container의 rquest 객체이다 
			//@ReqyestMapping과는 값을 공유할수잇다 
//			session.setAttribute("loginVo", loginVo);
			
			model.addAttribute("loginVo", loginVo);
			
			return "boardList";
		}
	}
	
	@RequestMapping(value = "/logout.do",method = RequestMethod.GET)
	public String logout(HttpSession session,SessionStatus sessionStatus) {
		logger.info("session의 삭제 session.invalidate() ");

		sessionStatus.setComplete();
		UserVo vo =(UserVo) session.getAttribute("loginVo");
		logger.info("삭제된 session{}",session);
		
		return "redirect:/main.do";
	}
	
	//시나리오 
	//로그인이 된 상태에서 세션의 정보를 사용하여 값을 사용한다 ex) 새글입력
	@RequestMapping(value = "/sessionValue", method = RequestMethod.GET )
	public String sessionValue(HttpSession session, @ModelAttribute("loginVo") UserVo uVo) {
		/*
		 * Model 객체를 Request scope 영역이다 따라서 session에 scope를 사용하기 위해서는 
		 * @Controller에 @SessionAttribute("이름B")을 설정하고 
		 * 							model.addAttribute("이름B","값")을 통해서 입력하면 
		 * 	Model의 Request가 아닌 Session에 담기게 된다 
		 * 사용 방법:
		 * 	 1. HttpSession을 파라미터로 선언하고 session.getAttribute("이름B")를 통해서  캐스팅하여 사용 가능 
		 *  2. 같은 컨트롤러 내부라면 @ModelAttribute("이름B") 타입 변수명을 파라미터에 사용하면 자동으로 캐스팅 된 session을 사용 할 수 있다 
		 *  
		 *  삭제 방법 : 
		 *  1) Spring Annotation이기 때문에 session.invalidate()가 아닌 (완전삭제되기떄문)sessionStaus의 sessionStaus.cooplste()를 통해서 cleanup 할 수있다
		 */
		
		
		UserVo loginVo =(UserVo) session.getAttribute("loginVo");
		logger.info("session에 담겨있는 정보 가져오기{}",loginVo.getId());
		
		logger.info("sessiontAttribut에 담겨있는 정보 가져오기{}",uVo.getId());
		
		return "boardList";
	}
	
	
	
	
	
}
