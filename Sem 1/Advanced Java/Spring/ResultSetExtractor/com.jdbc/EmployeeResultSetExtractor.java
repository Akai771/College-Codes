package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeResultSetExtractor implements ResultSetExtractor<List<Employee>> {
	
	public List<Employee> extractData(ResultSet rs) throws SQLException {

        List<Employee> list = new ArrayList<Employee>();

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setSalary(rs.getDouble("salary"));

            list.add(emp);
        }
        return list;
    }
}