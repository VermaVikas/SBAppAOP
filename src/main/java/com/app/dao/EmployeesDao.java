package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.app.model.Employees;

@Component
public interface EmployeesDao extends CrudRepository<Employees, Integer> {
	
	public List<Employees> findEmployeesByFirstName(String firstName);
	
}
