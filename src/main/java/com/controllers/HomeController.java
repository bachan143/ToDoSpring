package com.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Todo;

@Controller
public class HomeController {
	
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("page", "home");
		List<Todo> list=(List<Todo>) context.getAttribute("list");
		System.out.println(list);
	   
	   
		model.addAttribute("todos", list);
		return "home";
	}
	@RequestMapping("/add")
	public String addTodo(Model model)
	{
		Todo t=new Todo();
		model.addAttribute("page", "add");
		model.addAttribute("todo", t);
		return "home";
	}
	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") Todo t, Model model)
	{
		System.out.println(t);
		t.setTodoDate(new Date());
		    List<Todo>  list = (List<Todo>) context.getAttribute("list");
		    list.add(t);
		    model.addAttribute("msg", "successfully added ");
		 return "home";
	}
	

}
