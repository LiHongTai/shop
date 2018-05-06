package com.roger.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roger.shop.model.Category;
import com.roger.shop.service.CategoryService;
import com.roger.shop.util.QueryParamExecutor;

@SuppressWarnings("unchecked")
@Service(value = "categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		String hql = "FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE :type";
		return getSession().createQuery(hql)//
				.setParameter("type", QueryParamExecutor.contains(type))//
				.setFirstResult((page - 1) * size)//
				.setMaxResults(size)//
				.list();
	}

	@Override
	public Long getCount(String type) {
		String hql = "SELECT COUNT(c) FROM Category c WHERE c.type LIKE :type";
		return (Long) getSession().createQuery(hql)//
				.setParameter("type", QueryParamExecutor.contains(type))//
				.uniqueResult();
	}

	@Override
	public Integer deleteByIds(String ids) {
		String hql = "DELETE FROM Category c WHERE c.id in " + QueryParamExecutor.in(ids);
		return getSession().createQuery(hql)//
				.executeUpdate();
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql = "FROM Category c WHERE c.hot = :hot";
		return getSession().createQuery(hql)//
				.setParameter("hot", hot)//
				.list();
	}

}
