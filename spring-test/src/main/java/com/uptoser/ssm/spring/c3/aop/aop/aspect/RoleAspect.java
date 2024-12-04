package com.uptoser.ssm.spring.c3.aop.aop.aspect;

import com.uptoser.ssm.spring.c3.aop.aop.verifier.RoleVerifier;
import com.uptoser.ssm.spring.c3.aop.aop.verifier.impl.RoleVerifierImpl;
import com.uptoser.ssm.spring.c3.aop.game.pojo.Role;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 创建切面
 */
@Aspect
public class RoleAspect {

	/*
	通知（Adice）
	●前置通知（before）：在动态代理反射原有对象方法或者执行环绕通知前执行的通知功能。
	●后置通知（after）：在动态代理反射原有对象方法或者执行环绕通知后执行的通知功能。无论是否抛出异常，它都会被执行。
	●返回通知（afterReturning）：在动态代理反射原有对象方法或者执行环绕通知后执行的通知功能。
	●异常通知（afterThrowing）：在动态代理反射原有对象方法或者执行环绕通知产生异常后执行的通知功能。
	●环绕通知（aroundThrowing）：在动态代理中，它可以取代当前被拦截对象的方法，通过参数或反射调用被拦截对象的方法。
	 */
	/*
	切点（Pointcut）
	在动态代理中，被切面拦截的方法就是一个切点，切面将可以将其切点和被拦截的方法按照一定的逻辑织入到约定流程当中。
	代码清单的printRole方法就是一个切点。
	 */
	/*
	连接点（join point）
	连接点是一个判断条件，由它可以指定哪些是切点。对于指定的切点，Spring 会生成代理对象去使用对应的切面对其拦截，否则就不会拦截它。
	●execution：代表执行方法的时候会触发。
	●*：代表任意返回类型的方法。
	●com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl：代表类的全限定名。
	●printRole：被拦截方法名称。
	●（..）：任意的参数。
	 */

	/**
	 * 引入其他的方法
	 * ●value="......RoleServiceImpl+"：表示对RoleServiceImpl类进行增强，也就是在RoleServiceImpl中引入一个新的接口。
	 * ●defaultImpl：代表其默认的实现类，这里是RoleVerifierImpl。
	 */
	@DeclareParents(value= "com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl+", defaultImpl= RoleVerifierImpl.class)
	public RoleVerifier roleVerifier;

	@Pointcut("execution(* com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl.printRole(..))"
//			+ " && within(com.uptoser.ssm.spring.c3.aop.aop.service.impl.*)"限制连接点匹配指定的包
//			+ " && target(com.uptoser.ssm.spring.c3.aop.aop.service.RoleService)"限制连接点匹配被代理对象为指定的类型
//			+ " && args(role)" 限制连接点匹配参数为指定的方法
	)
	public void print() {
	}

	//正则表达式需要重复书写多次，比较麻烦，只要引入另一个注解@Pointcut就可以避免这个麻烦
	@Before("print()")
	// @Before("execution(*
	// com.ssm.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void before() {
		System.out.println("before ....");
	}

	@After("print()")
	// @After("execution(*
	// com.ssm.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void after() {
		System.out.println("after ....");
	}

	@AfterReturning("print()")
	// @AfterReturning("execution(*
	// com.ssm.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void afterReturning() {
		System.out.println("afterReturning ....");
	}

	@AfterThrowing("print()")
	// @AfterThrowing("execution(*
	// com.ssm.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void afterThrowing() {
		System.out.println("afterThrowing ....");
	}

	@Around("print()")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("around before ....");
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around after ....");
	}

	@Before("execution(* com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl.printRole(..)) " + "&& args(role, sort)")
	public void before(Role role, int sort) {
		System.out.println("before ....");
		System.out.println("before .... sort:"+sort);
	}
}
