package com.uptoser.ssm.spring.c5.transactional.service.impl;

import com.uptoser.ssm.spring.c4.db.pojo.Role;
import com.uptoser.ssm.spring.c5.transactional.service.RoleListService;
import com.uptoser.ssm.spring.c5.transactional.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleListServiceImpl implements RoleListService {
	@Autowired
	private RoleService roleService = null;
	Logger log = Logger.getLogger(RoleListServiceImpl.class);
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int insertRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			count += roleService.insertRole(role);
//			if(count > 2) throw new RuntimeException("测试外部的异常");
		}
		return count;
	}
}