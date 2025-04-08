package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService ser;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee e) {
		
		//return dao.saveEmployee(e);
		return ser.saveEmployee(e);
	}
	
	@GetMapping("/fetch")
	public Employee fetchEmployee(@RequestParam int id) {
		//return dao.findEmployee(id);
		return ser.fetchEmployee(id);
	}
	 
	@GetMapping("/fetchAll")
	public List<Employee> findAll() {
		return dao.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public Employee deleteEmployee(@PathVariable  int id) {
		//return dao.deleteEmployee(id);
		return ser.deleteEmployee(id);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam  int id,@RequestBody   Employee e) {
		//return dao.updateEmployee(id,e);
		return ser.updateEmployee(id, e);
	}
	
//	@PatchMapping("/updatephone")
//	public Employee updatePhone(int id,long phone) {
//		return dao.updatePhone(id,phone);
//	}
//	
//	@PatchMapping("/updateemail")
//	public Employee updateemail(int id,String email) {
//		return dao.updateEmail(id,email);
//	}
//	
//	@GetMapping("/findbyphone")
//	public Employee findByPhone(long phone) {
//		return dao.findByPhone(phone);
//	}
//	
//	@GetMapping("/findbyemail")
//	public Employee findByEmail(String email) {
//		return dao.findByEmail(email);
//	}
	
	@GetMapping("/salarylessthan")
	public List<Employee> salaryLessThan(@RequestParam  double salary){
		return dao.salaryLessThan(salary);
	}
	
	@GetMapping("salarybetween")
	public List<Employee> salaryBetween(@RequestParam double s1, @RequestParam  double s2){
		return dao.salaryBetween(s1,s2);
	}
	
	
}
