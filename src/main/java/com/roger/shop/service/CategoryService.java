package com.roger.shop.service;

import java.util.List;

import com.roger.shop.model.Category;

public interface CategoryService extends BaseService<Category> {

	List<Category> queryJoinAccount(String type,int page, int size);
	
	Long getCount(String type);
	
	Integer deleteByIds(String ids);
}
