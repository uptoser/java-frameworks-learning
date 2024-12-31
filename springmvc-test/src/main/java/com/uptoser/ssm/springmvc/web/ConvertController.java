package com.uptoser.ssm.springmvc.web;

import com.uptoser.ssm.springmvc.pojo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 在 Java类型转换之前，在Spring MVC中，为了应对HTTP请求，它还定义了HttpMessageConverter，
 * 它是一个总体的接口，通过它可以读入HTTP的请求内容
 *
 * HttpMessageConverter 是定义从 HTTP 接受请求信息和应答给用户的，实现它的类有很多种，
 * 用的比较多的有 MappingJackson2HttpMessageConverter，这是一个关于JSON消息的转换类
 * 注册MappingJackson2HttpMessageConverter后就可以使用ResponseBody注解，Spring MVC便会将应答请求转变为关于JSON的类型
 *
 * Spring Core 项目提供的 Converter 和GenericConverter，以及Spring Context包的Formatter可以进行更细节的数据转换
 */
@Controller
@RequestMapping("/convert")
public class ConvertController {

	/**
	 * RequestBody注解常用来处理Content-Type不是application/x-www-form-urlencoded编码的内容，例如application/json、application/xml等。
	 * RequestBody注解通过使用 HandlerAdapter 配置的 HttpMessageConverters 来解析 JSON 或XML数据，然后绑定到相应的Bean上。
	 *
	 * 当前台页面使用 GET 或 POST 方式提交数据时，数据编码格式由请求头的 ContentType指定。可以分为以下几种情况：
	 * application/x-www-form-urlencoded。 这种情况的数据@RequestParam、@ModelAttribute也可以处理，并且很方便，当然@RequestBody也能处理。
	 * multipart/form-data。 @RequestBody不能处理这种格式的数据。
	 * application/json、application/xml等格式的数据。 必须使用@RequestBody来处理。
	 *
	 * ResponseBody注解的作用是将controller的方法返回的对象，通过适当的转换器转换为指定的格式之后，
	 * 写入到response对象的body区（响应体中）
	 * 通常用来返回JSON数据或者是XML。
	 */
	@RequestMapping(value = "/role")
	@ResponseBody
	public Role getRole(@RequestBody Role role) {
		System.out.println(role);
		return role;
	}

	/**
	 * 测试字符串转对象转换器
	 * http://localhost:8080/springmvc_test_war/convert/updateRole?role=123-345-456
	 */
	@RequestMapping(value = "/updateRole")
	@ResponseBody
	public Map<String, Object> updateRole(Role role) {
		Map<String, Object> result = new HashMap<>();
		result.put("role",role);
		result.put("success", "true");
		result.put("msg", "更新成功");
		return result;
	}


//	@RequestMapping("/format")
//	public ModelAndView format(
//		//日期格式化
//		@RequestParam("date1") @DateTimeFormat(iso = ISO.DATE) Date date,
//		//金额格式化
//		@RequestParam("amount1") @NumberFormat(pattern = "#,###.##") Double amount) {
//		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("date", date);
//		mv.addObject("amount", amount);
//		return mv;
//	}
	
//	@RequestMapping("/formatPojo")
//	public ModelAndView formatPojo(FormatPojo pojo) {
//		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("date", pojo.getDate1());
//		mv.addObject("amount", pojo.getAmount1());
//		return mv;
//	}
}