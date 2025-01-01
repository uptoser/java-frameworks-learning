package com.uptoser.ssm.mybatis.c4.cascade.mapper2;

import com.uptoser.ssm.mybatis.c4.cascade.pojo2.User2;

import java.util.List;

public interface UserMapper2 {
	
    public User2 getUser(Long id);
    
    public List<User2> findUserByRoleId(Long roleId);
}
