package com.uptoser.ssm.redis.pojo;

import java.io.Serializable;

//为要序列化对象，所以需要实现 Serializable 接口，表明它能够序列化，而serialVersionUID代表的是序列化的版本编号。
public class Role implements Serializable {
	
	private static final long serialVersionUID = 6977402643848374753L;

	private long id;
	private String roleName;
	private String note;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}