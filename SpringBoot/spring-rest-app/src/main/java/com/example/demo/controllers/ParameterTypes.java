package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Person;

@RestController
public class ParameterTypes {
	
	
	@GetMapping("/query")
	public String queryParamDemo(@RequestParam("user") String name,@RequestParam int age) {
		System.out.println("*** Query Parameter ***"
				+"\nName : "+name
				+"\nAge : "+age);
		return "Welcome! " +name+" and your age "+age;
	}
	
	@GetMapping("/path/{name}/{age}")
	public String pathParamDemo(@PathVariable String name,@PathVariable int age) {
		System.out.println("*** Path Parameter ***"
				+"\nName : "+name
				+"\nAge : "+age);
		return "Welcome! " +name+" and your age "+age;
	}
	
	@GetMapping("/body")
	public String bodyParamDemo(@RequestBody Person p) {
		System.out.println("*** Body Parameter ***"
				+"\nName : "+p.getName()
				+"\nAge : "+p.getAge());
		return "Welcome! " +p.getName()+" and your age "+p.getAge();
	}
	
	@GetMapping(path="/persons",produces="application/xml")
	public List<Person> getPersons() {
		List<Person> list= new ArrayList<Person>();
		list.add(new Person("Aditya",22));
		list.add(new Person("Ankit",21));
		list.add(new Person("Aman",22));
		list.add(new Person("Mittal",22));
		list.add(new Person("Rishi",22));
		return list;
	}
	
}
