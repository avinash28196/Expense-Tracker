package com.tracker.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExpenseApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ExpenseApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(ExpenseApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();
		//Stirng[] definition = ctx.getClassLoader()
//		for(String s : beans) System.out.println(s);
//		System.out.println(beans.length);
//		int definition = ctx.getBeanDefinitionCount();
//		System.out.println(definition);
		
	}

}
