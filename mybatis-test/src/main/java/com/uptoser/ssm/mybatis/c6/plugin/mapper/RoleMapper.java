package com.uptoser.ssm.mybatis.c6.plugin.mapper;

import com.uptoser.ssm.mybatis.c6.plugin.params.PageParams;
import com.uptoser.ssm.mybatis.c6.plugin.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoleMapper {
	
	public Role getRole(Long id);

	public List<Role> findRole(@Param("pageParams") PageParams pageParams, @Param("roleName") String roleName);
}