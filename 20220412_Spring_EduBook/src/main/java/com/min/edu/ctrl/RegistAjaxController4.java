package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.vo.JobsVO;

@RestController
public class RegistAjaxController4 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * Spring 3.x 버전에서는 일반 @Controller에 특정 @RequestMapping에 추가로 @ResponseBody를 통해서
	 * 해당 Mapping을 처리를 하는 응답을 할 수 있도록 해준다(Response: 값).
	 * servlet-context.xml에 <mvc:annotation-driven/>을 설정하여 DispatcherServlet이 값을 전달 할 수 있도록 해줌 
	 */
	
	/*
	 * ■ produces = html/text; charset=UTF-8; Map<String, Boolean> -> dataType : ->
	 * 406코드 발생(Map은 jackson-bind에 의해서 반드시 JSON 객체 이어야 함 근데 produces의 지원되지 않는 형태인
	 * text로 만들기 때문에 서버에서 406 코드를 발생) => 해결 1) produce를 지운다 : 전송데이터는 JSON(String)이다.
	 * 2) produce를 Jackson에 맞는 JSON타입으로 선언한다 : 전송데이터는 JSON(String)이다.
	 */
	
	@RequestMapping(value="/duplicateAjax4.do", method=RequestMethod.POST, produces = "application/json; charset=UTF-8;")
	public Map<String, Object> duplicateAjax(String chkId){
		logger.info("RegistAjaxController4 duplicateAjax post 파라미터 값 id:{}",chkId);
		Map<String, Object> map = new HashMap<String, Object>();
		//service 처리
		
		/*
		 * JobsVO vo = new JobsVO(); vo.setJob_id("Dev"); vo.setJob_title("개발자");
		 * map.put("isc", vo);
		 */
		map.put("isc", true);
		return map;
//		return "{\"isc\":\"true\"}";
	}
	
}
