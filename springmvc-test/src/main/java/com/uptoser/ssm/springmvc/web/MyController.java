package com.uptoser.ssm.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
	public ModelAndView index2(@RequestParam(value = "id",required = false,defaultValue = "111") Long id) {
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

	/**
	 * 实现重定向功能
	 */
	@RequestMapping(value = "redirect", method = RequestMethod.GET)
	public String redirect(Model model) {
		model.addAttribute("key", 123);
		return "redirect:./paramsPage";
	}

	/**
	 * 实现重定向功能
	 * 这里的Model代表的是一个数据模型，你可以给它附上对应的数据模型，然后通过返回字符串来实现重定向的功能
	 *
	 * 在控制器的方法中，可以把ModelAndView、Model、ModelMap作为参数。
	 * 在Spring MVC运行的时候，会自动初始化它们，因此可以选择ModelMap或者Model作为数据模型
	 */
	@RequestMapping(value = "redirect2", method = RequestMethod.GET)
	public String redirect2(Model model) {
		//插入角色后，会回填角色编号
		//绑定重定向数据模型
		model.addAttribute("roleName", 123);
		model.addAttribute("note", 123);
		model.addAttribute("id", 123);
		return "redirect:./showRoleJsonInfo.do";
	}






}
