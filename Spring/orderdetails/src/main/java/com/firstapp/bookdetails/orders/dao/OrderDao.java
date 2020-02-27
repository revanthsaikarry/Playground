package com.firstapp.bookdetails.orders.dao;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.bookdetails.orders.model.Orders;

public interface OrderDao extends CrudRepository<Orders, Integer>{

}
