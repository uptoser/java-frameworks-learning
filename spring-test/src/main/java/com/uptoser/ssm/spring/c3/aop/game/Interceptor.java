package com.uptoser.ssm.spring.c3.aop.game;

public interface Interceptor {
	
	public void before(Object obj);

    public void after(Object obj);

    public void afterReturning(Object obj);

    public void afterThrowing(Object obj);
}
