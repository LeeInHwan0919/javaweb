package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
  
  private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
  /*
   * spring에서 사용하는 방법
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String initHello(int num, Model model) {
	  // 주소를 통해서 입력받은 숫자(num)를 받아서 곱하기 10을 해서 화면으로 전송해 준다.
	  // parameter , scope를 사용하는 방법
	  logger.info("처음만나는 Spring Framework");
	  model.addAttribute("result",num*33);
	  
	  return "/WEB-INF/views/hello.jsp";
  }
  
  
  /*
   * 예전 처리방식
   * request 객체를 통해서 parameter를 받고
   * Casting을 하고
   * 로직 연산을 하고
   * request scope에 담아주고  
   */
  @RequestMapping(value="/param", method=RequestMethod.GET)
  public String paramHello(HttpServletRequest request) {	  
	  logger.info("Spring에서의 Parameter처리 방식");
	  
	  String numString =  request.getParameter("num");
	  logger.info("전달 받은 파라미터 값 : " + numString);
	  
	  int result = Integer.parseInt(numString) * 22;
	  request.setAttribute("result", result);
	  
	  return "/WEB-INF/views/param.jsp";
  }
  /*
   * @RequestMapping(value="/param", method=RequestMethod.GET) 
   */
  @GetMapping(value="/encoding")
  public String encoding(String name, Model model, Locale locale) {
	  logger.info("encoding 전달받은 파라미터 값 : {} " , name);
	  model.addAttribute("val","나의 이름은?"+name);
	  
	  	Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

	  return "/WEB-INF/views/encoding.jsp";
  }
}
