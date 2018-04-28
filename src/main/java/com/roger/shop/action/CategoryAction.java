package com.roger.shop.action;

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
 * @author Roger.Li
 */

@Controller
@Scope(value = "prototype")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "category")
@Results(value= {
		@Result(name="index",location="view/index.jsp")
})
public class CategoryAction extends BaseAction<Category>{

	private static final long serialVersionUID = -3319330936523663059L;

	public String save() {
		categoryService.save(model);
		return "index";
	}

}
