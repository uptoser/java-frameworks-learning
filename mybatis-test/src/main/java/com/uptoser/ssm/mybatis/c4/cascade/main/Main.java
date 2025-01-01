package com.uptoser.ssm.mybatis.c4.cascade.main;

import com.uptoser.ssm.mybatis.c4.cascade.mapper.EmployeeMapper;
import com.uptoser.ssm.mybatis.c4.cascade.mapper2.RoleMapper2;
import com.uptoser.ssm.mybatis.c4.cascade.mapper2.UserMapper2;
import com.uptoser.ssm.mybatis.c4.cascade.pojo.Employee;
import com.uptoser.ssm.mybatis.c4.cascade.pojo2.Role2;
import com.uptoser.ssm.mybatis.c4.cascade.pojo2.User2;
import com.uptoser.ssm.mybatis.c4.cascade.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * MyBatis的级联分为3种。
 * ●鉴别器（discriminator）：它是一个根据某些条件决定采用具体实现类级联的方案，比如体检表要根据性别去区分。
 * column代表使用哪个字段进行鉴别
 * case用于进行区分，类似于Java的switch...case...语句
 * resultMap 属性表示采用哪个 ResultMap 去映射，比如 sex=0，则使用maleHealthFormMapper进行映射
 * ●一对一（association）：比如学生证和学生就是一种一对一的级联，雇员和工牌表也是一种一对一的级联。
 * property属性代表映射到POJO属性上
 * select配置是命名空间+SQL id的形式
 * column代表SQL的列，用作参数传递给select属性制定的SQL，如果是多个参数，则需要用逗号隔开
 * ●一对多（collection）：比如班主任和学生就是一种一对多的级联。
 * 值得注意的是，MyBatis 没有多对多级联，因为多对多级联比较复杂，使用困难，而且可以通过两个一对多级联进行替换。
 *
 * 分析雇员级联模型(mysql.sql.png)：
 * ●该模型是以雇员表为中心的。
 * ●雇员表和工牌表是一对一的级联关系。
 * ●雇员表和员工任务表是一对多的级联关系。
 * ●员工任务表和任务表是一对一的级联关系。
 * ●每个雇员都会有一个体检表，随着雇员表字段性别取值的不同，会有不同的关联表
 */
public class Main {

    /**
     * 级联查询
     */
    @Test
    public void testGetEmployee() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployee(1L);
//            System.out.println(employee);
//            System.out.println(employee.getWorkCard());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * 通过sql级联查询
     */
    @Test
    public void testGetEmployee2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployee2(1L);
            System.out.println(employee.getWorkCard().getPosition());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 多对多级联
     */
    @Test
    public void testUserRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
            Role2 role2 = roleMapper2.getRole(1L);
            System.out.println(role2);
            role2.getUserList().forEach(System.out::println);
            UserMapper2 userMapper2 = sqlSession.getMapper(UserMapper2.class);
            User2 user2 = userMapper2.getUser(1L);
            System.out.println(user2.getRoleList().size());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
