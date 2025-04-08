package com.qsp.employee_management_system.dao;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee e) {
		return repo.save(e);	
	}
//	public List<Employee> saveAllEmployee(List<Employee> list){
//		return repo.save(list);
//	}
	
	public Employee findEmployee(int id) {
		//return repo.findById(id).get();
		//to avoid noSuchElementException
		Optional<Employee> op=repo.findById(id);
		if(op.isPresent() ) {
			return op.get();
		}
		return null;
	} 
	
	public List<Employee> findAll() {
		return repo.findAll();
	}

//	public Employee deleteEmployee(int id) {
//		Optional<Employee> op=repo.findById(id);
//		if(op.isPresent() ) {
			//repo.deleteById(id);
			//return op.get();
			    //or
//			Employee employee=op.get();
//			repo.delete(employee);
//			return employee;
//		}
//          return null;
//	}
	public Employee deleteEmployee(Employee e) {
		repo.delete(e);
		return e;
	}

//	public Employee updateEmployee(int id, Employee e) {
//	
//		Optional<Employee> op=repo.findById(id);
//		if(op.isPresent() ) {
//			e.setId(id);
//			return repo.save(e);
//		}
//		return null;
//	}

	public List<Employee> salaryLessThan(double salary) {
		return repo.findEmployeesBySalaryLessThan(salary);
	}

	public List<Employee> salaryBetween(double s1,double s2) {
		return repo.findEmployeeBySalaryBetween(s1,s2);
	
	}
}
