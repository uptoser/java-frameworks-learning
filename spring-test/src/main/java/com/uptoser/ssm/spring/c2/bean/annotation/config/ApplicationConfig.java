package com.uptoser.ssm.spring.c2.bean.annotation.config;

import com.uptoser.ssm.spring.c1.ioc.bean.lifecycle.BeanLifecycleJuiceMaker;
import com.uptoser.ssm.spring.c1.ioc.pojo.Source;
import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.impl.RoleServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/*
 * 注意：@ComponentScan代表进行扫描，默认是扫描当前包的路径，POJO的包名和它保持一致才能扫描
 *
 * ●如果采用多个@ComponentScan 去定义对应的包，
 * 但是每定义一个@ComponentScan,Spring 就会为所定义的类生成一个新的对象，
 * 也就是所配置的Bean将会生成多个实例，这往往不是我们的需要。
 *
 * ●对于已定义了basePackages和basePackageClasses的@ComponentScan,Spring会进行专门的区分，
 * 也就是说在同一个@ComponentScan 中即使重复定义相同的包或者存在其子包定义
 * ，也不会造成因同一个 Bean 的多次扫描，而导致一次配置生成多个对象。
 *
 * excludeFilters 支持多种类型的过滤，包括：
 *		ANNOTATION: 根据注解类型过滤，例如 Service.class。
 *		ASSIGNABLE_TYPE: 根据类或接口类型过滤。
 *		ASPECTJ: 使用AspectJ表达式进行过滤。
 *		REGEX: 使用正则表达式进行过滤。
 *		CUSTOM: 使用自定义的过滤器进行过滤。
 */
@ComponentScan(basePackageClasses = { Role.class, RoleServiceImpl.class }
		,basePackages = {"com.uptoser.ssm.spring.c2.bean"}
		,excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern="com.uptoser.ssm.spring.c2.di.annotation.config.AutowiredConfig")}
	)
/*引入XML配置：@ImportResource中配置的内容是一个数组，也就是可以配置多个XML配置文件*/
@ImportResource({"classpath:spring-dataSource.xml"})
/*有时候想要引入有多个类似于ApplicationConfig配置类。Spring也提供了注解@Import的方式注入这些配置类*/
@Import({DataSourceConfig.class})
public class ApplicationConfig {
	/**
	 * 定义了一个PropertySourcesPlaceholderConfigurer类的Bean，它的作用是为了让Spring能够解析属性占位符
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * Bean注解的配置项中包含4个配置项。
	 * ●name：是一个字符串数组，允许配置多个BeanName。
	 * ●autowire：标志是否是一个引用的Bean对象，默认值是Autowire.NO。
	 * ●initMethod：自定义初始化方法。
	 * ●destroyMethod：自定义销毁方法。
	 */
	@Bean(name="lifecycle", initMethod="init", destroyMethod="destroy")
	public BeanLifecycleJuiceMaker initJuiceMaker2() {
		BeanLifecycleJuiceMaker juiceMaker2 = new BeanLifecycleJuiceMaker();
		juiceMaker2.setBeverageShop("贡茶");
		Source source = new Source();
		source.setFruit("橙子");
		source.setSize("大杯");
		source.setSugar("少糖");
	     juiceMaker2.setSource(source);
		return juiceMaker2;
	}
}