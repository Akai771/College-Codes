package com.AutoWiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AutoWireConfig.xml");
		Student s1 = (Student) context.getBean("s1");
		Student s2 = (Student) context.getBean("s2");
		Student s3 = (Student) context.getBean("s3");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}