package com.uptoser.ssm.springmvc.web;

import com.uptoser.ssm.spring.exception.Test1Exception;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

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
		//此处演示忽略request参数的id,更多关于WebDataBinder的配置，请参考API
		webDateBinder.setDisallowedFields("id");
	}

}
