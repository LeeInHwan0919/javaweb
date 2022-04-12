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


public class ClientAccessFilter implements Filter {
   
   private static final Logger logger = LoggerFactory.getLogger(ClientAccessFilter.class);

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {

      HttpServletRequest req = (HttpServletRequest)request;
      String url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "-");
      String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
      
      String fullUrl = url;
         fullUrl += StringUtils.isNotEmpty(queryString)?"?"+queryString:queryString;
      
       logger.info("[Filter] : {}", fullUrl);
      chain.doFilter(request, response);
   }

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      logger.info("============실행==============");
   }
   @Override
   public void destroy() {
      logger.info("=============만료============");
   }

}