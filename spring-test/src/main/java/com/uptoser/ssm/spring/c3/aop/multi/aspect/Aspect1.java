package com.uptoser.ssm.spring.c3.aop.multi.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * 通过@Order(1)只是一种实现多切面排序的方法之一，而事实是还有其他的方法，
 * 比如也可以让切面实现Ordered（org.springframework.core.Ordered）接口，它定义了一个getOrder方法。
 */
@Aspect
@Order(1)
public class Aspect1 {
	@Pointcut("execution(* com.uptoser.ssm.spring.c3.aop.multi.bean.impl.MultiBeanImpl.testMulti(..))")
	public void print() {
	}
	
	@Before("print()")
	public void before() {
		System.out.println("before 1 ......");
	}
	
	@After("print()")
	public void after() {
		System.out.println("after 1 ......");
	}
	
	@AfterThrowing("print()")
	public void afterThrowing() {
		System.out.println("afterThrowing 1 ......");
	}
	
	@AfterReturning("print()") 
	public void afterReturning() {
		System.out.println("afterReturning 1 ......");
	}
}
