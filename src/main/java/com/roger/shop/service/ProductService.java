package com.roger.shop.service;

import java.util.List;

import com.roger.shop.model.Product;

public interface ProductService extends BaseService<Product> {

	List<Product> queryJoinCategory(String name, Integer page, Integer size);
	
	Long getCount(String name);
	
	void deleteByIds(String ids);
}
