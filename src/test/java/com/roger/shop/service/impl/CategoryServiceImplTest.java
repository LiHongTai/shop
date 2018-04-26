package com.roger.shop.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roger.shop.BaseTestCase;
import com.roger.shop.model.Category;
import com.roger.shop.service.CategoryService;

public class CategoryServiceImplTest extends BaseTestCase{

	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void shouldAddCategory() {
		Category category = new Category();
		category.setType("女士休闲");
		category.setHot(Boolean.TRUE);
		categoryService.save(category);
	}

}
