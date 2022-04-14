package com.min.edu.ctrl;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/mailForm.do", method=RequestMethod.GET)
	public String mailForm() {
		logger.info("MailController 메일 작성 화면 이동");
		return "mailForm";
	}
	
	@RequestMapping(value="/mailSender.do",method=RequestMethod.POST)
	public String mailSender(@RequestParam Map<String,String> mailMap) {
	logger.info("MailController mailSender.do 전송값post : {}",mailMap);
	
	//자신의 메일 주소가 필수로 입력되어야 합니다.
	String setFrom = "lucifer0203_2@naver.com";
	
	// 메일의 내용을 전송하기 위한 객체 MimeMessage
	MimeMessage message = mailSender.createMimeMessage();
	
	try {
		// MimeMessageHelper : MimeMessage(송신 서버 정보,첨부파일 여부 t/f, "글자의 인코딩") 
		MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
	    messageHelper.setFrom(setFrom);//보내는 사람의 이메일, 생략하면 안됨(안감 + 문제발생)
	    messageHelper.setTo(mailMap.get("tomail"));//받는 사람 이메일
	    messageHelper.setSubject(mailMap.get("title"));//메일의 제목(생략가능)
	    
	    //내용의 처리
	    
	} catch (MessagingException e) {
		e.printStackTrace();
	}
	
	return "redirect:/main.do";
	}
	
	
}
