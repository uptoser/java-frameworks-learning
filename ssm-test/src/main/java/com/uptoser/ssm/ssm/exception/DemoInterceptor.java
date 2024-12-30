package com.uptoser.ssm.ssm.exception;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器必须实现HandlerInterceptor接口，而Spring也为增强功能而开发了多个拦截器。
 * Spring MVC提供的公共拦截器HandlerInterceptorAdapter
 * 当只想实现3个拦截器方法中的一到两个时，那么只要继承它，根据需要覆盖掉原有的方法就可以了
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入拦截器了");
		return true;
	}

}
