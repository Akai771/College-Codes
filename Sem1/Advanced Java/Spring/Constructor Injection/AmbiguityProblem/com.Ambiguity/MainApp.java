package com.Ambiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ConstructorInjection.xml");
		Addition a1 = (Addition) context.getBean("add1");
		Addition a2 = (Addition) context.getBean("add2");
		Addition a3 = (Addition) context.getBean("add3");
		Addition a4 = (Addition) context.getBean("add4");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);

	}

}