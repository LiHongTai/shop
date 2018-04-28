package com.roger.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.roger.shop.service.BaseService;

@SuppressWarnings("unchecked")
@Service(value = "baseService")
public class BaseServiceImpl<T> implements BaseService<T> {

	private Class<T> clazz;

	//如果没有指定名称,则默认属性名称和id绑定
	@Resource(name = "localSessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void deleteById(int id) {
		String hql = "DELETE FROM " + clazz.getSimpleName() + " WHERE id = :id";
		getSession().createQuery(hql).setParameter("id", id).executeUpdate();
	}

	@Override
	public T getById(int id) {
		return getSession().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		String hql = "FROM " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

}
