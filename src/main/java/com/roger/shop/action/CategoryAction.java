package com.roger.shop.action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.roger.shop.model.Category;

/**
 * ModelDriver接口：必须实现getModel()方法，此方法会把返回的值，压到栈顶中
 * 
 * @author Roger.Li
 */

@Controller
@Scope(value = "prototype")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "category")
@Results(value = { @Result(name = "list", type = "json", params = { "root", "pageMap" }) })
public class CategoryAction extends BaseAction<Category> {

	private static final long serialVersionUID = -3319330936523663059L;

	public String list() {
		pageMap = new HashMap<>();

		List<Category> categories = categoryService.queryJoinAccount(model.getType(), page, rows);
		Long total = categoryService.getCount(model.getType());

		pageMap.put(TOTAL, total);
		pageMap.put(ROWS, categories);

		return "list";
	}

}
