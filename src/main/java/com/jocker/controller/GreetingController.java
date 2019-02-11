package com.jocker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller is mandatory here
@Controller
public class GreetingController {
	
	
	public GreetingController(){
		System.out.println("GreetingControllerGreetingControllerGreetingControllerGreetingControllerGreetingControllerGreetingController");
	}
	
	//  	<form action="greet" method="get">
	//greet
	@GetMapping("welcome")
	public String greetMe(HttpServletRequest req){
		String gname=req.getParameter("gname");
		gname="Hello Mr. "+gname+" , how are you doing???";
		req.setAttribute("message", gname);
		return "greet"; //no need to write extension
	}
	
	@PostMapping("studentRegistration")
	public String registeStudent(HttpServletRequest req,Model model){
		String name=req.getParameter("name");
		String gender=req.getParameter("gender");
		String school=req.getParameter("school");
		String fname=req.getParameter("fname");
		Student student=new Student(name,gender,school,fname);
		System.out.println(student);
		//
		
		//model is used to carry data from controller to jsp
		//it is similar to req.setAttribute("student", student);
		model.addAttribute("student", student);
		return "success"; //no need to write extension
	}
	

}
