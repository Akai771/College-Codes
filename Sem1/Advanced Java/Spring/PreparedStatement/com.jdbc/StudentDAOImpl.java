package com.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

/*
  This is the IMPLEMENTATION class of StudentDAO.
  
  Responsibilities:
   - Execute SQL queries
   - Use Spring JdbcTemplate
   - Convert DB rows into Student objects
 */

public class StudentDAOimpl implements StudentDAO {

	/*
	 * JdbcTemplate is the core Spring JDBC class.
	 * 
	 * It: - Uses PreparedStatement internally - Manages Connection, Statement,
	 * ResultSet - Reduces boilerplate JDBC code
	 */

	private JdbcTemplate jdbcTemplate;

	/*
	 * Setter method for DataSource
	 * 
	 * Spring calls this method automatically (Setter Dependency Injection)
	 */

	public void setDataSource(DataSource dataSource) {
		// JdbcTemplate needs DataSource to connect to DB
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * INSERT operation
	 * 
	 * Demonstrates PreparedStatement using Spring JdbcTemplate
	 */
	@Override
	public int insert(Student s) {
		// SQL query with ? placeholders PreparedStatemen
		String sql = "insert into students values (?,?,?)";

		/*
		 * jdbcTemplate.update(): - Creates PreparedStatement internally - Calls
		 * setValues() - Executes INSERT query
		 */
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			/*
			 * This method sets values into ? placeholders
			 */
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, s.getRollno());
				ps.setString(2, s.getName());
				ps.setInt(3, s.getAge());
			}
		});

	}

	/*
	 * SELECT operation
	 * 
	 * Fetches all rows from students table
	 */
	@Override
	public List<Student> display() {
		String sql = "select * from students";

		/*
		 * jdbcTemplate.query(): - Executes SELECT query - Calls mapRow() for each row -
		 * Returns List<Student>
		 */

		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			/*
			 * mapRow() is called ONCE per row
			 * 
			 * ResultSet Student object
			 */
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// Create Student object using DB values
				Student s = new Student(rs.getInt("rollno"), rs.getString("name"), rs.getInt("age"));
				return s;
			}
		});
	}
}