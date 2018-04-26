package com.roger.shop.service;

import java.util.List;

public interface BaseService<T> {
	
	void save(T t);
	
	void update(T t);
	
	void deleteById(int id);
	
	T getById(int id);
	
	List<T> findAll();

}
