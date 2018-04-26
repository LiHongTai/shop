package com.roger.shop.service.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.roger.shop.model.Category;
import com.roger.shop.service.CategoryService;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource(name = "localSessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Category category) {
		Category category2 = new Category();
		category2.setType("男士休闲");
		category2.setHot(Boolean.FALSE);
		getSession().save(category2);
	}

}
