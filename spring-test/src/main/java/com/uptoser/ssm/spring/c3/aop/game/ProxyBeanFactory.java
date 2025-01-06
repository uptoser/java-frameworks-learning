package com.uptoser.ssm.spring.c3.aop.game;

public class ProxyBeanFactory {
	public static <T> T getBean(T obj, Interceptor interceptor) {
        return (T) ProxyBeanUtil.getBean(obj, interceptor);
    }
}
