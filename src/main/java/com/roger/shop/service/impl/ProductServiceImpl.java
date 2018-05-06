package com.roger.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roger.shop.model.Product;
import com.roger.shop.service.ProductService;
import com.roger.shop.util.QueryParamExecutor;

@SuppressWarnings("unchecked")
@Service(value = "productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public List<Product> queryJoinCategory(String name, Integer page, Integer size) {
		String hql = "FROM Product p LEFT JOIN FETCH p.category WHERE p.name like :name ";
		return getSession().createQuery(hql)//
				.setParameter("name", QueryParamExecutor.contains(name))//
				.setFirstResult((page-1)*size)//
				.setMaxResults(size)//
				.list();
	}

	@Override
	public Long getCount(String name) {
		String hql = "SELECT COUNT(p) FROM Product p WHERE p.name like :name";
		return (Long) getSession().createQuery(hql)//
				.setParameter("name", QueryParamExecutor.contains(name))//
				.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql = "DELETE FROM Product p WHERE p.id in " + QueryParamExecutor.in(ids);
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		String hql = "FROM Product p JOIN FETCH p.category WHERE p.category.id = :cid AND p.commend = true AND p.open = true ";
		return getSession().createQuery(hql)//
				.setParameter("cid", cid)//
				.setFirstResult(0)//
				.setMaxResults(4)//
				.list();
	}
}
