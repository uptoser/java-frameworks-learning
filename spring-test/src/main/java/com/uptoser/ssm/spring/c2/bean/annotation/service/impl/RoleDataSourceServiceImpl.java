package com.uptoser.ssm.spring.c2.bean.annotation.service.impl;

import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleDataSourceServiceImpl implements RoleDataSourceService {

	@Autowired
	DataSource dataSource = null;
	
	@Override
	public Role getRole(Long id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Role role = null;
		try {
			 conn = dataSource.getConnection();
			 ps = conn.prepareStatement("select id, role_name, note from t_role where id = ?");
			 ps.setLong(1, id);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 role = new Role();
				 role.setId(rs.getLong("id"));
				 role.setRoleName(rs.getString("role_name"));
				 role.setNote(rs.getString("note"));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/**********close database resources************/
		}
		return role;
	}

}
