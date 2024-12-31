package com.uptoser.ssm.mybatis.c2.config.enumeration;

public enum SexEnum {
	MALE(0, "男"),
	FEMALE(1, "女");

	private int key;
	private String name;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	SexEnum(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public static SexEnum getSexByKey(int key) {
		for (SexEnum sex : SexEnum.values()) {
			if (sex.getKey() == key) {
				return sex;
			}
		}
		return null;
	}
}
