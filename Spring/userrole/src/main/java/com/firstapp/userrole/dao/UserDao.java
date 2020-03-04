package com.firstapp.userrole.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.firstapp.userrole.model.User;

public interface UserDao extends CrudRepository<User, Integer>{

	@Query("select login from User where id = ?1")
	public String findUserNameById(int id);
}
