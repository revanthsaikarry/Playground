package com.firstapp.bookdetails.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.bookdetails.dao.DaoAuthor;
import com.firstapp.bookdetails.model.Author;

@Service
public class AuthorServices{

	@Autowired
	private DaoAuthor service;

	public <S extends Author> S save(S entity) {
		return service.save(entity);
	}

	public Optional<Author> findById(Integer id) {
		return service.findById(id);
	}

	public Iterable<Author> findAll() {
		return service.findAll();
	}

	public void deleteById(Integer id) {
		service.deleteById(id);
	}
	
	
}
