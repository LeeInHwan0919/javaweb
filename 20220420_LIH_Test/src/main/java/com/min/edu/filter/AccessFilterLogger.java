package com.min.edu.filter;

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

public class AccessFilterLogger implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(AccessFilterLogger.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("==========@filter@ Filter 작동 ===========");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String url = (String)StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "URL 없음.");
		String queryString = StringUtils.defaultString(req.getQueryString(), "");
		
		logger.info("===============@filter@ URL : {} ================", url);
		logger.info("===========@filter@ QueryString : {} =============", queryString);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("==========@filter@ Filter 작동 끝 ===========");
	}

}
