package com.uptoser.ssm.mybatis.c3.mapper.main;

import com.uptoser.ssm.mybatis.c3.mapper.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c3.mapper.param.PageParams;
import com.uptoser.ssm.mybatis.c3.mapper.param.RoleParams;
import com.uptoser.ssm.mybatis.c3.mapper.pojo.Role;
import com.uptoser.ssm.mybatis.c3.mapper.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试映射器
 */
public class RoleBaseSelectService {
    /**
     * 返回值为int的结果
     */
    @Test
    public void testCountRoleByName() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int count = roleMapper.countRoleByName("role");
            System.out.println("数量为:"+count);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * 使用Map传递多个参数
     */
    @Test
    public void testFindRolesByMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Map<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("roleName", "1");
            parameterMap.put("note", "1");
            List<Role> roles = roleMapper.findRolesByMap(parameterMap);
            System.out.println(roles.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * 使用注解传递多个参数
     */
    @Test
    public void testFindRolesByAnnotation() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roles = roleMapper.findRolesByAnnotation("1", "1");
            System.out.println(roles.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * 通过Java Bean传递多个参数
     */
    @Test
    public void testFindRolesByBean() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RoleParams roleParam = new RoleParams();
            roleParam.setNote("1");
            roleParam.setRoleName("1");
            List<Role> roles = roleMapper.findRolesByBean(roleParam);
            System.out.println(roles.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * 混合使用几种方法来传递参数
     */
    @Test
    public void testFindByMix() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RoleParams roleParam = new RoleParams();
            roleParam.setNote("1");
            roleParam.setRoleName("1");
            PageParams pageParams = new PageParams();
            pageParams.setStart(0);
            pageParams.setLimit(100);
            List<Role> roles = roleMapper.findByMix(roleParam, pageParams);
            System.out.println(roles.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * 返回实体类
     */
    @Test
    public void testGetRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
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
     * 返回resultMap
     */
    @Test
    public void testGetRoleUseResultMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRoleUseResultMap(1L);
            System.out.println(role.getRoleName());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * 使用RowBounds分页
     */
    @Test
    public void findRoleByRowBounds() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RowBounds rowBounds = new RowBounds(0,2);
            List<Role> list = roleMapper.findRoleByRowBounds(rowBounds);
            list.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }



}
