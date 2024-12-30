package com.uptoser.ssm.ssm.config;

import com.uptoser.ssm.ssm.exception.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
/*
当XML配置文件加入了元素<mvc:annotation-driven>或者使用Java配置使用注解@EnableWebMvc时，
系统就会初始化拦截器ConversionServiceExposingInterceptor,它是个一开始就被 Spring MVC 系统默认加载的拦截器
 */
@EnableWebMvc
@ComponentScan("com.uptoser")
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(40000000);
		return multipartResolver;
	}

	@Bean
	public MultipartResolver multipartResolver2() {
		return new StandardServletMultipartResolver();
	}

	@Override // 静态资源？
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override // 静态资源
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径。
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
	}

	@Override // 添加拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DemoInterceptor());
	}

	@Override // 添加页面跳转
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("uploadPage").setViewName("upload");
		registry.addRedirectViewController("teset111", "aaa111");
	}

}
