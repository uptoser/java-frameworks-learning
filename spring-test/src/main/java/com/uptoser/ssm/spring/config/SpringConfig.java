package com.uptoser.ssm.spring.config;

import com.uptoser.ssm.spring.performance.AopConfig;
import com.uptoser.ssm.spring.printer.PrinterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("me.ibeyond")
@Import({ PrinterConfig.class, AopConfig.class })
public class SpringConfig {

	//Spring开启占位符 ${}
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
