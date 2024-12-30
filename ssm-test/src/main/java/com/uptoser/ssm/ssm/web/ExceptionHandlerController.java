package com.uptoser.ssm.ssm.web;

import com.uptoser.ssm.ssm.exception.Test1Exception;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @ControllerAdvice，主要作用于类，用以标识全局性的控制器的拦截器，它将应用于对应的控制器。
 * @InitBinder，是一个允许构建POJO参数的方法，允许在构造控制器参数的时候，加入一定的自定义控制。
 * @ExceptionHandler，通过它可以注册一个控制器异常，使用当控制器发生注册异常时，就会跳转到该方法上。
 * @ModelAttribute，是一种针对于数据模型的注解，它先于控制器方法运行，当标注方法返回对象时，它会保存到数据模型中。
 */
@ControllerAdvice
public class ExceptionHandlerController {
	
	/**
	 * 这个只能处理一个controller里的异常信息
	 * 如果想要处理所有处理器的异常信息就要用控制器通知
	 * @return
	 */
	@ExceptionHandler(Test1Exception.class)
	public Map<String,Object> testException(Exception e) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", "test1的异常信息");
		return map;
	}
	@ModelAttribute//此注解将键值添加到全局，所有注解的@RequestMapping的方法都可以获得此键值
	public void addAttributes(Model model) {
		model.addAttribute("msg","额外的信息s");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDateBinder) {
//		webDateBinder.registerCustomEditor(Date.class,new webDateBinder.registerCustomEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
		//此处演示忽略request参数的id,更多关于WebDataBinder的配置，请参考API
		webDateBinder.setDisallowedFields("id");
	}

}
