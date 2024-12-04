package com.uptoser.ssm.spring.c3.aop.multi.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class Aspect2 {
	
	@Pointcut("execution(* com.uptoser.ssm.spring.c3.aop.multi.bean.impl.MultiBeanImpl.testMulti(..))")
	public void print() {
	}
	
	@Before("print()")
	public void before() {
		System.out.println("before 2 ......");
	}
	
	@After("print()")
	public void after() {
		System.out.println("after 2 ......");
	}
	
	@AfterThrowing("print()")
	public void afterThrowing() {
		System.out.println("afterThrowing 2 ......");
	}
	
	@AfterReturning("print()") 
	public void afterReturning() {
		System.out.println("afterReturning 2 ......");
	}
}