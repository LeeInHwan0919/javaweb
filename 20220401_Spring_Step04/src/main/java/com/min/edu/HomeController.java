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
 * @Controller은 stereotype Bean으로 자동 등록되는 것들 
 * servlet-context.xml 자동등록 <context:component-scan base-package="topLevel하위">
 *                            <context:annotation-config/> bean으로 생성된 객체의 안에 있는 annotation이 동잘 될 수 있도록 해줌 
 *                            
 * 요청되는 주소에서 실행하고자하는 메소드 찾아줌(Handler-Mapping)
 * @Requestmapping(value="매핑명", method={RequestMethod.처리방식,RequestMethod.처리방식,...}) 
 * 4.3.25부터는 RequestMapping 구체적으로 구분 하기 위해서
 * @GetMapping, @PostMapping 구분하여 사용할 수 있다.
 * 
 * String 요청되는 주소에서 Handle Adapter에 의해서 메소드를 찾아서 실행시킴
 * 요청(Param) HttpServletRequest는 자동으로 java의 객체와 Mapping(타입, 변수명 등) 된다.
 * 
 * 	---- 파싱(parsing) vs 바인딩(binding) ----
 * 		파싱 : 값의 형태를 변화시키는 것
 * 		바인딩 : 부분에 껴넣거나 비어있는 부분을 완성시키는 것
 * 
 * 화면의 흐름제어(forward, redirect)
 * Spring famework은 기본이 DispatcherServlet가 처리해 줌 -> foward처리
 * 값은 Model객체에서 처리 + 화면은 View Resolver가 생성해 줌 -> ModelAndView 객체를 통해서 하나의 객체로 만들 수도 있다
 * Servlet 혹은 MVC에서의 Redirect는 주소에 요청한다 -> response.redirect("./화면이동"); ->  WEB-INF는 호출 못한다
 * 근데 Spring redirect는 자신이 가지고 있는 Mapping을 호출한다 -> return "redirect:/home.do"
 * 
 * 전송되는 scope처리
 * page, request, session, application
 * Spring Model request scope이다 -> Model.ui객체를 사용하면 되지만 
 * HttpServletRequest를 사용해도 같은 역할을 한다
 * 
 * 마지막으로 값과 화면을 같이 담아서 처리해주는 객체
 * ModelAndView 객체를 사용하면된다. new를 해서 사용해야 한다
 * ModelAndview mav = new ModelAndView();
 * mav.addObject("","");
 * mav.setViewname("");
 * return mav; 
 * 
 */

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * 만약에 반환이 null인 경우 메소드 명과 같은  값을 리턴 합니다 
	 */
//	@RequestMapping(value="/home.do",method=RequestMethod.GET)
//	public String home(String name,Model model) {
//		logger.info("home 전달받은 param :{} ",name);
//		model.addAttribute("name",name+"님 안녕하세요 ");
//		
////	return null;
//		return"home";
//}
	
	@GetMapping(value = "/home.do")
	public String home(String name, HttpServletRequest request, Model model) {
		logger.info("@GetMapping home 요청받은 name값 : {}", name);
		String str = "가장 좋아하는 야채"+name;
//		request.setAttribute("req_str", str);
		model.addAttribute("str",str);
		return "home";
	}
	
	@PostMapping(value = "/home.do")
	public String home(String name, Model model) {
		logger.info("@PostMapping home 요청 받은 name값 : {}", name);
		String str = "열대과일"+name;
		model.addAttribute("str",str);
		//1) null: 자신의 method명을 반환함
		//2) 문자열 : DispatcherServlet에 의해서 문자열이 ViewResolver로 이동 prefix + 문자열 + suffix를 만들어서 해당 페이지의 위치로 이동
		//3) resolver가 없는 경우는 해당 위치의 페이지를 모두 적어줘야 함 ex) "/WEB-INF/views/home.jsp"
		return "home";
	}
	
	@RequestMapping(value = "/info.do",method = {RequestMethod.GET,RequestMethod.POST})
	public String info(/*String name, int age,*/Model model) {
//		logger.info("전달받은 파라미터 :{}",(name+age));
//		model.addAttribute("info",name+age);
		
		logger.info("info.do 처리방식");
		return "info";
	}
	
	/*
	 * Model 객체는 redirect를 통해서 Spring Container내에서 값을 공유 할 수 있다 ex)model.addAttribute("name","난 누군가?");home 전송
	 * HttpServletRequest는 값을 공유하지않고 요청한 다음페이지에만 전송하며 redirect는 새로운 객체를 전송하게 된다. ex)req.setAttribute 
	 */
	
	@GetMapping(value = "/redirect.do")
	public String redirect (String name,Model model, HttpServletRequest req) {
		logger.info("@GetMapping redirect 요청 받은 name값 : {}", name);
		model.addAttribute("str",name);
//		model.addAttribute("name", "나는 누군가");
		req.setAttribute("name", "난 널 사랑해");
		return "redirect:/home.do"; //redirect는 Get방식의 호출이다
	}
	
	
	
	
	
	
}
