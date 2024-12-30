package com.uptoser.ssm.springmvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 当XML配置文件加入了元素<mvc:annotation-driven>或者使用Java配置使用注解@EnableWebMvc时，
 * 系统就会初始化拦截器ConversionServiceExposingInterceptor，
 * 它是个一开始就被 Spring MVC 系统默认加载的拦截器，它的主要作用是根据配置在控制器上的注解来完成对应的功能
 *
 * 拦截器必须实现HandlerInterceptor接口，而Spring也为增强功能而开发了多个拦截器。
 * Spring MVC提供的公共拦截器HandlerInterceptorAdapter
 * 当只想实现3个拦截器方法中的一到两个时，那么只要继承它，根据需要覆盖掉原有的方法就可以了
 *
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 在处理器之前执行的前置方法，这样Spring MVC可以在进入处理器前处理一些方法了。
	 * 注意，它将返回一个boolean值，会影响到后面Spring MVC的流程。
	 * 当前置方法:
	 *   返回true -> 处理器(Handler) -> 后置方法(postHandle) -> 视图解析和渲染视图 -> 完成方法(afterCompletion)
	 *   返回false -> 跳过上面全部
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		System.out.println("进入拦截器了");
		return true;
	}

	/**
	 * 在处理器之后执行的后置方法，处理器的逻辑完成后运行它
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 无论是否产生异常都会在渲染视图后执行的方法。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
