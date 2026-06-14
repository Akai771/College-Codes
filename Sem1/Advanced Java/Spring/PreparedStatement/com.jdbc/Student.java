package com.jdbc;

/*
  Student is a POJO (Plain Old Java Object).
  
  Purpose:
  - Represents ONE row of the "students" table in the database
  - Each object = one student record
  
  Database table structure:
  students
  --------------------
  rollNo | name | age
 */

public class Student {

	// These variables map directly to table columns
	private int rollno;
	private String name;
	private int age;

	/*
	 * Parameterized constructor
	 * 
	 * Used when: - Creating Student object in MainApp - Creating Student object
	 * while reading data from ResultSet
	 */

	public Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	/*
	 * Getter methods
	 * 
	 * JdbcTemplate + RowMapper use getters to read values from Student object
	 */

	public int getAge() {
		return age;
	}

	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}
}