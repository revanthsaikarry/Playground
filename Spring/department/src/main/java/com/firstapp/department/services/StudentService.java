package com.firstapp.department.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.department.dao.StudentDao;
import com.firstapp.department.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	public <S extends Student> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Student> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Student> findAll() {
		return dao.findAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
	
}
