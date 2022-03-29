package com.min.edu.mapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 기본 모든 클래스가 HttpServlet을 extends해야지만 request/ response를 처리 할 수 있었음
 * 하지만 request/response 처리 할 수 있는 interface를 구성해야 자식 클래스에 implements
 * handle의 기능은 request / response를 처리한 후 최종 이동 화면의 이름만을 String으로 반환
 */
public interface Handler {
  public String handle(HttpServletRequest request, HttpServletResponse response);
}
