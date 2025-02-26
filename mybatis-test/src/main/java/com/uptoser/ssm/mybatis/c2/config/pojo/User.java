package com.uptoser.ssm.mybatis.c2.config.pojo;


import com.uptoser.ssm.mybatis.c2.config.enumeration.SexEnum;

public class User {
	private Long id;
	private String userName;
	private SexEnum sex;
	private String mobile;
	private String tel;
	private String email;
	private String note;

	/** setter and getter **/
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


	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", sex=" + sex +
				", mobile='" + mobile + '\'' +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", note='" + note + '\'' +
				'}';
	}
}