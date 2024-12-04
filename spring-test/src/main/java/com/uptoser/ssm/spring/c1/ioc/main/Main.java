package com.uptoser.ssm.spring.c1.ioc.main;

import com.uptoser.ssm.spring.c1.ioc.pojo.JuiceMaker2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		testIoC();
	}

	public static void testIoC() {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:com/uptoser/ssm/spring/c1/ioc/spring-cfg.xml");
		JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
		System.out.println(juiceMaker2.makeJuice());
		ctx.close();
	}
}
