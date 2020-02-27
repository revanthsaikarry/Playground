package com.firstapp.bookdetails.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.bookdetails.model.Book;

public interface Dao extends CrudRepository<Book, Integer>{

}
