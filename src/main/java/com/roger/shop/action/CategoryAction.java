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

import com.roger.shop.model.Category;

/**
 * ModelDriver接口：必须实现getModel()方法，此方法会把返回的值，压到栈顶中 {"total":3, "rows":[
 * {"account":{"id":1,"login":"admin","name":"小强","password":"admin"},"hot":true,"id":1,"type":"女士休闲"},
 * {"account":{"id":1,"login":"admin","name":"小强","password":"admin"},"hot":true,"id":2,"type":"男士休闲"},
 * {"account":{"id":2,"login":"roger","name":"约翰","password":"roger"},"hot":true,"id":3,"type":"儿童休闲"}
 * ] }
 * 
 * @author Roger.Li
 */

@Controller
@Scope(value = "prototype")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "category")
@Results(value = {
		@Result(name = "list", type = "json", params = { "root", "pageMap", "excludeProperties",
				"rows\\[\\d+\\]\\.account\\.password,rows\\[\\d+\\]\\.account\\.name" }),
		@Result(name = "deleteByIds", type = "stream", params = { "inputName", "inputStream" }),
		@Result(name = "jsonList" ,type = "json" ,params = {"root","jsonList","excludeProperties","\\[\\d+\\]\\.account,\\[\\d+\\]\\.hot"})
		})
@AllowedMethods(value = {"deleteByIds","update","findAll"})
public class CategoryAction extends BaseAction<Category> {

	private static final long serialVersionUID = -3319330936523663059L;

	public String findAll() {
		jsonList = categoryService.findAll();
		return "jsonList";
	}
	
	public String list() {
		pageMap = new HashMap<>();

		List<Category> categories = categoryService.queryJoinAccount(model.getType(), page, rows);
		Long total = categoryService.getCount(model.getType());

		pageMap.put(TOTAL, total);
		pageMap.put(ROWS, categories);

		return "list";
	}

	public String deleteByIds() {
		categoryService.deleteByIds(ids);
		inputStream = new BinaryStreamImpl(Boolean.TRUE.toString().getBytes());
		return "deleteByIds";
	}

	public void save() {
		categoryService.save(model);
	}
	
	public void update() {
		categoryService.update(model);
	}
}
