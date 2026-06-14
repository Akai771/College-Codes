package com.helloWorld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService service = (HelloService) context.getBean("helloService");
		service.sayHello();
		service.sayBye();
	}

}
