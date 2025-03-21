package com.example.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.Student;
import com.example.models.Address;
import com.example.models.Employee;

@Configuration
public class MyJavaConfiguration {
	@Bean("emp")
	@Scope("prototype")
	public Employee getEmployee() {
		return new Employee("Raju",25,3000,"Tester",getAddress());
	}
	
	@Bean("std")
	public Student getStudent() {
		return new Student();
	}
	
	@Bean("addr_c")
	public Address getAddress() {
		return new Address("Karnataka","Bangalore",560100);
	}
	
	@Bean("emp_s")
	public Employee getEmployee2() {
		Employee e = new Employee();
		e.setName("Manisha");
		e.setAge(33);
		e.setSalary(70000);
		e.setDesignation("Programmer");
		e.setAddress(getAddress());
		return e;
	}
	@Bean("emp_s2")
	public Employee getEmployee3() {
		Employee e = new Employee();
		e.setName("Mahesh");
		e.setAge(53);
		e.setSalary(75000);
		e.setDesignation("Programmer");
		e.setAddress(getAddress2());
		return e;
	}
	
	@Bean("addr_s")
	public Address getAddress2() {
		Address a1 = new Address();
		a1.setState("Maharashtra");
		a1.setCity("Pune");
		a1.setPin(411046);
		return a1;
	}
}
