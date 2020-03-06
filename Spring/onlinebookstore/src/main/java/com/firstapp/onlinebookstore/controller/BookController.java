package com.firstapp.onlinebookstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.onlinebookstore.model.Book;
import com.firstapp.onlinebookstore.service.BookServices;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookServices service;

	@PostMapping(value = "/post")
	public <S extends Book> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/getbook/{id}")
	public Optional<Book> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<Book> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/getbookcount")
	public long count() {
		return service.count();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@DeleteMapping(value = "/delete/{entity}")
	public void delete(Book entity) {
		service.delete(entity);
	}
	
	
}
