package com.uptoser.ssm.mybatis.c4.dynamic_sql.mapper;

import java.util.List;

import com.uptoser.ssm.mybatis.c4.dynamic_sql.pojo.Role;
import org.apache.ibatis.annotations.Param;


public interface RoleMapper {
	
    public List<Role> findRole1(@Param("roleName") String roleName);
    
    public List<Role> findRole2(Role role);
    
    public List<Role> findRole3(Role role);
    
    public List<Role> findRole4(@Param("roleName") String roleName);
    
    public List<Role> findRole5(String roleName);
    
    public List<Role> findRole6(@Param("roleName") String roleName, @Param("note") String note);
    
    public int updateRole(Role role);
    
    public List<Role> findRoleByNums(@Param("roleNoList") List<String> roleNoList);
    
    public List<Role> getRoleTest(@Param("type") String type);
    
}
