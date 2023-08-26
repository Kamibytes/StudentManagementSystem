package com.kamibytes.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kamibytes.main.entity.Student;
import com.kamibytes.main.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping({"/","/home"})
	public String homePage(Model model)
	{
		List<Student> listStudent = service.listAllStudent();
		
		model.addAttribute("listStudent", listStudent);
		
		return "index";
	}
	
	@GetMapping("/new")
	public String addNewStudent(Model model)
	{
		model.addAttribute("student", new Student());
		
		return "new";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student std)
	{
		service.addStudent(std);
		
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView updateInfo(@PathVariable("id") long id)
	{
		ModelAndView mav = new ModelAndView("new");
		
		Student std = service.updateStudentInfo(id);
		
		mav.addObject("student", std);
		
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") long id)
	{
		service.deleteStudent(id);
		
		return "redirect:/";
	}
	
	
}
