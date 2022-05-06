package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.min.edu.util.ProImg;
import com.min.edu.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @RequestMapping(value = "/registForm.do", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      String formattedDate = dateFormat.format(date);
      model.addAttribute("serverTime", formattedDate );
      return "regist";
   }
   
   @RequestMapping(value = "/regist.do", method = RequestMethod.POST)
   public String regist(UserVo vo , MultipartFile filename,Model model) {
      System.out.println("UserVo:"+vo);
      System.out.println("MultipartFile:"+filename);
      String proImg = ProImg.saveFile(filename);
      System.out.println("DB에 입력되는 파일명:"+proImg);
      
      //입력된 정보 전달 
      vo.setProimg(proImg);
      model.addAttribute("infoUser",vo);
      return "infoView";
   }
   
}