package com.roger.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value = "prototype")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "account")
public class AccountAction extends BaseAction<AccountAction> {

	private static final long serialVersionUID = 2224652352454645220L;

}
