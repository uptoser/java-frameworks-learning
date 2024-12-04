package com.uptoser.ssm.spring.c3.aop.aop.verifier.impl;

import com.uptoser.ssm.spring.c3.aop.aop.verifier.RoleVerifier;
import com.uptoser.ssm.spring.c3.aop.game.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier {
	@Override
	public boolean verify(Role role) {
		System.out.println("引入，检测一下角色是否为空");
		return role != null;
	}
}
