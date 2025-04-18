package com.taskStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taskStore.entity.empList;
import com.taskStore.entity.taskList;
import com.taskStore.service.empListService;
import com.taskStore.service.taskService;


@Controller
public class taskController {
	
	@Autowired
	private taskService service;
	
	@Autowired
	private empListService myTaskService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/new_Task")
	public String taskRegister() {
		return "taskRegister";
	}
	
	@GetMapping("/task_List")
	public ModelAndView getAllTask() {
		List<taskList>list=service.getAllTask();
		return new ModelAndView("taskList","Task",list);
	}
	
	@PostMapping("/save")
	public String addTask(@ModelAttribute taskList b) {
		service.save(b);
		return "redirect:/task_List";
	}
	@GetMapping("/emp_List")
	public String getMyTask(Model model)
	{
		List<empList>list=myTaskService.getAllMyTask();
		model.addAttribute("Task",list);
		return "empList";
	}
	@GetMapping("/emp_Id")
	public String getEmpId(Model model) {
		return "assignTaskById";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		taskList b=service.getTaskById(id);
		empList mb=new empList(b.getId(),b.getTask(),b.getTaskDetail(),b.getStatus());
		myTaskService.saveMyTask(mb);
		return "redirect:/emp_Id";
	}
	
	@RequestMapping("/taskEdit/{id}")
	public String editTask(@PathVariable("id") int id,Model model) {
		taskList b=service.getTaskById(id);
		model.addAttribute("Task",b);
		return "taskEdit";
	}
	@RequestMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/task_List";
	}
	
}