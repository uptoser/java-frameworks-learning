package com.uptoser.ssm.spring.c5.transactional.config;

import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


public class MybatisConfig {


    //定义bean：SqlSessionFactoryBean，用于产生SqlSessionFactory对象
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //全局配置：驼峰映射
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        config.setLogImpl(Log4jImpl.class);
        sqlSessionFactoryBean.setConfiguration(config);
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //获取PathMatchingResourcePatternResolver对象为扫描mapper文件做准备
        PathMatchingResourcePatternResolver path = new PathMatchingResourcePatternResolver();
        //设置mapper文件位置
//        sqlSessionFactoryBean.setMapperLocations(path.getResources("classpath*:com/uptoser/ssm/spring/c5/transactional/mapper/*.xml"));
        //为javaBean对象设置别名
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.uptoser.ssm.spring.c5.transactional");
        return sqlSessionFactoryBean.getObject();
    }

    //配置sqlSession
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) throws Exception {
        //将SqlSessionFactory作为参数传入构造方法
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    //MapperScanner @Repository
    @Bean
    public MapperScannerConfigurer mapperScanner(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.uptoser.ssm.spring.c5.transactional.mapper");
        return msc;
    }
}
