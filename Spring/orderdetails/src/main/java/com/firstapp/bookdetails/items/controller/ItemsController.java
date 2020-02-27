package com.firstapp.bookdetails.items.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.bookdetails.items.model.Items;
import com.firstapp.bookdetails.items.services.ItemsServices;

@RestController
@RequestMapping(value = "/items")
public class ItemsController {

	@Autowired
	private ItemsServices service;

	@PostMapping(value = "/post")
	public <S extends Items> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/get/{id}")
	public Optional<Items> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<Items> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(Integer id) {
		service.deleteById(id);
	}

}
