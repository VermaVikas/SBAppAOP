package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeesDao;
import com.app.model.Employees;

@Service
public class EmployeesServiceImpl implements  EmployeesService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeesDao dao;
	
	public List<Employees> getAllEmployees(){
		List<Employees> employeeList = new ArrayList<Employees>();
		dao.findAll().forEach(employeeList::add);
		logger.info("employeeList size :: "+employeeList.size());
		
		return employeeList;
	}
	
	public Employees getEmployeesById(Integer id){
		Employees employee = dao.findOne(id);
		return employee;
	}

	@Override
	public List<Employees> findEmployeesByFirstName(String firstName) {
		List<Employees> employeeList = dao.findEmployeesByFirstName(firstName);
		return employeeList;
	}

}
