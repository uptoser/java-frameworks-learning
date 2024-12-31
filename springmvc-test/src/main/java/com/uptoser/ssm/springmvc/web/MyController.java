package com.uptoser.ssm.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 于使用了@Controller 注解，因此不需要再在配置文件中使用 XML 描述 Bean。
 * ＜context：component-scan base-package=＂org.fkit.controller＂/＞
 * 指定需要Spring扫描org.fkit.controller包及其子包下面的所有java文件
 *
 * ＜mvc：annotation-driven＞ 会 自 动 注 册 RequestMappingHandlerMapping 与 Request MappingHandlerAdapter两个Bean，
 * 这是Spring MVC为@Controllers分发请求所必需的，并提供了数据绑定支持、@NumberFormatannotation支持、@DateTimeFormat支持
 * 、@Valid支持、读写 XML 的支持（JAXB）和读写 JSON 的支持（默认为 Jackson）等功能。本例处理 Ajax请求时，就使用到了对JSON的支持功能
 *
 * 当在springmvc-config.xml中配置＜mvc：default-servlet-handler/＞后，
 * 会在Spring MVC上下文中定义一个org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler，
 * 它就像一个检查员，对进入DispatcherServlet的URL进行筛查
 *
 * 使用@RequestMapping注解可指定以下的属性：
 * 1.value属性 用来处理请求地址映射
 * 2.method属性 该属性用来指示该方法仅处理哪些HTTP请求方式。
 * 3.consumes属性 该属性指定处理请求的提交内容类型（Content-Type）
 * 4.produces属性 该属性指定返回的内容类型，返回的内容类型必须是 request 请求头（Accept）中所包含的类型。
 * 5.params属性 该属性指定request中必须包含某些参数值时，才让该方法处理。
 * 6.headers属性 该属性指定request中必须包含某些参数值时，才让该方法处理。
 *
 */
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
