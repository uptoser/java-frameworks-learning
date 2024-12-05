package com.uptoser.ssm.redis.main;

import com.uptoser.ssm.redis.jedis.JedisTest;
import com.uptoser.ssm.redis.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class C1Main {

	public static void main(String[] args) {
		testSpring();
	}

	private static void testJedis() {
		JedisTest jedisTest = new JedisTest();
		jedisTest.testJedis();
	}

	private static void testSpring() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//RedisTemplate、基于连接池的操作并不能保证每次使用RedisTemplate是操作同一个对Redis的连接
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		redisTemplate.opsForValue().set("role_1", role);
		Role role1 = (Role) redisTemplate.opsForValue().get("role_1");
		System.out.println(role1.getRoleName());
	}

	/**
	 * 为了使得所有的操作都来自于同一个连接，可以使用SessionCallback或者RedisCallback这两个接口，
	 * 而RedisCallback是比较底层的封装，其使用不是很友好，所以更多的时候会使用SessionCallback这个接口，
	 * 通过这个接口就可以把多个命令放入到同一个Redis连接中去执行
	 */
	private static void testSessionCallback() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		Role role = new Role();
		role.setId(1);
		role.setRoleName("role_name_1");
		role.setNote("role_note_1");
		SessionCallback callBack = new SessionCallback<Role>() {
			@Override
			public Role execute(RedisOperations ops) throws DataAccessException {
				ops.boundValueOps("role_1").set(role);
				return (Role) ops.boundValueOps("role_1").get();
			}
		};
		Role savedRole = (Role) redisTemplate.execute(callBack);
		System.out.println(savedRole.getId());
	}

}
