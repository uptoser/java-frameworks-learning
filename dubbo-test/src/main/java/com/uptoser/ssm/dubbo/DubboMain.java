package com.uptoser.ssm.dubbo;

import com.uptoser.ssm.api.dubbo.IDubboService;
import com.uptoser.ssm.dubbo.spi.Driver;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboMain {
    public static void main(String[] args) throws IOException {
        //XML方式创建
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/dubbo-provider.xml");
        context.start();
        //SPI
        ExtensionLoader<Driver> extensionLoader=ExtensionLoader.getExtensionLoader(Driver.class);
        Driver driver=extensionLoader.getExtension("mysqlDriver");
        System.out.println(driver.connect());
        System.in.read(); //阻塞Main线程
        Main.main(args);//和XML方式一样
    }
    //Java方式创建
    public void test1() {
        //暴露UserService服务
        //1、application
        ApplicationConfig applicationConfig = new ApplicationConfig("sample-provider");
        //2、protocol -dubbo协议
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        //3、register
        //直连的方式，不暴露到注册中心
        RegistryConfig registryConfig = new RegistryConfig(RegistryConfig.NO_AVAILABLE);
        //4、service
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setInterface(IDubboService.class);
        serviceConfig.setRef(new DubboServiceImpl());
        //5、将application、protocol、register注册到service
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.export();

        System.out.println("服务已经暴露");
    }
}
