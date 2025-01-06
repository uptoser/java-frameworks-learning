package com.uptoser.ssm.spring.c3.aop.multi.main;

import com.uptoser.ssm.spring.c3.aop.multi.bean.MultiBean;
import com.uptoser.ssm.spring.c3.aop.multi.config.MultiConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MultiMain {

	/**
	 * Spring也能支持多个切面。
	 * 当有多个切面时，在测试过程中发现它不会存在任何顺序，这些顺序代码会随机生成，
	 * 但是有时候我们希望它按照指定的顺序运行。
	 */
	public static void main(String[] args) {
		for (int i=0; i<3; i++) {
			ApplicationContext ctx = new AnnotationConfigApplicationContext(MultiConfig.class);
			MultiBean multiBean = ctx.getBean(MultiBean.class);
			multiBean.testMulti();
			System.out.println("#########################################");
		}
	}

}
