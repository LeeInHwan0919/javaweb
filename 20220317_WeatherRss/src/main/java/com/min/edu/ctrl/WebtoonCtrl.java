package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebtoonCtrl extends HttpServlet {

	private static final long serialVersionUID = -209447667902746879L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8;");
		
		String url = "https://comic.naver.com/webtoon/detail?titleId=783054&no=89&weekday=thu";
//		String url = "https://comic.naver.com/webtoon/detail?titleId=775723&no=36&weekday=sat";
		Document doc = Jsoup.connect(url).timeout(3000).get();
//		System.out.println(doc.html());
//		Elements ele2 = doc.select("#sectionContWide");
		Elements ele = doc.select("#comic_view_area");
		Elements ele1 = ele.select("div>img");
//		System.out.println(ele1.size());
		
		List<Object> wList = new ArrayList<Object>();
		for(Element e:ele1) {
			System.out.println(e.attr("src"));
			wList.add(e);
		}
		System.out.println(wList);
		
		
		req.setAttribute("wList", wList);
		req.getRequestDispatcher("/webtoon_copy.jsp").forward(req, resp);
		
		
	}

}
