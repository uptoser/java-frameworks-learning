package com.uptoser.ssm.ssm.config;


import com.uptoser.ssm.ssm.performance.AopConfig;
import com.uptoser.ssm.ssm.printer.PrinterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.uptoser")
@Import({ PrinterConfig.class, AopConfig.class })
public class SpringConfig {

	//Spring开启占位符 ${}
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
