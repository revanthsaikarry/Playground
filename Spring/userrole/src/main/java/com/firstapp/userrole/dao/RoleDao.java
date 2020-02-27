package com.firstapp.userrole.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.userrole.model.Roles;

public interface RoleDao extends CrudRepository<Roles, Integer>{

}
