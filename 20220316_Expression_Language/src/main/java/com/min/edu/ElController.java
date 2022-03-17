package com.min.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.ScoreDto;

@WebServlet("/elCtrl.do")

public class ElController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ElController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("요청된 command값"+ command);
		
		ScoreDto vo1 = new ScoreDto("놀부",100,100,30,"nol");
		ScoreDto vo2 = new ScoreDto("흥부",90,60,90,"heng");
		
		/*
		 * Scope 객체의 호출 우선 순위 page -> request ->session->application
		 */
		request.setAttribute("vo", vo1);
		
		HttpSession session = request.getSession();
		session.setAttribute("vo", vo1);
		
		/*
		 * 흐름제어
		 * response : sendRedirect(), getWriter()-요청된 페이지의 주소에 전달, getWriter() - 요청된 페이지의 body에 전달
		 * request : RequestDispatcher.forward()
		 * 
		 * response.sendRedirect()는 요청된 페이지의 주소에 전달 하기 때문에 url을 ./~~~로 사용해야 함.
		 */
		
		session.setAttribute("val", "session의 값");
		
		request.getRequestDispatcher("/ElPage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
