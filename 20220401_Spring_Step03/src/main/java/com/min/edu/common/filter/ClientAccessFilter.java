package com.min.edu.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
 *  import javax.servlet.Filter; 를 사용하게 되면 두개가 선택으로 뜨게 됩니다.
 *   1) 외부의 WAS인 tomcat9.0에 있는 라이브러리 - 선택된것 
 *   2) Maven에 있는 servlet-api에 있는 라이브러리
 *   pom.xml의 scope가 Provide로 되어 있기 때문에 시스템을 maven을 사용가능하도록 만들었다.
 *    현재는 외부의 WAS를 사용하고 있다 따라서 tomcat9.0의 라이브러리를 선택
 */
public class ClientAccessFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(ClientAccessFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 요청 정보를 출력
		HttpServletRequest req = (HttpServletRequest)request;
		
		// request의 객체 정보 : 요청 주소(remoteAddr), 요청 param(queryString),
		// request의 Header 정보 : User-Agent : 요청된 사용자의 애플리케이션 타입, 운영체계, 브라우저 정보 등 식별
		//                       Referer : 이전 페이지의 주소 A->B 애널리틱스 분석
		//						 Expires, Cache-Control, Pragma : 캐쉬 정보
		//1) 접근을 시도하는 주소를 출력
		String remoteAddr = request.getRemoteAddr();
//		System.out.println(remoteAddr);
		
//		2)URI/ URL   (URL이 더 큰범위)
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
//		System.out.println("uri : " +uri);
//		System.out.println("url : " +url);
		
		// 3) 쿼리 스트링 : 주소를 통해 전달 되는 키=값
//		String queryString = req.getQueryString();
//		System.out.println(queryString);
//		queryString = (queryString == null || queryString =="")?"":queryString;
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");

		// 4) 이전 요청 페이지
		String referer = StringUtils.defaultString(req.getHeader("Referer"),"-");
		
		// 5) 요청 정보(운영체제, 브라우저)
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"),"-");
		
		String fullUrl = url;
		fullUrl += StringUtils.isNotEmpty(queryString)?"?"+queryString:queryString;
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(fullUrl).append(":").append(referer).append(":").append(agent);
		
		logger.info("[Logger Filter]" + sb.toString());
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("☜(ﾟヮﾟ☜) AccessFilter 들어 왔다.");
	}

	@Override
	public void destroy() {
		logger.info("(☞ﾟヮﾟ)☞ AccessFilter 나갔다.");
	}

}
