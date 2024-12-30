package com.uptoser.ssm.ssm.performance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // 启用AspectJ自动代理
public class AopConfig {

	@Bean
	/**
	 * 声明AudienceBean(Aop)
	 * 
	 * @return
	 */
	public Audience audience() {
		return new Audience();
	}

}
