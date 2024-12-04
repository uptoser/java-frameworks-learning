package com.uptoser.ssm.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = { "com.uptoser" })
// @Profile({"dev", "local"})//在生产环境不开启
public class SwaggerConfig extends WebMvcConfigurationSupport{
	private boolean state = true;// 开启接口

	@Bean
	public Docket customDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).enable(state);
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("", "", "");
		return new ApiInfo("XXXXXXXX", // 大标题 title
				"xxxxxxx", // 小标题
				"0.0.1", // 版本
				null, // termsOfServiceUrl
				contact, // 作者
				null, // 链接显示文字
				null// 网站链接
		);
	}
}
