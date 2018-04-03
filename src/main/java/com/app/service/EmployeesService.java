package com.app.service;

import java.util.List;
import com.app.model.Employees;

public interface EmployeesService {
	
	public List<Employees> getAllEmployees();
	
	public Employees getEmployeesById(Integer id);
	
	
	public List<Employees> findEmployeesByFirstName(String firstName);
}
