package com.roger.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.roger.shop.model.Category;
import com.roger.shop.service.CategoryService;

@SuppressWarnings("unchecked")
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource(name = "localSessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Category category) {
		getSession().save(category);
	}

	@Override
	public void update(Category category) {
		getSession().update(category);
	}

	@Override
	public void deleteById(int id) {
		String hql = "DELETE FROM Category WHERE id = :id";
		getSession().createQuery(hql).setParameter("id", id).executeUpdate();
	}

	@Override
	public Category getById(int id) {
		return getSession().get(Category.class, id);
	}

	
	@Override
	public List<Category> findAll() {
		String hql = "FROM Category";
		return getSession().createQuery(hql).list();
	}

}
