package com.firstapp.userrole.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.userrole.model.User;

public interface UserDao extends CrudRepository<User, Integer>{

}
