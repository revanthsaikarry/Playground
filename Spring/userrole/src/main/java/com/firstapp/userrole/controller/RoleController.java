package com.firstapp.userrole.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.userrole.model.Roles;
import com.firstapp.userrole.services.RoleServices;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleServices service;

	@PostMapping(value = "/post")
	public <S extends Roles> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/get/{id}")
	public Optional<Roles> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<Roles> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(Integer id) {
		service.deleteById(id);
	}

}
