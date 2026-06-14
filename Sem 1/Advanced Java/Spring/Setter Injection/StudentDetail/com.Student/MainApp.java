package com.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// getting dependency
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentInfo s1 = (StudentInfo) context.getBean("s1");
		StudentInfo s2 = (StudentInfo) context.getBean("s2");
		StudentInfo s3 = (StudentInfo) context.getBean("s3");
		StudentInfo s4 = (StudentInfo) context.getBean("s4");
		
		
		// you can call get method if you have private variable type
		System.out.println("Student 1 : \n" + s1.getName() + "\n" + s1.getRollNo() + "\n" + s1.getStd() + "\n");
		
		// you can use variable name if their type is public
		System.out.println("Student 2 : \n" + s2.name + "\n" + s2.rollNo + "\n" + s2.std + "\n");
		
		// if your bean has toString method so you can directly print the object it will call toString method
		System.out.println("Student 3 : \n" + s3);
		
		// accessing object types
		System.out.println("Student 4 : \n" + s4.name + "\n" + s4.rollNo + "\n" + s4.std + "\n" + s4.getAddress().getCity() + "\n" + s4.address.getState() + "\n");
		
	}

}