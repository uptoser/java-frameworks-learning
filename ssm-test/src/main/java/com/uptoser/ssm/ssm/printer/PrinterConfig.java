package com.uptoser.ssm.ssm.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:property/test.properties")
public class PrinterConfig {
	@Autowired
	Environment env;

	@Bean
	public ColorPrinter colorPrinter(String context) {
		return new ColorPrinter(context);
	}
	@Bean
	@Primary
	public GreyPrinter greyPrinter() {
		GreyPrinter greyPrinter = new GreyPrinter();
		return greyPrinter;
	}

	@Bean
	public String context() {
		return env.getProperty("test.name");
	}

}
