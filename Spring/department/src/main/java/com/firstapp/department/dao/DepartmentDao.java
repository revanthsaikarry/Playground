package com.firstapp.department.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.department.model.Departments;

public interface DepartmentDao extends CrudRepository<Departments, Integer>{

}
