package com.uptoser.ssm.spring.c1.ioc.bean.lifecycle;

import com.uptoser.ssm.spring.c1.ioc.pojo.Source;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring IoC容器对Bean的管理还是比较复杂的
 * 生命周期的步骤:
 * ●如果Bean实现了接口BeanNameAware的setBeanName方法，那么它就会调用这个方法。
 * ●如果Bean实现了接口BeanFactoryAware的setBeanFactory方法，那么它就会调用这个方法。
 * ●如果 Bean 实现了接口 ApplicationContextAware 的 setApplicationContext 方法，且Spring IoC容器也必须是一个ApplicationContext接口的实现类，那么才会调用这个方法，否则是不调用的。
 * ●如果Bean实现了接口BeanPostProcessor的postProcessBeforeInitialization方法，那么它就会调用这个方法。
 * ●如果Bean实现了接口BeanFactoryPostProcessor的afterPropertiesSet方法，那么它就会调用这个方法。
 * ●如果Bean自定义了初始化方法，它就会调用已定义的初始化方法。
 * ●如果Bean实现了接口BeanPostProcessor的postProcessAfterInitialization方法，完成了这些调用，这个时候Bean就完成了初始化，那么Bean就生存在Spring IoC的容器中了，使用者就可以从中获取Bean的服务。
 * 当服务器正常关闭，或者遇到其他关闭Spring IoC容器的事件，它就会调用对应的方法完成Bean的销毁，其步骤如下：
 * ●如果Bean实现了接口DisposableBean的destroy方法，那么就会调用它。
 * ●如果定义了自定义销毁方法，那么就会调用它。
 *
 * 上述生命周期的接口，大部分是针对单个Bean而言的
 */
public class BeanLifecycleJuiceMaker implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
	private String beverageShop = null;
	private Source source = null;

	public String getBeverageShop() {
		return beverageShop;
	}

	public void setBeverageShop(String beverageShop) {
		this.beverageShop = beverageShop;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String makeJuice() {
		String juice = "这是一杯由" + beverageShop + "饮品店，提供的" + source.getSize() + source.getSugar() + source.getFruit();
		return juice;
	}

	public void init() {
		System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
	}

	public void destroy() {
		System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware接口的setBeanName方法");

	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware接口的setBeanFactory方法");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println(
				"【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware接口的setApplicationContext方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【" + this.getClass().getSimpleName() + "】调用InitializingBean接口的afterPropertiesSet方法");
	}
}
