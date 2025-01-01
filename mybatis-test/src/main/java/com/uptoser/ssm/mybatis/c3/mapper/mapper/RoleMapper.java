package com.uptoser.ssm.mybatis.c3.mapper.mapper;

import com.uptoser.ssm.mybatis.c3.mapper.param.PageParams;
import com.uptoser.ssm.mybatis.c3.mapper.param.RoleParams;
import com.uptoser.ssm.mybatis.c3.mapper.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;
public interface RoleMapper {
	/**
	 * 返回值为int的结果
	 */
	public int countRoleByName(String roleName);

	/**
	 * 使用Map传递多个参数
	 */
	public List<Role> findRolesByMap(Map<String, Object> parameterMap);
	/**
	 * 使用注解传递多个参数
	 */
	public List<Role> findRolesByAnnotation(@Param("roleName") String rolename, @Param("note") String note);
	/**
	 * 通过Java Bean传递多个参数
	 */
	public List<Role> findRolesByBean(RoleParams roleParam);
	/**
	 * 混合使用几种方法来传递参数
	 */
	public List<Role> findByMix(@Param("params") RoleParams roleParams, @Param("page") PageParams PageParam);
	public Role getRole(Long id);
	public Role getRoleUseResultMap(Long id);

	/**
	 * 使用RowBounds分页
	 */
	public List<Role> findRoleByRowBounds(RowBounds rowBounds);
	/**
	 * 新增
	 * 主键回填
	 */
	public int insertRole(Role role);
	/**
	 * 自定义主键
	 */
	public int insertRole2(Role role);
	
	public int updateRole(Role role);
	
	public int deleteRole(Long id);
}
