package com.min.edu.ctrl;

import java.util.List;

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
@SessionAttributes("loginVo") //현재 컨트롤러의 모든 곳에서 사용이 가능
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
//          model은 Spring Container의 request 객체이다. @RequestMapping과는 값을 공유
//			model.addAttribute("loginVo",loginVo);
//			session.setAttribute("loginVo", loginVo);
			
			model.addAttribute("loginVo",loginVo);
			
			return "boardList";
		}
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus) {
//		logger.info("session의 삭제 session.invalidate()"); //세션의 사용이 무효화 된다, 해당메소드를 사용할 수 없음(언바운드됨)
//		session.invalidate();
//		UserVo vo = (UserVo)session.getAttribute("loginVo");
//		logger.info("$$invalidate된 세션 {}",session);
		
//		logger.info("session의 삭제 session.removeAttribute()");
//		session.removeAttribute("loginVo");
//		UserVo vo = (UserVo)session.getAttribute("loginVo");
//		logger.info("삭제된$$ remove after 세션 {}",vo);
		
		sessionStatus.setComplete();
		UserVo vo = (UserVo)session.getAttribute("loginVo");
		logger.info("$$invalidate된 세션 {}",vo);
		
		return "redirect:/main.do";
	}
	
	// 시나리오
	// 로그인이 된 상태에서 세션의 정보를 사용하여 값을 사용한다. ex) 새글 입력
	@RequestMapping(value="/sessionValue.do",method=RequestMethod.GET)
	public String sessionValue(HttpSession session, @ModelAttribute("loginVo")UserVo uVo) {
		/*
		 * Model 객체는 Request scope의 영역이다. 따라서 Session scope를 사용하기 위해서는
		 * @Controller에 @SessionAttribute("이름B")을 설정하고
		 * 				model.addAttribute("이름B","값")을 통해서 입력하면 얘는
		 * Model의 request가 아닌 SessionScope에 담는다 . 
		 *   사용방법:
		 *     1) HttpSession을 Parameter로 선언하고 session.getAttribute("이름B")를 한 후  캐스팅하여 사용가능
		 *     2) 같은 Controller이라면 @ModelAttribute("이름B")타입 변수명을 Parameter에 사용하면 자동으로 캐스팅된 session을 사용할 수 있다.
		 *     
		 *   삭제방법:
		 *     1) Spring Annotation이기 때문에 sessiosn.invalidate()가아닌 SessionStatus의 sessionStatus.setComplete()를 통해 cleanup 할 수 있다.   
		 */    
		
		
		
		UserVo vo = (UserVo)session.getAttribute("loginVo");
		logger.info("session에 담겨 있는 정보 가져오기 : {}",vo.getId());
		
		logger.info("@SessionAttribute에 담겨 있는 정보 가져오기 : {}",uVo);
		
		return "boardList";
	}
	
	
}
