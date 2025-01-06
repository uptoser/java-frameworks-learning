package com.uptoser.ssm.spring.c3.aop.aop.aspect;

import com.uptoser.ssm.spring.c2.bean.xml.pojo.Role;
import com.uptoser.ssm.spring.c3.aop.aop.verifier.RoleVerifier;
import com.uptoser.ssm.spring.c3.aop.aop.verifier.impl.RoleVerifierImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 在Spring中有4种方式去实现AOP的拦截功能。
 * ●使用ProxyFactoryBean和对应的接口实现AOP。
 * ●使用XML配置AOP。
 * ●使用@AspectJ注解驱动切面。
 * ●使用AspectJ注入切面。
 */
/*
 * 创建切面（Aspect）
 * 切面就是在一个怎么样的环境中工作。
 * 比如数据库的事务直接贯穿了整个代码层面，这就是一个切面，
 * 它能够在被代理对象的方法之前、之后，产生异常或者正常返回后切入你的代码，
 * 甚至代替原来被代理对象的方法，在动态代理中可以把它理解成一个拦截器
 */
@Aspect
public class RoleAspect {

	/*
	通知（Advice）
	●前置通知（before）：在动态代理反射原有对象方法或者执行环绕通知前执行的通知功能。
	●返回通知（afterReturning）：在动态代理反射原有对象方法或者执行环绕通知后执行的通知功能。
	●异常通知（afterThrowing）：在动态代理反射原有对象方法或者执行环绕通知产生异常后执行的通知功能。
	●后置通知（after）：在动态代理反射原有对象方法或者执行环绕通知后执行的通知功能。无论是否抛出异常，它都会被执行。
	●环绕通知（aroundThrowing）：在动态代理中，它可以取代当前被拦截对象的方法，通过参数或反射调用被拦截对象的方法。
	 */

	/*
	引入（Introduction）
	引入允许我们在现有的类里添加自定义的类和方法。
	 */
	/**
	 * 引入其他的方法
	 * ●value="......RoleServiceImpl+"：表示对RoleServiceImpl类进行增强，也就是在RoleServiceImpl中引入一个新的接口。
	 * ●defaultImpl：代表其默认的实现类，这里是RoleVerifierImpl。
	 */
	@DeclareParents(value= "com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl+", defaultImpl= RoleVerifierImpl.class)
	public RoleVerifier roleVerifier;


	/*
	切点（Pointcut）
	在动态代理中，被切面拦截的方法就是一个切点，切面将可以将其切点和被拦截的方法按照一定的逻辑织入到约定流程当中。
	代码清单的printRole方法就是一个切点。
	 */
	/*
	连接点（join point）
	连接点是一个判断条件，由它可以指定哪些是切点。对于指定的切点，Spring 会生成代理对象去使用对应的切面对其拦截，否则就不会拦截它。
	●execution：用于匹配连接点的执行方法。可以用正则式进行匹配
	●*：代表任意返回类型的方法。
	●com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl：代表类的全限定名。
	●printRole：被拦截方法名称。
	●（..）：任意的参数。
	 */
	@Pointcut("execution(* com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl.printRole(..))"
//			+ " && within(com.uptoser.ssm.spring.c3.aop.aop.service.impl.*)"限制连接点匹配指定的包
//			+ " && target(com.uptoser.ssm.spring.c3.aop.aop.service.RoleService)"限制连接点匹配被代理对象为指定的类型
//			+ " && args(role)" //限制连接点匹配参数为指定的方法
			/*
			@annotation：限定匹配带有指定注解的连接点
			@within()：限制连接点匹配指定的包
			@target()：限制连接点匹配指定的执行对象，这些对象要符合指定的注解类型
			@args()：限制连接点匹配对数为指定注解标注的执行方法
			this()：限制连接点匹配AOP代理的Bean，引用指定类型
			 */
	)
	public void print() {
	}

	//正则表达式需要重复书写多次，比较麻烦，只要引入另一个注解@Pointcut就可以避免这个麻烦
	@Before("print()")
	// @Before("execution(*
	// com.ssm.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void before() {
		System.out.println("全局的before ....");
	}
	/*
	织入（Weaving）
	织入是一个生成代理对象的过程。实际代理的方法分为静态代理和动态代理。
	静态代理是在编译class文件时生成的代码逻辑，但是在Spring中并不使用这样的方式。
	一种是通过ClassLoader也就是在类加载的时候生成的代码逻辑，但是它在应用程序代码运行前就生成对应的逻辑。
	还有一种是运行期，动态生成代码的方式，这是Spring AOP所采用的方式，Spring是以JDK和CGLIB动态代理来生成代理对象的

	给通知传递参数
	 */
	@Before("execution(* com.uptoser.ssm.spring.c3.aop.aop.service.impl.RoleServiceImpl.printRole(..)) " + "&& args(role, sort)")
	public void before(Role role, int sort) {
		System.out.println("带参数的before .... sort的参数为:"+sort);
	}

	@AfterReturning("print()")
	public void afterReturning() {
		System.out.println("afterReturning ....");
	}

	@AfterThrowing("print()")
	public void afterThrowing() {
		System.out.println("afterThrowing ....");
	}

	@After("print()")
	public void after() {
		System.out.println("after ....");
	}

	@Around("print()")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("around before ....");
		try {
			jp.proceed();
		} catch (Throwable e) {
//			System.err.println("catch出现了异常");
		}
		System.out.println("around after ....");
	}

}
