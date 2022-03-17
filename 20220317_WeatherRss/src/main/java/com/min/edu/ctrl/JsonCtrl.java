package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsonCtrl extends HttpServlet {

	private static final long serialVersionUID = -9035688446191277861L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8;");
		
		String url = "https://simplehtmldom.sourceforge.io/";
		//1접속
		Document doc = Jsoup.connect(url).get();
//		Document doc = Jsoup.connect(url).timeout(5000).get();
//		System.out.println(doc);//내부의 tag+text가져옴
//		System.out.println(doc.html());//내부의 text만 가져옴
		
		Elements ele1 = doc.select("#content");
		Elements ele2 = doc.select(".comment");
		Elements ele3 = doc.select("div");
		
//		System.out.println(ele2.size());
		for(Element el:ele2) {
			System.out.println(el.text());
		}
		
	}
}
