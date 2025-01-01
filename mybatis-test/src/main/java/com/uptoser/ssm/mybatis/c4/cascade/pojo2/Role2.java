package com.uptoser.ssm.mybatis.c4.cascade.pojo2;

import java.util.List;

public class Role2 {
	private Long id;
	private String roleName;
	private String note;
	private List<User2> userList;

	@Override
	public String toString() {
		return "Role2{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				", note='" + note + '\'' +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<User2> getUserList() {
		return userList;
	}

	public void setUserList(List<User2> userList) {
		this.userList = userList;
	}

}
