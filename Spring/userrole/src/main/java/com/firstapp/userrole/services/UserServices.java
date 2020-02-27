package com.firstapp.userrole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.userrole.dao.UserDao;
import com.firstapp.userrole.model.User;

@Service
public class UserServices {

	@Autowired
	private UserDao dao;

	public <S extends User> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<User> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<User> findAll() {
		return dao.findAll();
	}

	public Iterable<User> findAllById(Iterable<Integer> ids) {
		return dao.findAllById(ids);
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
