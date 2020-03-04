package com.firstapp.userrole.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.userrole.model.User;
import com.firstapp.userrole.services.UserServices;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserServices service;

	@PostMapping(value = "/post")
	public <S extends User> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/get/{id}")
	public Optional<User> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/getall")
	public Iterable<User> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	@GetMapping(value = "/getuname/{id}")
	public String findUserNameById(@PathVariable int id){
		return service.findUserNameById(id);
	}
	
	@PutMapping(value = "/update")
	public User update(@RequestBody User user) {
		return service.save(user);
	}

}
