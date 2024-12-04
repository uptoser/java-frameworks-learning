package com.uptoser.ssm.spring.c3.aop.aop.config;

import com.uptoser.ssm.spring.c3.aop.aop.aspect.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //代表着启用AspectJ框架的自动代理，这个时候Spring才会生成动态代理对象，进而可以使用AOP
@ComponentScan(basePackages = "com.uptoser.ssm.spring.c3.aop.aop")
public class AopConfig {

    /**
     * 生成一个切面实例
     * @return
     */
	@Bean
    public RoleAspect getRoleAspect() {
        return new RoleAspect();
    }
}
