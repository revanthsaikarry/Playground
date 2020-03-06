package com.firstapp.onlinebookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.onlinebookstore.dao.BookDao;
import com.firstapp.onlinebookstore.model.Book;

@Service
public class BookServices {

	@Autowired
	private BookDao dao;

	public <S extends Book> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Book> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Book> findAll() {
		return dao.findAll();
	}

	public long count() {
		return dao.count();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public void delete(Book entity) {
		dao.delete(entity);
	}
	
	
	
}
