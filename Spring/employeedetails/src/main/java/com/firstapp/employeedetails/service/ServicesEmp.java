package com.firstapp.employeedetails.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.employeedetails.model.Employee;

@Service
public class ServicesEmp {
	
	@Autowired
	private Dao dao;

	public <S extends Employee> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Employee> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Employee> findAll() {
		return dao.findAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
	
}
