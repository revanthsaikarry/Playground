package com.firstapp.bookdetails.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.bookdetails.dao.Dao;
import com.firstapp.bookdetails.model.Book;

@Service
public class BookServices {

	@Autowired
	private Dao dao;

	public <S extends Book> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Book> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Book> findAll() {
		return dao.findAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
