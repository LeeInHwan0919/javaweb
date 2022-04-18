package com.min.edu.ctrl;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
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
	
	@RequestMapping(value = "/mailForm.do",method = RequestMethod.GET)
	public String mailForm() {
		logger.info("MailController 메일 작성 화면 이동");
		return "mailForm";
	}
	
	@RequestMapping(value = "/mailSender.do",method = RequestMethod.POST)
	public String mailSender(@RequestParam Map<String, String> mailMap) {
		logger.info("MailController mailSender.do 전송 값 : {}",mailMap);
		
		//자신의 메일 주소가 필수로 입력되어야 함
		String setFrom = "minjjeong0104@naver.com";
		
		//메일의 내용을 전송하기 위한 객체 MimeMessage
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			//MimeMessageHelper : MimeMessage(송신서버정보)dataSource, 첨부파일 여부 true/false, 글자의 인코딩
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setFrom); //보내는 사람의 이메일, 생략하면 안됨
			messageHelper.setTo(mailMap.get("tomail")); //받는 사람 이메일
			messageHelper.setSubject(mailMap.get("title")); //메일의 제목 (생략가능)
			
			// 내용의 처리 
			// 본문 내용 : true면 글자를 HTML로 인식한다
//			messageHelper.setText(mailMap.get("content"), false);
			messageHelper.setText(mailMap.get("content"), true);
			
			//첨부파일 처리 
			// MimeMessageHelper의 옵션 중에서 두번째 multipart 입력이 true로 되어 있을 때 가능
			FileSystemResource fileResource = new FileSystemResource("C:\\eclipse_web_2020_09/013201.png");
			messageHelper.addAttachment("메타몽.png", fileResource);
				
			mailSender.send(message); //41line message
			
			 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
		
		
		return "redirect:/main.do";
	}
}