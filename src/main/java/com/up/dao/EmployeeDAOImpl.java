package com.up.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.up.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Employee> getAll() {
		
		List<Employee> listEmp = jdbcTemplate.query("SELECT * FROM tbl_employees", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setGender(rs.getString("gender"));
				emp.setEmail(rs.getString("email"));
				emp.setProvince(rs.getString("province"));
				
				return emp;
			}
			
		});
		return listEmp;
	}

	public Employee get(int id) {
		String sql = "SELECT * FROM tbl_employees WHERE id=" + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
	        public Employee extractData(ResultSet rs) throws SQLException,DataAccessException {
	            if (rs.next()) {
	            	Employee emp = new Employee();
	            	emp.setId(rs.getLong("id"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setGender(rs.getString("gender"));
					emp.setEmail(rs.getString("email"));
					emp.setProvince(rs.getString("province"));
					return emp;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public void add(Employee employee) {
		String sql = "INSERT INTO tbl_employees (first_name, last_name, gender, email, province)" + " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getEmail(), employee.getProvince());
		
	}

	public void delete(int id) {
		String sql = "DELETE FROM tbl_employees WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}

	public void update(Employee employee) {
		String sql = "UPDATE tbl_employees SET first_name=?, last_name=?, gender=?, email=?, province=? WHERE id=?";  
		jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getEmail(), employee.getProvince(), employee.getId());
		
	}
}
