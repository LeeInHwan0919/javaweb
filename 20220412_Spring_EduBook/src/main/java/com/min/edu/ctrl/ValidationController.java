package com.min.edu.ctrl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.vo.RegistValidateDto;

@Controller
public class ValidationController {

	private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);
	
	@ModelAttribute("registvalidatedto")
	public RegistValidateDto modelAttribute() {
	  RegistValidateDto vo = new RegistValidateDto();
	  return vo;
	}
	
	@RequestMapping(value = "/formValidation.do", method = RequestMethod.GET)
	public String registFormValidation() {
		logger.info("ValidationController registformValidation 이동");
		return "registformValidation";
	}
	
	@RequestMapping(value="/regist.do", method=RequestMethod.POST)
	public String regist(@ModelAttribute("registvalidatedto") @Valid RegistValidateDto registvalidatedto,BindingResult result) {
		logger.info("ValidationController regist 회원가입 {}",registvalidatedto);
		String view="";
		if(result.hasErrors()){
			logger.info("BindingResult 값 에러 발생");
			view="registformValidation";
		}else {
			logger.info("회원가입 완료");
			view="redirect:/main.do";
		}
		
		return view;
	}
}
