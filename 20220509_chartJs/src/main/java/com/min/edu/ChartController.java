package com.min.edu;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.IGoodsService;
import com.min.edu.vo.GraphVo;

@Controller
public class ChartController {
	
	@Autowired
	private IGoodsService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ChartController.class);
	
	@RequestMapping(value = "/chartMain.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("ChartController 메인페이지 이동");
		return "chartMain";
	}
	
	@RequestMapping(value="/chartData.do", method=RequestMethod.GET)
	public String chartData() {
		logger.info("ChartController 데이터 바인딩된 차트로 이동");
		return "chartData";
	}
	
	@RequestMapping(value="/countGoods.do",method = RequestMethod.GET)
	public @ResponseBody List<GraphVo> countGoods(Model model){
		logger.info("ChartController countGoods");
		List<GraphVo> goods = service.countGoods();
		model.addAttribute("goods", goods);
		return goods;
	}
}
