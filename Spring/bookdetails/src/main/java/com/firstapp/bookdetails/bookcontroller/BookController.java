package com.firstapp.bookdetails.bookcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.bookdetails.model.Book;
import com.firstapp.bookdetails.services.BookServices;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookServices service;

	@PostMapping(value = "/post")
	public <S extends Book> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/get/{id}")
	public Optional<Book> findById(Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<Book> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(Integer id) {
		service.deleteById(id);
	}

}