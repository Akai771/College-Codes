package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//Main class to run Spring JDBC program
public class MainApp {

	public static void main(String[] args) {
		
		// Load Spring container and read jdbc.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");

		// Get DAO bean from Spring container
		StudentTemp st = (StudentTemp) context.getBean("studentTemp");

		// Perform insert operation
		st.insert(1, "Rahul", 21);
		
		// Perform update operation
		st.update(1, "Tom", 22);
		
		// Perform delete operation
		st.delete(1);
	}
}