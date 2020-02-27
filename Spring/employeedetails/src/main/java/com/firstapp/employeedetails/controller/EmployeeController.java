package com.firstapp.employeedetails.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.employeedetails.model.Employee;
import com.firstapp.employeedetails.service.ServicesEmp;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	private ServicesEmp service;

	@PostMapping(value = "/post")
	public <S extends Employee> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/getbyid/{id}")
	public Optional<Employee> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<Employee> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/deletebyid/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
