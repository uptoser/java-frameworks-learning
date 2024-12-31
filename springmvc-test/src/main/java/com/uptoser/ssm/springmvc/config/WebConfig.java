package com.uptoser.ssm.springmvc.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.uptoser.ssm.springmvc.converter.StringToRoleConverter;
import com.uptoser.ssm.springmvc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.StandardCharsets;

/**
 * 使用了＜mvc：annotation-driven/＞标签，该标签可以简化Spring MVC的相关配置，
 * 自动注册RequestMappingHandlerMapping与RequestMappingHandlerAdapter两个Bean，
 * 这是Spring MVC为@Controllers注解分发请求所必需的。
 * <p>
 * 当XML配置了<mvc:annotation-driven>或者使用Java配置使用注解@EnableWebMvc时，
 * 系统就会初始化拦截器ConversionServiceExposingInterceptor,它是个一开始就被 Spring MVC 系统默认加载的拦截器
 * <p>
 * 在XML配置了<mvc:annotation-driven>，或者Java配置的注解上加入@EnableWebMvc的时候，
 * Spring IoC容器会自定义生成一个关于转换器和格式化器的类实例——FormattingConversionServiceFactoryBean
 * <p>
 * 在Spring 5中，WebMvcConfigurerAdapter已经被弃用（@Deprecated）。这是因为Spring引入了新的方法来配置Spring MVC。
 * 你可以直接实现 WebMvcConfigurer 接口，它提供了更多的默认方法，这样你只需要重写你需要的那部分功能即可
 */
@EnableWebMvc //启用Spring Web MVC
@ComponentScan("com.*") //定义扫描的包，加载控制器
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 创建视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        //InternalResourceView是一个逻辑视图，对于逻辑视图而言它需要一个视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
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
        registry.addViewController("validatePage").setViewName("validate");
        registry.addViewController("formPage").setViewName("form");
        registry.addViewController("paramsPage").setViewName("params");
        registry.addViewController("formatterPage").setViewName("formatter");
//		registry.addRedirectViewController("teset111", "aaa111");
    }

    /**
     * 添加自定义数据格式化器/转换器
     * 相当于conversionService
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToRoleConverter());
    }

    /**
     * 配置Bean覆盖configureMessageConverters使用fastjson
     */
//    @Bean
    public HttpMessageConverter<?> fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(config);
        fastConverter.setDefaultCharset(StandardCharsets.UTF_8);
        return fastConverter;
    }

    /**
     * 配置消息转换器
     * 添加fastjson的HttpMessageConverter
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(fastJsonHttpMessageConverter());
//    }
}
