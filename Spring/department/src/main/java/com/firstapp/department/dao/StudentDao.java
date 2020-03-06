package com.firstapp.department.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.department.model.Student;

public interface StudentDao extends CrudRepository<Student, Integer>{

}
