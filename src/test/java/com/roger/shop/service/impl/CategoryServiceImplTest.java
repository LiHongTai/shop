package com.roger.shop.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roger.shop.BaseTestCase;
import com.roger.shop.model.Account;
import com.roger.shop.model.Category;
import com.roger.shop.service.CategoryService;

public class CategoryServiceImplTest extends BaseTestCase{

	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void shouldAddCategory() {
		Category category = new Category();
		category.setType("男士休闲");
		category.setHot(Boolean.TRUE);
		Account account = new Account();
		account.setId(2);
		category.setAccount(account);
		categoryService.save(category);
	}
	
	@Test
	public void shouldQueryJoinAccount() {
		String type = "休闲";
		List<Category> categories = categoryService.queryJoinAccount(type,2,2);
		for (Category category : categories) {
			System.out.println(category.toString() + category.getAccount());
		}
	}
	
	@Test
	public void shouldGetCount() {
		String type = "休闲";
		Long count = categoryService.getCount(type);
		System.out.println("总记录数：" + count);
	}

}
