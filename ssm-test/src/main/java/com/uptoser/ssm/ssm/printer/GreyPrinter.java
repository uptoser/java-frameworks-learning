package com.uptoser.ssm.ssm.printer;

import org.springframework.beans.factory.annotation.Value;
public class GreyPrinter implements Printer {
	@Value("${test.sex}")
	private String sex;

	public String context() {
		return "This is a Grey Printer!\nI'm printing \"" + sex + "\"";
	}

}
