package com.uptoser.ssm.spring.c1.ioc.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;

/**
 * 接口DisposableBean则是针对Spring IoC容器本身
 */
public class DisposableBeanImpl implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("调用接口DisposableBean的destroy方法");
	}

}
