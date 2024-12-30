package com.uptoser.ssm.springmvc.web;

import java.util.List;

import javax.validation.Valid;

import com.uptoser.ssm.springmvc.pojo.Transaction;
import com.uptoser.ssm.springmvc.validator.TransactionValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/validate")
public class ValidateController {

	/**
	 * InitBinder 是 Spring MVC 中的一个注解，用于标识初始化数据绑定器的方法。
	 * 在处理请求时，Spring MVC 使用数据绑定器将请求参数绑定到控制器方法的参数或模型属性
	 */
	@InitBinder
	public void initBinder(DataBinder binder) {
		// 数据绑定器加入验证器
		binder.setValidator(new TransactionValidator());
	}

	@RequestMapping("/annotation")
	public ModelAndView annotationValidate(@Valid Transaction trans, Errors errors) {
		// 是否存在错误
		if (errors.hasErrors()) {
			// 获取错误信息
			List<FieldError> errorList = errors.getFieldErrors();
			for (FieldError error : errorList) {
				// 打印字段错误信息
				System.err.println("fied :" + error.getField() + "\t" + "msg:" + error.getDefaultMessage());
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}



	@RequestMapping("/validator")
	public ModelAndView validator(@Valid Transaction trans, Errors errors) {
		// 是否存在错误
		if (errors.hasErrors()) {
			// 获取错误信息
			List<FieldError> errorList = errors.getFieldErrors();
			for (FieldError error : errorList) {
				// 打印字段错误信息
				System.err.println("fied :" + error.getField() + "\t" + "msg:" + error.getDefaultMessage());
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
