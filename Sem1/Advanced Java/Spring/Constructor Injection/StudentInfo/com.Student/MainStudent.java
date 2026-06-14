package com.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainStudent {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentInfo s1 = (StudentInfo) context.getBean("s1");
		StudentInfo s2 = (StudentInfo) context.getBean("s2");
		
		// accessing values using getter method
		System.out.println("Student name : " + s1.getName());
		System.out.println("Student roll no : " + s1.getRollNo());
		System.out.println("Student std : " + s1.getStd());
		System.out.println("Student city : " + s1.getAddress().getCity());
		System.out.println("Student state : " + s1.getAddress().getState());
		
		// accessing values using toString method
		System.out.println(s2);
	}

}