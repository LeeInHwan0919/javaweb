package com.min.edu;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @Controller는 stereotype Bean으로 자동 등록 되는 것들
 * servlet-context.xml 자동 등록 <context:component-scan base-package="topLevel하위">
 * 							  <context:annotation-config/> bean으로 생성된 객체의 안에 있는 annotation들이 동작 될 수 있도록 해줌(오토와이드 리소스 퀄리파이어 리퀘스트맵핑 등등)
 *
 *	요청되는 주소에서 실행하고자하는 메소드 찾아 줌(Handler-Mapping)
 *  @RequestMapping(value="매핑명", method={ReqeustMathod.처리방식, ReqeustMathod.처리방식})
 *  4.3.25부터는 RequestMapping 구체적으로 구분 하기 위해서
 *  @GetMapping, @PostMapping 같이 구분하여 사용할 수 있다.
 *  
 *  String으로 요청되는 주소에서 Handle Adapter에 의해서 몌소드를 찾아서 실행
 *  요청(Param) HttpservletRequest는 자동으로 자바의 객체와 매핑(타입, 변수명)
 *   --- 파싱(parsing):값의 형태를 변화 시키는 것  vs 바인딩(Binding): 부분에 껴넣거나 비어있는 부분을 완성
 *   
 *   화면의 흐름제어(forward , redirect)
 *   Spring framework는 기본의 DispatcherServlet이 처리해줌
 *   값은 Model객체에서 처리 + 화면은 View Resolver가 생성해줌 => ModelAndView 객체를 통해서 하나의 객체로 만들 수도 있다.
 *   Servlet 혹은 MVC에서의 Redirect는 주소에 요청한다. response.redirect("./화면이동"); -> 따라서 WEB-INF는 호출 못한다.
 *   근데 Spring redirect는 자신이 가지고 있는 Mapping을 호출 한다. return "redirect:/home.do"
 *   
 *   전송되는 scope 처리
 *   page request session application
 *   Spring에서 Model은 request scope이다.Model.ui 객체를 사용하면 되고 하지만
 *   HttoServletRequest를 사용해도 같은 역할을 한다.
 *   
 *   마지막으로 값과 화면을 값이 담아서 처리 해주는 객체가 있음
 *   ModelAndView 객체를 사용하면 된다. new 를 해서 사용해야 한다.
 *   ModelAndView mav = new ModelAndView();
 *   mav.addObject("","");
 *   mav.setViewname("화면이름");
 *   return mav;
 */
@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * 만약에 반환이 null인 경우 메소드명과 같은 값을 리턴합니다.
	 */	
	
	@GetMapping(value="/home.do")
	public String home(String name, HttpServletRequest req, Model model) {
	  logger.info("@GetMapping home요청 받은 name 값 : {}",name);
	  String str="가장 좋아하는 야채"+name;
//	  req.setAttribute("req_str", str);
	  model.addAttribute("str",str);
	  return "home";
	}
	
	@PostMapping(value="/home.do")
	public String home(String name, Model model) {
		logger.info("@PostMapping home 요청 받은 name값 : {}",name);
		String str = "열대과일"+name;
		model.addAttribute("str",str);
		// 1) null : 자신의 method명을 반환합니다.
		// 2) 문자열 : DispatcherServlet에 의해서 문자열이 ViewResolver로 이동 prefix + 문자열 + suffix를 만들어서 해당 페이지의 위치로 이동
		// 3) resolver가 없는 경우는 해당 위치의 페이지를 모두 적어줘야함 ex)"/WEB-INF/views/home.jsp"
		return "home";
	}
	
	
	@RequestMapping(value="/info.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String info(/*String name, int age,*/ Model model) {
//		logger.info("info 메서드 ,전달 받은 파라미터 : {} " , (name+age));
//		model.addAttribute("infoname", name);
//		model.addAttribute("infoage", age);
		logger.info("info.do 처리 방식");
		return "info";
	}
	
	/*
	 * Model객체는 redirect: 을 통해서 Spring Container 내에서 값을 공유 할 수 있다. ex) model.addAttribute("name","난 누군가?"); home전달    
	 * HttpServletReqeust는 값을 공유하지 않고 요청된 다음페이지 에만 전송하며 redirect는 새로운 객체를 전송 하게 된다.
	 */
	@GetMapping(value="/redirect.do")
	public String redirect(String name, Model model, HttpServletRequest req) {
		logger.info("@GetMapping redirect 요청 받은 name 값 : {}", name);
		model.addAttribute("str",name);
//		model.addAttribute("name","난 누군가?");
		req.setAttribute("name", "난 널 사랑해");
		return "redirect:/home.do"; // redirect는 Get방식의 호출 이다.
	}
}
