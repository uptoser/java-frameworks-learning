package com.uptoser.ssm.spring.c4.db.mapper;
import com.uptoser.ssm.spring.c4.db.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
	public int insertRole(Role role);
	public Role getRole( Long id);
	public int updateRole(Role role);
	public int deleteRole( Long id);
}