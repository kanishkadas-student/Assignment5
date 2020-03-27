package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView insertPage() {

		ModelAndView mv = new ModelAndView("create");

		Student student = new Student();

		mv.addObject("student", student);

		return mv;

	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("student") Student student) {
		// Read the request parameter
		
		// insert student to db

		int res = studentService.create(student);

		ModelAndView mv = new ModelAndView("create");
		System.out.println("Model Attribute:" + student);
		if (res > 0)
			mv.addObject("msg", "Record Inserted");
		else
			mv.addObject("msg", "Record Not Inserted");

		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatepage() {
		ModelAndView mv = new ModelAndView("update");

		Student student = new Student();

		mv.addObject("student", student);

		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("student") Student student) {
		// Read the request parameter
		
		// insert student to db

		int res = studentService.update(student);

		ModelAndView mv = new ModelAndView("update");
		System.out.println("Model Attribute:" + student);
		if (res > 0)
			mv.addObject("msg", "Record Updated");
		else
			mv.addObject("msg", "Record Not Updated");

		return mv;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deletePage() {
		
		ModelAndView mv = new ModelAndView("delete");

		Student student = new Student();

		mv.addObject("student", student);

		return mv;
		//return "delete";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("student") Student student) {
		// Read the request parameter
		
		// insert student to db

		int res = studentService.delete(student.getId());

		ModelAndView mv = new ModelAndView("delete");
		System.out.println("Model Attribute:" + student);
		if (res > 0)
			mv.addObject("msg", "Record Deleted");
		else
			mv.addObject("msg", "Record Not Deleted");

		return mv;
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("display");

		List<Student> list = studentService.findAll();

		mv.addObject("list", list);

		return mv;

	}
	
	@RequestMapping(value = "findByName", method = RequestMethod.GET)
	public String findByNamePage() {
		return "findByName";
//		ModelAndView mv = new ModelAndView("findByName");
//
//		Student student = new Student();
//
//		mv.addObject("student", student);
//
//		return mv;
		//return "delete";
	}
	
	@RequestMapping(value = "findByName", method = RequestMethod.POST)
	public String findByName(HttpServletRequest request) {
		// Read the request parameter
		String name= request.getParameter("name");
		// insert student to db
		List <Student> list = studentService.findByName(name);
		request.setAttribute("list", list);
		
		return "display";
	}
	
	@RequestMapping(value = "count", method = RequestMethod.GET)
	public ModelAndView CountStudent() {
		
		ModelAndView mv = new ModelAndView("count");

		Student student = new Student();
		
		int countSize = studentService.findAll().size();

		mv.addObject("student", student);
		
		if (countSize > 0)
			mv.addObject("msg", countSize);
		else
			mv.addObject("msg", "0");

		return mv;
		//return "delete";
	}

}
