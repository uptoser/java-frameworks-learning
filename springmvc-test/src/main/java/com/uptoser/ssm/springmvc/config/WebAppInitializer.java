package com.uptoser.ssm.springmvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * 使用该类去代替 WEB XML 的配置
 * Servlet3.0之后的版本允许动态加载 Servlet，只是按照规范需要实现ServletContainerInitializer接口而已
 * Spring MVC框架在自己的包内实现了一个类，它就是 SpringServletContainerInitializer
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	/**
	 * SpringIoC容器配置
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//可以返回Spring的Java配置文件数组
		return new Class<?>[] { SpringConfig.class };
	}
	/**
	 * DispatcherServlet的URI映射关系配置
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		//可以返回Spring的Java配置文件数组
		return new Class<?>[] { WebConfig.class };
	}
	/**
	 * DispatcherServlet拦截内容
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * servlet文件上传配置
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("C:\\temp",4000001,400000000,0));
		super.customizeRegistration(registration);
	}

	/**
	 * EncodingFilter
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("utf-8");
		return new Filter[] { characterEncodingFilter };
	}
	
	

}
