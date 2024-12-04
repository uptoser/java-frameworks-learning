package com.uptoser.ssm.spring.c3.aop.multi.bean.impl;

import com.uptoser.ssm.spring.c3.aop.multi.bean.MultiBean;
import org.springframework.stereotype.Component;


@Component
public class MultiBeanImpl implements MultiBean {

	@Override
	public void testMulti() {
		System.out.println("test multi aspects!!");
	}

}