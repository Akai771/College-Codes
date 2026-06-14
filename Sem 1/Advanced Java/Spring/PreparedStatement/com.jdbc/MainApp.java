package com.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
  Main class
  Program execution starts from here
 */
public class MainApp {

	public static void main(String[] args) {

		/*
		 * Step 1: Load Spring Container Reads Bean.xml Creates all beans
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		/*
		 * Step 2: Get StudentDAO bean from Spring container
		 */
		StudentDAO dao = (StudentDAO) context.getBean("studentDao");

		/*
		 * Step 3: Create Student object (model object)
		 */
		Student s = new Student(21, "Ashish", 25);

		/*
		 * Step 4: Insert record into database
		 */
		int status = dao.insert(s);
		if (status > 0) {
			System.out.println("Record inserted");
		} else {
			System.out.println("insert failed");
		}

		/*
		 * Step 5: Fetch all student records
		 */
		List<Student> list = dao.display();
		System.out.println("Student Records:");

		/*
		 * Step 6: Iterate and print records
		 */
		for (Student st : list) {
			System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge()

			);
		}

	}

}