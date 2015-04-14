package com.test.ui.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.ui.business.layer.StudentBusinessService;

@Controller
public class StudentController {
	
	@Autowired
	StudentBusinessService stuService;
	
	@RequestMapping(method=RequestMethod.GET,value="showStudentDetails")
	public ModelAndView showEmpInputPage(@QueryParam(value="sno") int sno){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student"); //jsp page
		modelAndView.addObject("student", stuService.getStudent(sno));
		return modelAndView;
	}

}
