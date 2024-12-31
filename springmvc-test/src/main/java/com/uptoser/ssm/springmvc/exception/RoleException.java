package com.uptoser.ssm.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * ResponseStatus注解是处理异常最简单的方式，其可以修饰一个类或者一个方法，当修饰一个类的时候，通常修饰的是一个异常类
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "找不到角色信息异常！！")//新增Spring MVC的异常映射，code代表异常映射码，而reason则代表异常原因
public class RoleException extends RuntimeException  {
	
	private static final long serialVersionUID = 5040949196309781680L;
}