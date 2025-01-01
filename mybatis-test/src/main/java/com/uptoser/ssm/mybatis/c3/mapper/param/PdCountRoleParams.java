package com.uptoser.ssm.mybatis.c3.mapper.param;

import java.util.Date;

/**
 -- 创建存储过程
 -----------------------------------------------
 DROP PROCEDURE IF EXISTS `count_role`;
 delimiter ;;
 CREATE PROCEDURE `count_role`(IN p_role_name VARCHAR(20),OUT count_total INT,OUT exec_date DATE)
 BEGIN

 SELECT COUNT(*) INTO count_total FROM t_role WHERE role_name LIKE CONCAT('%',p_role_name,'%');
 SELECT CURDATE() INTO exec_date;

 END
 ;;
 delimiter ;
 ---------------------------------------------
 为了使用它，要设计一个 POJO——PdCountRoleParams
 roleName对应的是输入参数，而total、execDate对应的是输出参数
 */
public class PdCountRoleParams {

	private String roleName;
	private int total;
	private Date execDate;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getExecDate() {
		return execDate;
	}
	public void setExecDate(Date execDate) {
		this.execDate = execDate;
	}
	
	
}
