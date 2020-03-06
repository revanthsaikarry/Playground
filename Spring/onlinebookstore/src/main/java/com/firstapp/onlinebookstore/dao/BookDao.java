package com.firstapp.onlinebookstore.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.onlinebookstore.model.Book;

public interface BookDao extends CrudRepository<Book, Integer>{

}
