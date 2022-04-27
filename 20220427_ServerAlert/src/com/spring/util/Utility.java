package com.spring.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Utility {

	public static void servlet_alert(HttpServletResponse response, String msg, String path) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('"+msg+"'); location.href='./"+path+"'</script>");
		out.flush();
	}
	
	
}
