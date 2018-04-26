package com.roger.shop.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.roger.shop.service.CategoryService;

@Controller(value = "categoryAction")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "category")
@Result(name="index",location="view/index.jsp")
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = -3319330936523663059L;

	@Resource(name = "categoryService")
	private CategoryService categoryService;
	
	public String save() {
		categoryService.save(null);
		return "index";
	}
}
