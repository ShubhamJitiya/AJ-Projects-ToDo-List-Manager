package com.ctrl;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Todo;


@Controller
public class HomeCtrl {
	
	@Autowired
	ServletContext context;

	@RequestMapping("/home")
	public String home(Model m) {
		String str = "home";
		List<Todo> list = (List<Todo>)context.getAttribute("list");
		m.addAttribute("todos", list);
		m.addAttribute("page", str);
		return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model m) {
		String str = "home";
		Todo t = new Todo();
		m.addAttribute("todo", t);
		m.addAttribute("page", "add");
		return "home";
	}

	@RequestMapping("/view")
	public String viewTodo(Model m) {
		m.addAttribute("page", "view");
		return "home";
	}

	@RequestMapping(value="/saveTodo", method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {
		System.out.println(t);
		t.setDate(new java.util.Date());
		
		//getting the todo from context
		List<Todo> list =(List<Todo>)context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg", "Successfully Added");
			
		return "home";
	}
}
