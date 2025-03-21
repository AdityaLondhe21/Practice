package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

@WebMvcTest(controllers = EmpController.class)
public class EmpControllerTest {
	
	@MockitoBean
	private EmployeeService empService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetEmployee() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
			.andExpect(MockMvcResultMatchers.status().is(200));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void testGetEmployeeBelow() {
		try {
			List<Employee> list=new ArrayList<Employee>();
			list.add(new Employee());
			Mockito.when(empService.getEmployeeBelow(25)).thenReturn(list);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
