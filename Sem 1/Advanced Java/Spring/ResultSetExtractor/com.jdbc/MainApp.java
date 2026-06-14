package com.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");

		List<Employee> list = dao.getAllEmployees();
		
		for (Employee emp : list) {
			System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
		}

	}

}