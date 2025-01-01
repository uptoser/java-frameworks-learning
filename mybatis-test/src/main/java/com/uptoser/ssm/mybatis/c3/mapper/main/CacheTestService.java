package com.uptoser.ssm.mybatis.c3.mapper.main;

import com.uptoser.ssm.mybatis.c3.mapper.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c3.mapper.pojo.Role;
import com.uptoser.ssm.mybatis.c3.mapper.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
/**
 * 在MyBatis中允许使用缓存，缓存一般都放置在可高速读 /写的存储器上
 * MyBatis分为一级缓存和二级缓存，同时也可以配置关于缓存的设置
 */
public class CacheTestService {
    /**
     * 测试一级缓存
     * 一级缓存是在SqlSession上的缓存，默认情况下，MyBatis 系统会开启一级缓存
     * 这个缓存不需要POJO对象可序列化（实现java.io.Serializable接口）
     *
     * 首先在没有任何配置的环境下，测试一级缓存
     * SqlSession第一次通过SQL和参数获取对象后，它就会将其缓存起来，
     * 如果下次的SQL和参数都没有发生变化，并且缓存没有超时或者声明需要刷新时，那么它就会从缓存中获取数据
     *
     * 开启二级缓存很简单，只要在映射文件加上<cache/>
     * 这个时候MyBatis会序列化和反序列化对应的POJO,也就要求POJO是一个可序列化的对象
     *
     * 加上<cache/>后 MyBatis就会将对应的命名空间内所有 select 元素 SQL 查询结果进行缓存，
     * 而其中的 insert、delete 和update语句在操作时会刷新缓存。
     * 可以使用自定义的缓存，只是实现类需要实现MyBatis的接口org.apache.ibatis.cache.Cache
     * public interface Cache {
     *     //获取缓存ID
     *     String getId();
     *     //保存对象
     *     void putObject(Object key, Object value);
     *     //获取缓存数据
     *     Object getObject(Object key);
     *     //删除缓存数据
     *     Object removeObject(Object key);
     *     //清除缓存
     *     void clear();
     *     //获取缓存大小
     *     int getSize();
     *     //获取读/写锁，需要考虑多线程的场景
     *     default ReadWriteLock getReadWriteLock() {
     *         return null;
     *     }
     * }
     *
     * 假设存在一个Redis的缓存实现类com.ssm.cache.RedisCache，那么可以这样配置它
     * <cache type="com.ssm.cache.RedisCache">
     *      <property name = "host" value = "localhost"/>
     * <cache/>
     * 对于一些语句也需要自定义。比如对于一些查询并不想要它进行任何缓存，这个时候可以通过配置改变它们
     * <select ... flushCache="false" useCache+"true"/> useCache属性则是select特有的，代表是否需要使用缓存
     * <insert ... flushCache="true"/> flushCache 代表是否刷新缓存
     * 如果其他的映射器需要使用同样的配置，则可以引用缓存的配置
     * <cache-ref namespace="com.ssm.mapper.Mapper"/>
     */
    @Test
    public void testOneLevelCache() {
        SqlSession sqlSession = null;
        Logger logger = Logger.getLogger(CacheTestService.class);
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            System.out.println(role);
            logger.info("再次获取POJO......");
            //虽然代码对同一对象进行了两次获取，但是实际只有一条SQL被执
            Role role2 = roleMapper.getRole(1L);
            System.out.println(role);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 通过不同SqlSession获取对象
     *
     * 注意commit()方法的使用，如果不进行commit，是不会有一级缓存存在的
     *
     * 为了使 SqlSession 对象之间共享相同的缓存，有时候需要开启二级缓存
     * 在映射文件（RoleMapper.xml）上加入代码：<cache/>
     *
     * 如果Role类没有实现java.io.Serializable接口，那么MyBatis将会抛出异常
     */
    @Test
    public void testOneLevelCache2() {
        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        Logger logger = Logger.getLogger(CacheTestService.class);
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            sqlSession2 = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            sqlSession.commit();
            logger.info("不同SqlSession获取对象......");
            RoleMapper roleMapper2 = sqlSession2.getMapper(RoleMapper.class);
            Role role2 = roleMapper2.getRole(1L);
            sqlSession2.commit();
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (sqlSession2 != null) {
                sqlSession.close();
            }
        }
    }
}
