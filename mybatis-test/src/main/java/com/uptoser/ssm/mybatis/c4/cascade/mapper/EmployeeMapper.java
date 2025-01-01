package com.uptoser.ssm.mybatis.c4.cascade.mapper;

import com.uptoser.ssm.mybatis.c4.cascade.pojo.Employee;

public interface EmployeeMapper {

	public Employee getEmployee(Long id);
	
	public Employee getEmployee2(Long id);
}
