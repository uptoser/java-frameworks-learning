package com.uptoser.ssm.mybatis.c4.cascade.pojo;

public class FemaleEmployee extends Employee {

	private FemaleHealthForm femaleHealthForm = null;

	public FemaleHealthForm getFemaleHealthForm() {
		return femaleHealthForm;
	}

	public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
		this.femaleHealthForm = femaleHealthForm;
	}

	@Override
	public String toString() {
		return "FemaleEmployee{" +
				"femaleHealthForm=" + femaleHealthForm +
				'}'+super.toString();
	}
}
