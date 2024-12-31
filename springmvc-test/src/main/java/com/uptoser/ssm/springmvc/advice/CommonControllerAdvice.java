package com.uptoser.ssm.springmvc.advice;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 与Spring AOP一样，Spring MVC也能够给控制器加入通知，它主要涉及4个注解：
 * ●@ControllerAdvice，主要作用于类，用以标识全局性的控制器的拦截器，它将应用于对应的控制器。
 * ●@InitBinder，是一个允许构建POJO参数的方法，允许在构造控制器参数的时候，加入一定的自定义控制。
 * ●@ExceptionHandler，通过它可以注册一个控制器异常，使用当控制器发生注册异常时，就会跳转到该方法上。
 * ●@ModelAttribute，是一种针对于数据模型的注解，它先于控制器方法运行，当标注方法返回对象时，它会保存到数据模型中。
 *
 * 注解@ControllerAdvice已经标记了@Component，所以标注它，Spring MVC在扫描的时候就会将其放置到IoC容器中
 */
@ControllerAdvice(basePackages={"com.uptoser.ssm.springmvc.advice"})//标识控制器通知，并且指定对应的包
public class CommonControllerAdvice {

    /**
     * 通过注解@InitBinder可以获得一个参数——WebDataBinder，它是一个可以指定POJO参数属性转换的数据绑定
     * 这里使用了关于日期的 CustomDateEditor，并且指定格式为yyyy-MM-dd，它还允许自定义验证器
     * 这样被拦截的控制器关于日期对象的参数，都会被它处理，就不需要我们自己制定 Formatter了
     */
	//定义HTTP对应参数处理规则
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//针对日期类型的格式化，其中CustomDateEditor是客户自定义编辑器
         //它的boolean参数表示是否允许为空
		binder.registerCustomEditor(Date.class,
             new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}

    //处理数据模型，如果返回对象，则该对象会保存在数据模型中
	@ModelAttribute
	public void populateModel(Model model) {
		model.addAttribute("projectName", "Spring MVC");
	}

	//异常处理，使得被拦截的控制器方法发生异常时，都能用相同的视图响应
	@ExceptionHandler(Exception.class)
	public String exception() {
		return "exception";
	}

}
