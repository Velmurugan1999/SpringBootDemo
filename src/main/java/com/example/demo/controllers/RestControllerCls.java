package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.servicess.EmployeeService;

@RestController
@RequestMapping("/employee/")
public class RestControllerCls {
	@Value("${spring.name.welcome}")
	String welcome;
	@Autowired
	EmployeeService service;
	
	@GetMapping("/welcome")
	public String welcome() {
		return welcome;
	}
	@GetMapping("/getall")
	public List<Employee> getAllEmployee() {
		return service.getallEmployee();
	}
	@PostMapping(path="/update")
	public boolean update(@RequestBody Employee e)
	{
		return service.update(e);
	}
	@PostMapping("/insert")
	public Employee insert(@RequestBody Employee e)
	{
		return service.insert(e);
	}
	@DeleteMapping("/delete/{eid}")
	public String delete(@PathVariable int eid)
	{
		service.delete(eid);
		return "Deleted successfully!!";
	}
}
