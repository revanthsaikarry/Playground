package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Software;

public interface SoftwareRepo extends CrudRepository<Software, Integer> {
	List<Software> findBySname(String sname);
	List<Software> findBySidGreaterThan(int sid);

	@Query("from Software order by sname")
	List<Software> findBySortedSname();
}
