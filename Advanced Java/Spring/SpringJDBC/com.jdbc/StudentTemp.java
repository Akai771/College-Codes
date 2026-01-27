package com.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource; // For database connection

import org.springframework.jdbc.core.JdbcTemplate; // For executing SQL queries

/*
   This class IMPLEMENTS StudentInterface.
  
   Responsibilities:
    - Connect to database using DataSource
    - Execute SQL queries using JdbcTemplate
  
   JdbcTemplate:
    - Core class of Spring JDBC
    - Removes boilerplate code (Connection, PreparedStatement, etc.)
*/

public class StudentTemp implements StudentInterface {
	JdbcTemplate jdbcTempletObject; // Spring's JdbcTemplate to execute queries
	DataSource dataSource; // DataSource object to get database connection

	// Many methods below are required because interface extends DataSource
	// You can ignore these for Spring JDBC
	@Override
	public Connection getConnection() throws SQLException {
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	// This method is called by Spring to inject the DataSource
	public void setDataSource(DataSource datasource) {
		this.dataSource = datasource;				// store the datasource
		this.jdbcTempletObject = new JdbcTemplate(datasource);		// create JdbcTemplate, JdbcTemplate needs DataSource to connect to DB
	}

	// Method to insert a record into students table
	public void insert(int rollno, String name, int age) {
		String sql = "insert into students(rollno,name,age) values(?,?,?)";
		jdbcTempletObject.update(sql, rollno, name, age);		// execute insert query
		System.out.println("Record Inserted");			// print confirmation
	}

	// Method to update a student record
	public void update(int rollno, String name, int age) {
		String sql = "update students set name=?,age=? where rollno=?";
		jdbcTempletObject.update(sql, name, age, rollno);		// execute update query
		System.out.println("Record updated");				// print confirmation
	}

	// Method to delete a student record
	public void delete(int rollno) {
		String sql = "delete from students where rollno=?";
		jdbcTempletObject.update(sql, rollno);			// execute delete query
		System.out.println("Record deleted");			// print confirmation
	}
}