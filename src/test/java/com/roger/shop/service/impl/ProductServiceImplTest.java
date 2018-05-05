package com.roger.shop.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roger.shop.BaseTestCase;
import com.roger.shop.service.ProductService;

public class ProductServiceImplTest extends BaseTestCase{

	@Autowired
	private ProductService productService;

	@Test
	public void shouldNotNull() {
		Assert.assertNotNull(productService);
	}
}
