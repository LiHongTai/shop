package com.roger.shop.task;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.roger.shop.model.Category;
import com.roger.shop.model.Product;
import com.roger.shop.service.CategoryService;
import com.roger.shop.service.ProductService;

@Component(value = "dynamicRefreshDataTimeTask")
public class DynamicRefreshDataTimeTask extends TimerTask {
	
	@Resource
	private ProductService productService;
	
	@Resource
	private CategoryService categoryService;
	
	private ServletContext servletContext;
	
	@Override
	public void run() {
		List<List<Product>> productListByCid = new ArrayList<>();
		for(Category category : categoryService.queryByHot(true)) {
			productListByCid.add(productService.queryByCid(category.getId()));
		}
		servletContext.setAttribute("bigList", productListByCid);
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
