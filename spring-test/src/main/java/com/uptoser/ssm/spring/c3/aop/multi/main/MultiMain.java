package com.uptoser.ssm.spring.c3.aop.multi.main;

import com.uptoser.ssm.spring.c3.aop.multi.bean.MultiBean;
import com.uptoser.ssm.spring.c3.aop.multi.config.MultiConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MultiMain {

	public static void main(String[] args) {
		for (int i=0; i<3; i++) {
			System.out.println("#########################################\n\n\n");
			ApplicationContext ctx = new AnnotationConfigApplicationContext(MultiConfig.class);
			MultiBean multiBean = ctx.getBean(MultiBean.class);
			multiBean.testMulti();
			
		}
	}

}
