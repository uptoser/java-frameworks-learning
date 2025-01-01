package com.uptoser.ssm.mybatis.c4.cascade.pojo;

public class MaleEmployee extends Employee {

	private MaleHealthForm maleHealthForm = null;

	public MaleHealthForm getMaleHealthForm() {
		return maleHealthForm;
	}

	public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
		this.maleHealthForm = maleHealthForm;
	}

	@Override
	public String toString() {
		return "MaleEmployee{" +
				"maleHealthForm=" + maleHealthForm +
				'}'+super.toString();
	}
}
