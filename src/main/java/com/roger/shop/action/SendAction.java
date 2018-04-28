package com.roger.shop.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 此Action用于来完成 WEB-INF中 jsp与jsp请求转发的功能，不处理任何的逻辑 
 * @author Roger.Li
 */
@Controller
public class SendAction extends ActionSupport {

	private static final long serialVersionUID = 6680940374523204051L;

	@Override
	public String execute(){
		return "send";
	}
}
