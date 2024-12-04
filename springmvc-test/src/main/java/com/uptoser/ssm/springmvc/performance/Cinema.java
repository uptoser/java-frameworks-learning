package com.uptoser.ssm.springmvc.performance;

import org.springframework.stereotype.Component;

@Component
public class Cinema implements Performance {

	public void perform(Integer count) {
		System.out.println("这是第"+count+"场电影");
//		throw new RuntimeException();
	}

}
