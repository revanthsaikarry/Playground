package com.firstapp.bookdetails.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.bookdetails.model.Author;
import com.firstapp.bookdetails.services.AuthorServices;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

	@Autowired
	private AuthorServices service;

	@PostMapping(value = "/post")
	public <S extends Author> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/get/{id}")
	public Optional<Author> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<Author> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
}
