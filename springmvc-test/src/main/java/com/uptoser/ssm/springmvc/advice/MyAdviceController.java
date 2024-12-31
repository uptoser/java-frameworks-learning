package com.uptoser.ssm.springmvc.advice;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制位于控制器通知所扫描的包（com.*.advice）下，所以它将被通知所拦截
 *
 * 控制器（注解@Controller）也可以使用@InitBinder、@ExceptionHandler、@ModelAttribute。
 * 注意，它只对于当前控制器有效
 */
@Controller
@RequestMapping("/advice")
public class MyAdviceController {
	/***
	 * http://localhost:8080/springmvc_test_war/advice/test?date=2020-12-11&amount=123,456.78
	 * @param date 日期，在@initBinder 绑定的方法有注册格式
	 * @param model 数据模型，@ModelAttribute方法会先于请求方法运行
	 * @return map
	 */
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> testAdvice(Date date, @NumberFormat(pattern = "##,###.00") BigDecimal amount, Model model) {
		System.out.println(date);
		Map<String, Object> map = new HashMap<String, Object>();
		//由于@ModelAttribute注解的通知会在控制器方法前运行，所以这样也会取到数据
		map.put("project_name", model.asMap().get("projectName"));
		map.put("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
		map.put("amount", amount);
		return map;
	}
	
	/**
	 * 测试异常.
	 */
	@RequestMapping("/exception")
	public void exception() {
		throw new RuntimeException("测试异常跳转");
	}
}
