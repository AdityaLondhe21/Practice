package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Person;
import com.example.demo.models.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		BeanFactory factory = SpringApplication.run(DemoApplication.class,args);
		System.out.println("Hello Spring Application");
			
		Person p1 = (Person)factory.getBean("student");
		System.out.println(p1);
		Person p2 = (Person)factory.getBean("emp");
		System.out.println(p2);
		Person p3 = (Person)factory.getBean("emp");
		System.out.println(p3);

	}

}
