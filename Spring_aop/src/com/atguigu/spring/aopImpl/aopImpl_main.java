package com.atguigu.spring.aopImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopImpl_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=new ClassPathXmlApplicationContext("application.Context.xml");
		IArichmeticCalculator ArichmeticCalculator=ctx.getBean(IArichmeticCalculator.class);
		int result=ArichmeticCalculator.add(1, 8);
		System.out.println("---->>>>"+result);
		
		result=ArichmeticCalculator.div(8,4);	
		System.out.println("---->>>>"+result);
	}

}
	