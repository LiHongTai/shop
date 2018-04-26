package com.roger.shop.ssh;

import org.hibernate.Session;
import org.junit.Test;

import com.roger.shop.BaseTestCase;
import com.roger.shop.model.Category;
import com.roger.shop.util.HibernateSessionFactory;

public class HibernateTest extends BaseTestCase{

	@Test
	public void shouldCreateTableAndInsertOneData() {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Category category = new Category();
		category.setType("男士休闲");
		category.setHot(Boolean.TRUE);
		
		session.save(category);
		
		session.getTransaction().commit();
		
		HibernateSessionFactory.closeSession();
	}
}
