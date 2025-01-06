package com.uptoser.ssm.spring.c5.transactional.service.impl;


import com.uptoser.ssm.spring.c4.db.pojo.Role;
import com.uptoser.ssm.spring.c5.transactional.mapper.RoleMapper;
import com.uptoser.ssm.spring.c5.transactional.service.RoleService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Transactional 可配置的内容
 *  propagation：定义事务的传播行为。常见的取值包括：
 * 		REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务（默认）。
 * 	        新的事务独立于外部事务。如果新的事务回滚，不会影响外部事务的状态。如果外部事务回滚，也不会影响新的事务的状态。
 * 		REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则挂起当前事务。
 * 		SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务方式继续执行。
 * 		NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，则挂起当前事务。
 * 		MANDATORY：必须在一个事务中执行，如果当前没有事务，则抛出异常。
 * 		NEVER：必须在非事务中执行，如果当前存在事务，则抛出异常。
 * 		NESTED：如果当前存在事务，则在嵌套事务内执行，如果当前没有事务，则创建一个新的事务。
 * 	        嵌套事务的回滚只会影响嵌套事务内部的操作，外部事务不受影响。但是，如果外部事务回滚，则嵌套事务也会被回滚。
 * isolation：定义事务的隔离级别。常见的取值包括：
 * 		DEFAULT：使用后端数据库的默认隔离级别（默认）。
 * 		READ_UNCOMMITTED：最低的隔离级别，可能导致脏读、不可重复读和幻读。
 * 		READ_COMMITTED：保证不会读到未提交的数据，可能导致不可重复读和幻读。
 * 		REPEATABLE_READ：保证在一个事务中多次读取同样的数据结果一致，可能导致幻读。
 * 		SERIALIZABLE：最高的隔离级别，完全服从ACID的要求，性能较低。
 * timeout：定义事务的超时时间，以秒为单位。如果超过该时间限制但事务仍未完成，则自动回滚事务。默认值为 -1，即不超时。
 * readOnly：指示事务是否只读。对于只读事务，可以将其设置为 true 以优化性能。默认值为 false。
 * rollbackFor：定义一个异常类数组，当抛出这些异常类时，事务将回滚。例如 rollbackFor = Exception.class。
 * rollbackForClassName：异常类名
 * noRollbackFor：定义一个异常类数组，当抛出这些异常类时，事务将不会回滚。例如 noRollbackFor = IllegalArgumentException.class。
 * noRollbackForClassName
 * value 和 transactionManager：指定事务管理器的名称，默认使用 transactionManager。
 *
 */
@Service
public class RoleServiceImpl implements RoleService, ApplicationContextAware {
	@Autowired
	private RoleMapper roleMapper = null;
	private ApplicationContext ctx = null;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
//	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
//	@Transactional(propagation = Propagation.NESTED, isolation = Isolation.READ_COMMITTED)
	public int insertRole(Role role) {
//		if(role.getRoleName().equals("role_name_3"))
//			throw new RuntimeException("name3异常");
		return roleMapper.insertRole(role);
	}

	/**
	 * 自调用
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public int insertRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			//调用自身方法产生自调用问题
			insertRole(role);
			count++;
		}
		return count;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation= Isolation.READ_COMMITTED)
	public int insertRoleList2(List<Role> roleList) {
		int count = 0;
		RoleService service = ctx.getBean(RoleService.class);
		for (Role role : roleList) {
			service.insertRole(role);
			count++;
		}
		return count;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
	}
}