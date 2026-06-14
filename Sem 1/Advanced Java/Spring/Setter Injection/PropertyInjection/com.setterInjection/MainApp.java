package com.setterInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainApp {

	public static void main(String[] args) {
		// This is hard coupling or high dependency we used to with
		MessageBean m1 = new MessageBean();
		m1.message = "Hard coupling";
		System.out.println("Old method: " + m1.message);
		
		// Dependency Injection
		// 1. first method using application context
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		MessageBean m2 = (MessageBean) context.getBean("morningBean");
		System.out.println("Property injection Using application context: " + m2.getMessage());
		
		// 2. second method using bean factory
		Resource resource = new ClassPathResource("ApplicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		MessageBean m3 = (MessageBean) factory.getBean("afternoonBean");
		System.out.println("Property injection Using Bean factory: " + m3.getMessage());
		
		

	}

}