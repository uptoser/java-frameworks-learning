package com.uptoser.ssm.mybatis.c4.cascade.pojo2;

import com.uptoser.ssm.mybatis.c2.config.enumeration.SexEnum;

import java.util.List;

public class User2 {
	private Long id;
	private String userName;
	private String realName;
	private SexEnum sex;
	private String moble;
	private String email;
	private String note;
	private List<Role2> roleList;

	@Override
	public String toString() {
		return "User2{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", realName='" + realName + '\'' +
				", sex=" + sex +
				", moble='" + moble + '\'' +
				", email='" + email + '\'' +
				", note='" + note + '\'' +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public String getMoble() {
		return moble;
	}

	public void setMoble(String moble) {
		this.moble = moble;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Role2> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role2> roleList) {
		this.roleList = roleList;
	}

}
