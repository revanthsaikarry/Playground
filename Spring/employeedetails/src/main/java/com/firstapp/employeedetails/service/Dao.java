package com.firstapp.employeedetails.service;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.employeedetails.model.Employee;

public interface Dao extends CrudRepository<Employee,Integer>{
	
}
