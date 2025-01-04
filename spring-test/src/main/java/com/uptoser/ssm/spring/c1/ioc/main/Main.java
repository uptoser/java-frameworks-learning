package com.uptoser.ssm.spring.c1.ioc.main;

import com.uptoser.ssm.spring.c1.ioc.bean.lifecycle.BeanLifecycleJuiceMaker;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 控制反转是一个比较抽象的概念
 * 控制反转的概念：控制反转是一种通过描述（在 Java中可以是XML或者注解）并通过第三方去产生或获取特定对象的方式。
 * 举例说明:
 * 在实际生活中，人们要用到一样东西时，人们的基本想法是找到东西，比如想喝杯橙汁，在没有饮品店的日子里，最直观的做法是，要买果汁机、橙子，准备开水。
 * 请注意这是你自己“主动”创造的过程，也就是一杯橙汁需要主动创造。
 * 然而到了今时今日，由于饮品店的盛行，已经没有必要自己去榨橙汁了。
 * 想喝橙汁的想法一出现，第一个想法是找到饮品店的联系方式，通过电话、微信等渠道描述你的需要、地址、联系方式等，下订单等待，过会就会有人送上橙汁了。
 * 请注意你并没有“主动”创造橙汁，也就是橙汁是由饮品店创造的，而不是你，但是也完全达到了你的要求
 *
 * Spring IoC容器可以容纳我们所开发的各种Bean，并且我们可以从中获取各种发布在Spring IoC容器里的Bean，并且通过描述可以得到它
 * Spring IoC容器的设计主要是基于BeanFactory和ApplicationContext两个接口，其中ApplicationContext是BeanFactory的子接口之一，
 * 换句话说BeanFactory是Spring IoC容器所定义的最底层接口，而ApplicationContext是其高级接口之一
 * BeanFactory接口中提供了一些方法：
 * ●getBean的多个方法用于获取配置给Spring IoC容器的Bean
 * ●isSingleton用于判断是否单例
 * 而isPrototype则相反，如果判断为真，意思是当你从容器中获取Bean，容器就为你生成了一个新的实例
 * ●关于type的匹配，这是一个按Java类型匹配的方式。
 * ●getAliases方法是获取别名的方法。
 *
 * ApplicationContext接口扩展了许许多多的接口，因此它的功能十分强大，而 WebApplicationContext 也扩展了它
 */
public class Main {
	/**
	 * Bean的初始化分为3步：
	 * （1）Resource定位，这步是Spring IoC容器根据开发者的配置，进行资源定位，在Spring的开发中，通过XML或者注解都是十分常见的方式，定位的内容是由开发者所提供的。
	 * （2）BeanDefinition的载入，这个过程就是Spring根据开发者的配置获取对应的POJO，用以生成对应实例的过程。
	 * （3）BeanDefinition的注册，这个步骤就相当于把之前通过BeanDefinition载入的POJO往Spring IoC容器中注册，这样就可以使得开发和测试人员都可以通过描述从中得到Spring IoC容器的Bean了。
	 * 做完了这3步，Bean就在Spring IoC容器中得到了初始化，但是没有完成依赖注入，也就是没有注入其配置的资源给Bean，那么它还不能完全使用
	 * 对于依赖注入，Spring Bean还有一个配置选项——lazy-init，其含义就是是否初始化Spring Bean。
	 * 在没有任何配置的情况下，它的默认值为default，实际值为false，也就是Spring IoC默认会自动初始化Bean。
	 * 如果将其设置为true，那么只有当我们使用Spring IoC容器的getBean方法获取它时，它才会进行初始化，完成依赖注入。
	 */
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext是 ApplicationContext 的一个子类
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("classpath:com/uptoser/ssm/spring/c1/ioc/spring-cfg.xml");
		BeanLifecycleJuiceMaker juiceMaker2 = (BeanLifecycleJuiceMaker) ctx.getBean("lifecycle");
		System.out.println(juiceMaker2.makeJuice());
		ctx.close();
	}

}
