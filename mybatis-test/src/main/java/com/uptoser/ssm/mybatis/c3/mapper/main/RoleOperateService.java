package com.uptoser.ssm.mybatis.c3.mapper.main;

import com.uptoser.ssm.mybatis.c3.mapper.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c3.mapper.pojo.Role;
import com.uptoser.ssm.mybatis.c3.mapper.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class RoleOperateService {

    /**
     * 新增
     * 主键回填
     */
    @Test
    public void testInsertRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("role_name_5");
            role.setNote("note_5");
            roleMapper.insertRole(role);
            //打印主键
            System.out.println(role.getId());
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 自定义主键
     */
    @Test
    public void testInsertRole2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("role_name");
            role.setNote("note");
            roleMapper.insertRole2(role);
            System.out.println(role.getId());
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void testUpdateRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("role_name_1_update");
            role.setNote("note_1_update");
            role.setId(11L);
            int i = roleMapper.updateRole(role);
            System.out.println(i);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void testDeleteRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            roleMapper.deleteRole(11L);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
