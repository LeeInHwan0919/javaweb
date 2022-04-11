package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService service;
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("Welcome 로그인 화면 이동 loginForm");
		return "loginForm"; 
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> map, HttpSession session, HttpServletResponse resp) throws IOException {
		logger.info("Welcome 로그인 처리 후 이동 login");
		resp.setContentType("text/html; charset=UTF-8;");
		
		UserVo loginVo = service.getLogin(map);
		if(loginVo != null) {
			session.setAttribute("loginVo", loginVo);
			session.setMaxInactiveInterval(60*5);
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인이 되었습니다'); location.href='./boardList.do';</script>");
			out.flush();
			return null;
		}else {
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인 정보가 없습니다'); location.href='./loginForm.do';</script>");
			out.flush();
			return null;
		}
	}
	
	
	@RequestMapping(value = "/signupForm.do" , method = RequestMethod.GET)
	public String signupForm() {
		logger.info("Welcome 회원가입 화면 이동");
		return "signupForm";
	}
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(UserVo vo, HttpServletResponse resp) throws IOException {
		logger.info("Welcome 회원가입 입력 : {}", vo);
		int n = service.singupMember(vo);
//		int n = 0;
		if(n == 1) {
			return "redirect:/loginForm.do"; 
		}else {
			resp.setContentType("text/html; charset=UTF-8;");
			PrintWriter out =  resp.getWriter();
			out.println("<script>alert('회원가입에 실패하였습니다'); location.href='./loginForm.do';</script>");
			return null;
		}
		
	}
	
	@RequestMapping(value = "/duplication.do", method = RequestMethod.GET)
	public String duplication() {
		logger.info("Welcome 아이디 중복검사 화면 ");
		return "duplicate";
	}
	
	@RequestMapping(value = "/duplicationAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public  String duplicationAjax(String checkId) {
		logger.info("Welcome 아이디 중복 체크 : {} ", checkId);
		int n = service.isDuplicateCheck(checkId);
	return (n>0?"true":"false");	
	}
	
	@RequestMapping(value="/userSelectAll.do", method=RequestMethod.GET)
	public String userSelectAll(Model model) {
		logger.info("Welcome 회원전체조회");
		List<UserVo> lists = service.userSelectAll();
		model.addAttribute("lists", lists);
		return "userSelectAll";
	}
	
	@RequestMapping(value="/userSelectOne.do",method = RequestMethod.GET)
	public String userSelectOne(String id, Model model) {
		logger.info("Welcome 회원상세조회");
		UserVo vo=service.userSelectOne(id);
		model.addAttribute("vo", vo);
		return "userSelectOne";
	}
	
	@RequestMapping(value = "/getSearchUser.do", method = RequestMethod.POST,
										produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String getSearchUser(String opt, String keyword/* , UserVo vo, @RequestParam Map */) {
		logger.info("BoardController 회원검색");
		List<UserVo> lists = service.getSearchUser(opt, keyword);
//		{"title":{"김우연":"집"}, "친구":[{"이름":"홍길동", "이름":"피카츄"}]}
		
		//JSON-Simple
//		JsonObject obj = new JsonObject();
//		JsonObject obj1 = new JsonObject();
//		obj1.put("김우연","집")
		
//		obj.put("title",obj1)
		
//		JSONArray jArray = new JsonArray();
//		JsonObject obj2 = new JsonObject();
//		obj2.put("이름","홍길동");
//		obj2.put("이름","피카츄");
//		jArray.add(obj2);
		
//		obj.put("친구",jArray);
		
		Gson gson = new GsonBuilder().create();		
		return gson.toJson(lists);
		
	}
	@RequestMapping(value = "/findIdWindow.do", method = RequestMethod.GET)
	public String findIdWindow() {
		return "findId";
	}
	
	@RequestMapping(value = "/findId.do", method = RequestMethod.POST)
	@ResponseBody
	public String findId(String name, String email) {
		Map<String, Object> map = new HashMap<String, Object>()	;
		map.put("name", name);
		map.put("email", email);
		String id = service.findId(map);
		return (id==null)?"":id;
	}
	
	@RequestMapping(value = "/managementUser.do", method = RequestMethod.GET)
	public String managementUser(Model model) {
		logger.info("전체 회원 조회");
		List<UserVo> listsVo  = service.getAllUser();
		model.addAttribute("listsVo", listsVo);
		return "managementUser";
	}
	
	@RequestMapping(value = "/managementUser.do", method = RequestMethod.POST)
	@ResponseBody
	public String changeUser(String[] chksId, String btnChk) {
		logger.info("회원 관리 ");
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("ids", chksId);
		
		
		if(btnChk.equals("toAuth")) {
			int n = service.changeAuthToA(map);
			if(n>0) {
				return "yes";
			}else {
				return "no";
			}
		}else if(btnChk.equals("toUser")) {
			int n = service.changeAuthToU(map);
			if(n>0) {
				return "yes";
			}else {
				return "no";
			}
		}else if(btnChk.equals("inactiveUser")) {
			int n= service.changeDelflagToY(map);
			if(n>0) {
				return "yes";
			}else {
				return "no";
			}
		}else {
			int n =service.changeDelflagToN(map);
			if(n>0) {
				return "yes";
			}else {
				return "no";
			}
		}
		
	}
	
	
}







