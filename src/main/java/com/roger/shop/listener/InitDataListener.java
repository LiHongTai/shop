package com.roger.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.roger.shop.task.DynamicRefreshDataTimeTask;

public class InitDataListener implements ServletContextListener {

	private ApplicationContext context = null;
	private DynamicRefreshDataTimeTask initDataTimeTask;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		
		initDataTimeTask = (DynamicRefreshDataTimeTask) context.getBean("dynamicRefreshDataTimeTask");
		initDataTimeTask.setServletContext(event.getServletContext());
		
		new Timer(true).schedule(initDataTimeTask, 0, 1000*60*60);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}
}
