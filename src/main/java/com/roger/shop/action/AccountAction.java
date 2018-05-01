package com.roger.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.roger.shop.model.Account;

@Controller
@Scope(value = "prototype")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "account")
@Results(value = { @Result(name = "jsonList", type = "json", params = { "root", "jsonList", "excludeProperties",
		"\\[\\d+\\]\\.password,\\[\\d+\\]\\.name" }) })
@AllowedMethods(value = "findAll")
public class AccountAction extends BaseAction<Account> {

	private static final long serialVersionUID = 2224652352454645220L;

	public String findAll() {
		jsonList = accountService.findAll();
		return "jsonList";
	}

}
