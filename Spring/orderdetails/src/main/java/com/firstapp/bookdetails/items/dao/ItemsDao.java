package com.firstapp.bookdetails.items.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.bookdetails.items.model.Items;

public interface ItemsDao extends CrudRepository<Items, Integer>{

}
