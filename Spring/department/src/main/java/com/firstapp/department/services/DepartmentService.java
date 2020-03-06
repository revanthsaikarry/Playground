package com.firstapp.department.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.department.dao.DepartmentDao;
import com.firstapp.department.model.Departments;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao dao;

	public <S extends Departments> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Departments> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Departments> findAll() {
		return dao.findAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
	
}
