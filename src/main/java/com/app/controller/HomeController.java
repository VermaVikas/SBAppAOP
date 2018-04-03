package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Employees;
import com.app.service.EmployeesService;

@RestController
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeesService service;
	
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employees>> getAllEmployees() {
		
		logger.info(" IN Controller :: getAllEmployees");
		
		List<Employees> list = service.getAllEmployees();
		logger.info("list.size() :: " + list.size());
		if (list != null && list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public ResponseEntity<Employees> getEmployeeById(@RequestParam(name = "id") Integer id) {

		Employees employee = service.getEmployeesById(id);
		if (employee != null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/getEmployeeByFirstName", method = RequestMethod.GET)
	public ResponseEntity<List<Employees>> getEmployeeByFirstName(@RequestParam(name = "first_name") String firstName) {

		List<Employees> list = service.findEmployeesByFirstName(firstName);
		System.out.println("list.size() :: " + list.size());
		if (list != null && list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes="multipart/form-data")
	public ResponseEntity<String> uploadFile(
			@RequestPart(name="userfile", required=true) MultipartFile multipartFile) {
		
		System.out.println("file name :: " + multipartFile.getName());
		
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	
}
