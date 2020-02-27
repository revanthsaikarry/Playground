package com.firstapp.bookdetails.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.bookdetails.model.Author;

public interface DaoAuthor extends CrudRepository<Author, Integer>{

}
