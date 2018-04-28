package com.roger.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage(value = "basePackage")
@Namespace(value = "/")
@Action(value = "admin")
@Result(name = "admin", location = "main/admin.jsp")
public class SendAction extends ActionSupport {

	private static final long serialVersionUID = 6680940374523204051L;

	@Override
	public String execute() throws Exception {
		return "admin";
	}
}
