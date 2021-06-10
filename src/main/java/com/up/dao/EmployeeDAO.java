package com.up.dao;

import java.util.List;

import com.up.model.Employee;

public interface EmployeeDAO {
	List<Employee> getAll();
	Employee get(int id);
	void add(Employee employee);
	void delete(int id);
	void update(Employee employee);
}
