package com.firstapp.department.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.department.dao.SubjectDao;
import com.firstapp.department.model.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectDao dao;

	public <S extends Subject> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Subject> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Subject> findAll() {
		return dao.findAll();
	}

	public long count() {
		return dao.count();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public void delete(Subject entity) {
		dao.delete(entity);
	}

}
