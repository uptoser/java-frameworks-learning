package com.uptoser.ssm.spring.c5.transactional.mapper;

import com.uptoser.ssm.spring.c4.db.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
	public int insertRole(Role role);
}