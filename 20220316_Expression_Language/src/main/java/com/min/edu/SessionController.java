package com.min.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.ScoreDto;

@WebServlet("/ctrlSession.do")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용되고 있는 session은 vo, val를 선언하여 가지고 있다.
		// session을 삭제 하는 방법
		// session의 삭제는 invalidate를 통해서 객체를 삭제하는 방법과
		// 				removeAttribute를 통해서 key와 value를 삭제
		
		HttpSession session = request.getSession();
		ScoreDto sVo = (ScoreDto)session.getAttribute("vo");
		String sVal = (String)session.getAttribute("val");
		System.out.println("session vo 값:"+ sVo);
		System.out.println("session val 값:"+ sVal);
		
		//session을 removeAttribute를 통해서 삭제
		session.removeAttribute("vo");
		ScoreDto srVo = (ScoreDto)session.getAttribute("vo");
		System.out.println("session vo 값:"+ srVo);
		
		//session을 invalidate로 통해서 제거
		session.invalidate();
		ScoreDto siVo = (ScoreDto)session.getAttribute("vo");
		String ssVal = (String)session.getAttribute("val");
		System.out.println("session vo 값:"+ siVo);
		System.out.println("session val 값:"+ ssVal);
	}



}
