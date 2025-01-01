package com.uptoser.ssm.mybatis.c3.mapper.main;

import com.uptoser.ssm.mybatis.c3.mapper.mapper.PdRoleMapper;
import com.uptoser.ssm.mybatis.c3.mapper.param.PdCountRoleParams;
import com.uptoser.ssm.mybatis.c3.mapper.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


public class RoleProcedureService {

    /**
     * 简单存储过程
     */
    @Test
    public void testPdCountRole() {
        PdCountRoleParams params = new PdCountRoleParams();
        SqlSession sqlSession = null;
        try {
            Logger logger = Logger.getLogger(RoleProcedureService.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            PdRoleMapper roleMapper = sqlSession.getMapper(PdRoleMapper.class);
            params.setRoleName("role_name");
            roleMapper.countRole(params);
            logger.info(params.getTotal());
            logger.info(params.getExecDate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
//    @Test
//    public void testPdFindRole() {
//        PdFindRoleParams params = new PdFindRoleParams();
//        SqlSession sqlSession = null;
//        try {
//            Logger logger = Logger.getLogger(RoleProcedureService.class);
//            sqlSession = SqlSessionFactoryUtils.openSqlSession();
//            PdRoleMapper roleMapper = sqlSession.getMapper(PdRoleMapper.class);
//            params.setRoleName("role_name");
//            params.setStart(0);
//            params.setEnd(100);
//            roleMapper.findRole(params);
//            logger.info(params.getRoleList().size());
//            logger.info(params.getTotal());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            if (sqlSession != null) {
//                sqlSession.close();
//            }
//        }
//    }
}
