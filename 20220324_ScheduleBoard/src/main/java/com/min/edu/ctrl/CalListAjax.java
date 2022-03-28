package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class CalListAjax extends HttpServlet {
/**
 * 달력의 숫자에 마우스가 오버됐을때 해당 날의 게시글의 전체 갯수를 표현한다
 * Ajax를 통해서 결과(글갯수)를 반환하여 View에서 CSS를 통해서 해당 글자 위해서 표현한다
 */
	private static final long serialVersionUID = 1836152498942521990L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		JSONObject obj = null;
		PrintWriter out = resp.getWriter();
		out.print(out);
	}
}
