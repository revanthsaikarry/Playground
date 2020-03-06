package com.firstapp.department.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.department.model.Subject;

public interface SubjectDao extends CrudRepository<Subject, Integer>{

}
