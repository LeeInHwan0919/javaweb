package com.min.edu.comm.filter;

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
 * import javax.servlet.filter;를 사용하게 도면 두개가 선택으로 뜨게 됩니다 
 * 1)외부의 was인 tomcat9.0에 있는 라이브러리
 * 2)Maven 에 있는 servlet-api에 있는 라이브러리
 * pom.xml의 scope가 Provide로 되어 있기 때문에 시스템을 maven사용 가능도록 만들었다 
 * 현재는 
 */
public class ClientAccessFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientAccessFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//요청정보를 출력 
		HttpServletRequest req = (HttpServletRequest)request;
		
		//request의 객체 정보 : 요청주소(remoteAddr), 요청param(queryString), 
		//request의  Header정보 :User-Agent:요청된 사용자의 애플리케이션 타입, 운영체제,브라우저 정보 등 식별
		//										 Referer : 이전 페이지의 주소 A->B 애널리틱스 분석
		//										 Expires , Cache-Control,Pragma: 캐쉬 정보 
		
		//톰캣설치 경로 /bin/catalina.bat의"set JAVA_OPTS"라는 키워드로 검색하면 두 개가 나오는데, 
		//둘다 -Djava.net.preferIPv4Stack=ture를 추가한다. 
		//1) 접을 시도하는 주소를 출력 
		String remoteAddr = req.getRemoteAddr();//기본이 IPv6로 출력 됨 
		//2) URL /URI 
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
//		System.out.println(uri);
//		System.out.println(url);
		
		
		
		//3)쿼리 스트링 주소를 통해 전달 되는 키 = 값 
//		String quString = req.getQueryString();
		
//		System.out.println(quString);
//		quString = (quString ==null || quString=="")?"":quString;
		
		String quString= StringUtils.defaultIfEmpty(req.getQueryString(), "");
		
		//4)이전 요청 페이지 
		String referer = StringUtils.defaultString(req.getHeader("Referer"), "-");
		//5)요청 정보(운영체제, 바라우저)
		String	agent =StringUtils.defaultString(req.getHeader("User-Agent"), "-");
		
		String fullUrl = url;
		fullUrl +=StringUtils.isNotEmpty(quString)?"?"+quString:quString;
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(fullUrl).append(":").append(referer).append(":").append(agent);
		
		logger.info("[Logger Filter]"+sb.toString());
		
		chain.doFilter(request, response);
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("☜(ﾟヮﾟ☜)AccessFilter 들어 왔다");
	}
	@Override
	public void destroy() {
		logger.info("(☞ﾟヮﾟ)☞AccessFilter 나왔다");
	}

}
