package com.l;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entities.Todo;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context created...");
		List<Todo> list = new ArrayList<Todo>();
		ServletContext context = sce.getServletContext();
		context.setAttribute("list", list);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
