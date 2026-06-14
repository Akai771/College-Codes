package com.jdbc;

import java.util.List;

/*
  DAO = Data Access Object
  
  Purpose:
   - Declares database operations
   - Hides database logic from MainApp
  
  Why interface?
   - Loose coupling
   - Easy to change implementation later
 */

public interface StudentDAO {

	/*
	 * Insert one student record into database Returns number of rows affected
	 */
	int insert(Student s);

	/*
	 * Fetch all student records from database Returns List of Student objects
	 */
	List<Student> display();
}