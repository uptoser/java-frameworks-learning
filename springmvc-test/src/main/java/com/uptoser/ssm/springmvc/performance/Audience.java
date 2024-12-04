package com.uptoser.ssm.springmvc.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
public class Audience {

	// @Pointcut("execution(**
	// me.ibeyond.performance.Performance.perform(Integer)) && args(count)")
	@Pointcut("execution(** me.ibeyond.performance.Performance.perform(..)) && within(me.ibeyond.*)")
	public void performance(Integer count) {
	}

	// @Before("performance(count)")
	// public void takeSeats(Integer count) {
	// // System.out.println("Taking Seats");
	// }
	//
	// @AfterReturning("performance(count)")
	// public void applause(Integer count) {
	// // System.out.println("CLAP CLAP CLAP!!!");
	// }
	//
	// @AfterThrowing("performance(count)")
	// public void demandRefund(Integer count) {
	// System.out.println("Demanding a refund");
	// }
	@Around("execution(** me.ibeyond.performance.Performance.perform(..)) && within(me.ibeyond..*)")
	public void loading(ProceedingJoinPoint pjp) {
		try {
			Signature sig = pjp.getSignature();
			MethodSignature msig = null;
			if (!(sig instanceof MethodSignature)) {
				throw new IllegalArgumentException("aaaoooppp");
			}
			msig = (MethodSignature) sig;
			Object target = pjp.getTarget();
			Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
			Annotation[] annotations = currentMethod.getAnnotations();			
			System.out.println("length:"+annotations.length);
			
			
			Object[] args = pjp.getArgs();
			for (int i=0;i<args.length;i++) {
				if(args[i] == null){
					args[i] = 1;
				}
			}
			pjp.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
