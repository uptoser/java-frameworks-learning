package com.uptoser.ssm.ssm.printer;

public class ColorPrinter implements Printer {

	private String str;
	
	public ColorPrinter(String str){
		this.str=str;
	}
	public String context() {
		return "This is a Color Printer!\nI'm printing \""+str+"\"";
	}

}
