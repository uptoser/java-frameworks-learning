package com.uptoser.ssm.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MyController {

	/**
	 * 使用 http://localhost:8080/springmvc_test_war/index.do 来访问第一个页面
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

}
