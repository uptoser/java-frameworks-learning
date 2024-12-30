package com.uptoser.ssm.springmvc.config;

import com.uptoser.ssm.springmvc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
当XML配置文件加入了元素<mvc:annotation-driven>或者使用Java配置使用注解@EnableWebMvc时，
系统就会初始化拦截器ConversionServiceExposingInterceptor,它是个一开始就被 Spring MVC 系统默认加载的拦截器
 */
@EnableWebMvc //启用Spring Web MVC
@ComponentScan("com.*") //定义扫描的包，加载控制器
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	/**
	 * 创建视图解析器
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/**
	 * CommonsMultipartResolver：依赖于Apache下的jakarta CommonFileUpload项目解析Multipart请求，
	 * 可以在Spring的各个版本中使用，只是它要依赖于第三方包才得以实现
	 * 注意，"multipartResolver"是Spring约定好的Bean name不可以修改
	 */
//	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setMaxUploadSize(40000000);
//		return multipartResolver;
//	}

	/**
	 * StandardServletMultipartResolver：是Spring 3.1版本后的产物，
	 * 它依赖于Servlet 3.0或者更高版本的实现，它不用依赖第三方包
	 * 注意，"multipartResolver"是Spring约定好的Bean name不可以修改
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

//	@Override // 静态资源？
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}

//	@Override // 静态资源
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		// addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径。
//		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
//	}

	/**
	 * 多个拦截器会以一个怎么样的顺序执行呢？
	 * ......
	 * preHandle1
	 * preHandle2
	 * preHandle3
	 * ......控制器逻辑日志......
	 * postHandle3
	 * postHandle2
	 * postHandle1
	 * ......
	 * afterCompletion3
	 * afterCompletion2
	 * afterCompletion1
	 */
	@Override // 添加拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DemoInterceptor());
	}

	@Override // 添加页面跳转
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("uploadPage").setViewName("upload");
		registry.addViewController("validate.do").setViewName("validate");
//		registry.addRedirectViewController("teset111", "aaa111");
	}

}
