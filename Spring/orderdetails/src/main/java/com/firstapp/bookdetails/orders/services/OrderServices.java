package com.firstapp.bookdetails.orders.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.bookdetails.orders.dao.OrderDao;
import com.firstapp.bookdetails.orders.model.Orders;

@Service
public class OrderServices {

	@Autowired
	private OrderDao dao;

	public <S extends Orders> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Orders> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Orders> findAll() {
		return dao.findAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
}
