package com.min.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.ScoreDto;

public class JSTL_Servlet extends HttpServlet {

	private static final long serialVersionUID = -1803737871371890657L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		List<ScoreDto> lists = new ArrayList<ScoreDto>();
		for (int i = 0; i < 10; i++) {
			ScoreDto d = new ScoreDto("피츄"+i, i*10, i*20, i*30, "카");
			lists.add(d);
		}
		
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/jstlPage.jsp").forward(req, resp);
	}
}
