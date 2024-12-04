package com.uptoser.ssm.spring.test;

import com.uptoser.ssm.spring.config.SpringConfig;
import com.uptoser.ssm.spring.performance.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {
	
//	@Autowired
//	Printer printer;
	@Autowired
Performance performance;
//	@Value("#{colorPrinter.context()?.toUpperCase()}")
//	String printerContext;
//	@Value("#{T(java.lang.Math).random()*10}")
//	int random;
	@Test
	public void test(){
//		System.out.println(printer.context());
//		System.out.println(printerContext);
//		System.out.println(random);
		performance.perform(null);
	}

}
