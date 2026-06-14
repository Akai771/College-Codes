package com.jdbc;

import javax.sql.DataSource;

/*
  This is a DAO (Data Access Object) Interface.
  
  Purpose:
  	- Defines database operations
  	- Implementation class (StudentTemp) will provide logic
  
  NOTE:
  Extending DataSource is NOT required here in real projects.
  You usually just create a DAO interface.
  But this still works conceptually.
*/

public interface StudentInterface extends DataSource {
	
	/*
      Used by Spring to inject DataSource
      (Dependency Injection concept)
    */
	
	public void setDataSource(DataSource datasource);
	
	/*
      Method to insert a student record into database
    */
	public void insert(int rollno,String name,int age);
	
	//	Other methods like update and delete will be implemented by implementation class

}