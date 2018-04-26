package com.roger.shop.service.impl;

import org.springframework.stereotype.Service;

import com.roger.shop.model.Category;
import com.roger.shop.service.CategoryService;

@Service(value = "categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

}
