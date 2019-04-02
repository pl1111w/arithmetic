package com.atguigu.spring.aopImpl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/*order 括号内的值越小切面优先级越高*/
@Order(1)
@Aspect
@Component
public class VlidationAspect {

	@Before("LoggingAspect.declareAspect()")
	public void vlidactionaAspect(JoinPoint joinpoint)
	{
		String methodname=joinpoint.getSignature().getName();
		Object[] args=joinpoint.getArgs();
		System.out.println("The vlication "+methodname+" begins with "+Arrays.asList(args)+"*****");
	}
}

