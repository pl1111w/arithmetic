package com.atguigu.spring.aopImpl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 
@Order(2)
@Aspect
@Component
public class LoggingAspect {

	//定义一个方法用于声明切入点表达式，一般的，该方法不需要添加其他代码
	@Pointcut("execution(* com.atguigu.spring.aopImpl.IArichmeticCalculator.*(int,int))")
	public void declareAspect(){}
	
   @Before("declareAspect()")
	public void LoggingAspect(JoinPoint joinpoint){
    	String methodname=joinpoint.getSignature().getName();
    	List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+methodname+" begins:"+args);
	}
    @After("declareAspect()")
    public void LoggingAspect1(JoinPoint joinpoint){
    	String methodname=joinpoint.getSignature().getName();
		System.out.println("The method "+methodname+" ends");
	}
    @AfterReturning(value="execution(* com.atguigu.spring.aopImpl.IArichmeticCalculator.*(int,int))",returning="result")
    public void RunningAspect1(JoinPoint joinpoint,Object result){
    	String methodname=joinpoint.getSignature().getName();
		System.out.println("The method "+methodname+" ends " +result);
	}
    @AfterThrowing(value="execution(* com.atguigu.spring.aopImpl.IArichmeticCalculator.*(int,int))",throwing="ex")
    public void afterThrowing(JoinPoint joinpoint,Exception ex){
    	String method=joinpoint.getSignature().getName();
    	System.out.println("The method "+method+"occurs excretion " +ex);
    }
    
    //环绕通知
    /*@Around("execution(* com.atguigu.spring.aopImpl.IArichmeticCalculator.*(int,int))")
    public Object around(ProceedingJoinPoint pdj) throws Throwable{
    	Object result=null;
    	String methodname=pdj.getSignature().getName();
    	try {
    		//前置通知
    		System.out.println("The method " +methodname+" begins");
    		//执行目标方
    		result=pdj.proceed();
    		//后置通知
    		System.out.println("The method "+methodname+" ends "+result);
			
		} catch (Exception e) {
			System.out.println("The method occurs exception "+e);
		}
    	//执行完通知
    	System.out.println("The method "+methodname+" ends....");
    	return 100;
    }*/
}
