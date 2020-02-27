package com.firstapp.bookdetails.items.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.bookdetails.items.dao.ItemsDao;
import com.firstapp.bookdetails.items.model.Items;

@Service
public class ItemsServices {

	@Autowired
	private ItemsDao dao;

	public <S extends Items> S save(S entity) {
		return dao.save(entity);
	}

	public Optional<Items> findById(Integer id) {
		return dao.findById(id);
	}

	public Iterable<Items> findAll() {
		return dao.findAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
