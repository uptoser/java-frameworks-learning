package com.uptoser.ssm.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MyController {

	/**
	 * 使用 http://localhost:8080/springmvc_test_war/index.do 来访问第一个页面
	 * 只响应GET请求，如果没有配置method，那么所有的请求都会响应
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	/**
	 * RequestParam还给了两个有用的配置项。
	 * ●required是一个布尔值（boolean），默认为true，也就是不允许参数为空，如果要允许为空，则配置它为false。
	 * ●defaultValue 的默认值为"\n\t\t\n\t\t\n\uE000\uE001\uE002\n\t\t\t\t\n"，可以通过配置修改它为你想要的内容。
	 */
	@RequestMapping(value = "index2", method = RequestMethod.GET)
	public ModelAndView index2(@RequestParam(value = "id") Long id) {
		System.out.println("id = "+id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	/**
	 * 通过SessionAttributes去从Session中获取对应的数据
	 */
	@RequestMapping(value = "index3", method = RequestMethod.GET)
	public ModelAndView index3(@SessionAttribute("userName") String userName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	@RequestMapping(value = "params", method = RequestMethod.GET)
	public String params() {
		return "params";
	}


}
