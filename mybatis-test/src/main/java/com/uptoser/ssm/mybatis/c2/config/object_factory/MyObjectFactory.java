package com.uptoser.ssm.mybatis.c2.config.object_factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * MyBatis 允许注册自定义的 ObjectFactory。
 * 如果自定义，则需要实现接口org.apache.ibatis.reflection.factory.ObjectFactory，并给予配置。
 * 在更多的情况下，都会考虑继承系统已经实现好的 DefaultObjectFactory
 */
public class MyObjectFactory extends DefaultObjectFactory {

    private static final long serialVersionUID = -7459679834579634L;

    Logger log = Logger.getLogger(MyObjectFactory.class);

    private Object temp = null;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        log.info("初始化参数：【"+properties.toString()+"】");
    }

    @Override
    public <T> T create(Class<T> type) {
        T t = super.create(type);
        log.info("创建对象：【"+t.toString()+"】");
        log.info("是否和上次创建是同一个对象：【"+t == temp +"】");
        return t;
        
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T t = super.create(type, constructorArgTypes, constructorArgs);
        log.info("创建对象：【"+t.toString()+"】");
        temp = t;
        return t;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
