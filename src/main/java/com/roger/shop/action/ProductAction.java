package com.roger.shop.action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.engine.jdbc.internal.BinaryStreamImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.roger.shop.model.Product;

@Controller
@Scope(value = "prototype")
@ParentPackage(value = "basePackage")
@Namespace(value = "/")
@Action(value = "product")
@Results({
		@Result(name = "list", type = "json", params = { "root", "pageMap", "excludeProperties",
				"rows\\[\\d+\\]\\.category\\.account" }),
		@Result(name = "deleteByIds", type = "stream", params = { "inputName", "inputStream" }) })
@AllowedMethods(value = { "deleteByIds", "update", "findAll" })
public class ProductAction extends BaseAction<Product> {
	private static final long serialVersionUID = -511729892841953642L;

	public String list() {
		pageMap = new HashMap<>();
		List<Product> products = productService.queryJoinCategory(model.getName(), page, rows);
		Long total = productService.getCount(model.getName());
		pageMap.put(TOTAL, total);
		pageMap.put(ROWS, products);
		return "list";
	}

	public String deleteByIds() {
		productService.deleteByIds(ids);
		inputStream = new BinaryStreamImpl(Boolean.TRUE.toString().getBytes());
		return "deleteByIds";
	}

	public void save() throws Exception {
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		productService.save(model);
	}

	public void upate() {
		productService.update(model);
	}
}
