package com.firstapp.userrole.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.userrole.dao.RoleDao;
import com.firstapp.userrole.model.Roles;

@Service
public class RoleServices {

	@Autowired
	private RoleDao dao;

	public <S extends Roles> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Roles> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Roles> findAll() {
		return dao.findAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
	
}
