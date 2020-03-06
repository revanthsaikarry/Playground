package com.firstapp.department.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.department.model.Subject;
import com.firstapp.department.services.SubjectService;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

	@Autowired
	private SubjectService service;

	@PostMapping(value = "/post")
	public <S extends Subject> S save(@RequestBody S entity) {
		return service.save(entity);
	}

	@GetMapping(value = "/find/{id}")
	public Optional<Subject> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping(value = "/findall")
	public Iterable<Subject> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/getcount")
	public long count() {
		return service.count();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@DeleteMapping(value = "/delete/{entity}")
	public void delete(@RequestBody Subject entity) {
		service.delete(entity);
	}

}
