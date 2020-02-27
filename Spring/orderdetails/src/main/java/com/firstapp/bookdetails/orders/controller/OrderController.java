package com.firstapp.bookdetails.orders.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.bookdetails.orders.model.Orders;
import com.firstapp.bookdetails.orders.services.OrderServices;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderServices service;

	@PostMapping(value = "/post")
	public <S extends Orders> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/get/{id}")
	public Optional<Orders> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<Orders> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
