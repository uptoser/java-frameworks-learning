package com.uptoser.ssm.mybatis.c4.cascade.pojo;

public class FemaleHealthForm extends HealthForm {

	private String uterus;

	public String getUterus() {
		return uterus;
	}

	public void setUterus(String uterus) {
		this.uterus = uterus;
	}

	@Override
	public String toString() {
		return "FemaleHealthForm{" +
				"uterus='" + uterus + '\'' +
				'}'+super.toString();
	}
}
