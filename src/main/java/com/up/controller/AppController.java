package com.up.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.up.dao.EmployeeDAO;
import com.up.model.Employee;

@Controller
public class AppController {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value="/list-employees")
	public ModelAndView listEmployee(ModelAndView model) {
		List<Employee> employees = employeeDAO.getAll();
		model.addObject("listEmployee", employees);
		model.setViewName("index");
		return model;
		
	}
	
	@RequestMapping(value = "/add-employee",method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee emp = new Employee();
		model.addObject("emp", emp);
	    model.setViewName("add");
	    return model;
	}
	
	@RequestMapping(value = "/save-employee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		employeeDAO.add(emp);
	    return new ModelAndView("redirect:/list-employees");
	}
	
	@RequestMapping(value = "/edit-employee", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    Employee emp = employeeDAO.get(id);  
	    ModelAndView model = new ModelAndView("edit");
	    model.addObject("emp", emp);
	    return model;
	}
	
	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute Employee emp) {
		employeeDAO.update(emp);
	    return new ModelAndView("redirect:/list-employees");
	}
	
	@RequestMapping(value = "/delete-employee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDAO.delete(id);
		return new ModelAndView("redirect:/list-employees");
	}
}
