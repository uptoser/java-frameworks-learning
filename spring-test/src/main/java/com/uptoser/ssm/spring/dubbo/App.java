package com.uptoser.ssm.spring.dubbo;

import com.uptoser.ssm.api.dubbo.IDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath*:META-INF/spring/consumer.xml");
        IDubboService service=(IDubboService)context.getBean("dubboService");
        System.out.println(service.getMessage("-----------------\n DUBBO!!!\n -----------------"));
    }
}
