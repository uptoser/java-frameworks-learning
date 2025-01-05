package com.uptoser.ssm.spring.c2.bean.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("elBean")
public class ElBean {
	@Value("#{roleEl}")
	private Role role;
	@Value("#{roleEl.id+1}")
	private Long id;
	/**
	 * 表达式"#{role.getNote（）.toString（）}"的注入，因为getNote可能返回为null，
	 * 这样 toString（）方法就会抛出异常了。为了处理这个问题，可以这样写"#{role.getNote（）?.toString（）}"，
	 * 这个表达式中问号的含义是先判断是否返回为非null，如果不是则不再调用toString方法
	 */
	@Value("#{role.getNote().toString()}")
	private String note;
	@Value("#{role.roleName eq 'name'}")
	private boolean equalString;
	@Value("#{T(Math).PI}")
	private double pi;
	@Value("#{T(Math).random()}")
	private double random;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ElBean{" +
				"role=" + role +
				", id=" + id +
				", note='" + note + '\'' +
				", equalString=" + equalString +
				", pi=" + pi +
				", random=" + random +
				'}';
	}
}
