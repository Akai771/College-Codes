package com.jdbc;

/*
  This is a POJO (Plain Old Java Object).
  It represents one record (row) of the "students" table in the database.
  
  Table columns:
  rollNo | name | age
*/

public class Student {
	int rollno;		// Roll number of the student
	String name;	// Name of the student
	int age;		// Age of the student

	/*
      Getter and Setter methods
      
      Why getters & setters?
      - Encapsulation (OOP concept)
      - Spring & JDBC use getters/setters to read/write values
     */
	
	// Getter for age
	public int getAge() {
		return age;
	}

	// Setter for age
	public void setAge(int age) {
		this.age = age;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for roll number
	public int getRollno() {
		return rollno;
	}

	// Setter for roll number
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
}