package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Employee;

@Controller
public class MyController {

    @RequestMapping("/")
    public String getFirstPage() {
        return "home.html";
    }

    @RequestMapping("/signin")
    public String getLogin() {
        return "login.html";
    }
    @PostMapping("/verify")
    
    @RequestMapping("/register")
    public String register() {
    	return "empRegister.html";
    }
    
    @PostMapping("/register_emp")
    public String registerUser(Employee e, String confirmpwd) {
        System.out.println(e);
        return "<h2>Employee Registered</h2>";
    }
}