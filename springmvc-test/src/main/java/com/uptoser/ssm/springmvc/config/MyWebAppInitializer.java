package com.uptoser.ssm.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 使用该类去代替 WEB.XML 的配置
 * Servlet3.0之后的版本允许动态加载 Servlet，只是按照规范需要实现ServletContainerInitializer接口
 * Spring MVC框架在自己的包内实现了一个类，它就是 SpringServletContainerInitializer，
 * 它实现了ServletContainerInitializer接口，这样就能够通过它去加载开发者提供的MyWebAppInitializer了
 *
 * @HandlesTypes(WebApplicationInitializer.class)
 * public class SpringServletContainerInitializer implements ServletContainerInitializer {
 *   @Override
 *   public void onStartup(Set<Class<?>> clazz, ServletContext ctx) throws ServletException {
 *     // 这里可以注册 Servlets、Filters 和 Listeners
 *     ctx.addListener(WebApplicationInitializer.class);
 *     ctx.addServlet("myServlet", MyServlet.class).addMapping("/myServlet");
 *   }
 * }
 *
 * MyWebAppInitializer 也实现了 WebApplicationInitializer 接口。
 * ContextLoader 和DispatcherServlet的初始化器都是抽象类，通过它们就能初始化Spring IoC上下文和映射关系上下文，
 * 这就是只要继承AbstractAnnotationConfigDispatcherServletInitializer类就完成了
 * DispatcherServlet映射关系和Spring IoC容器的初始化工作的原因
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	/**
	 * SpringIoC容器配置
	 * 获取Spring IoC容器的Java配置类，用以装载各类Spring Bean
	 * 如果getRootConfigClasses方法返回为空，就不加载自定义的Bean到Spring IoC容器中
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//可以返回Spring的Java配置文件数组
		return new Class<?>[] { SpringConfig.class };
	}
	/**
	 * DispatcherServlet的URI映射关系配置
	 * 获取各类Spring MVC的URI和控制器的配置关系类，用以生成Web请求的上下文
	 * getServletConfigClasses加载了WebConfig，则它就是一个URI和控制器的映射关系类
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		//可以返回Spring的Java配置文件数组
		return new Class<?>[] { WebConfig.class };
	}
	/**
	 * 定义DispatcherServlet拦截的请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.do" };
	}

	/**
	 * servlet文件上传配置
	 */
//	@Override
//	protected void customizeRegistration(Dynamic registration) {
//		registration.setMultipartConfig(new MultipartConfigElement("C:\\temp",4000001,400000000,0));
//		super.customizeRegistration(registration);
//	}

	/**
	 * EncodingFilter
	 */
//	@Override
//	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//		characterEncodingFilter.setEncoding("utf-8");
//		return new Filter[] { characterEncodingFilter };
//	}
	
	

}
