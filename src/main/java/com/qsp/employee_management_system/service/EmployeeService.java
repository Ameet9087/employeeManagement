package com.qsp.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	public Employee saveEmployee(Employee e) {
		double sal=e.getSalary();
		if (sal<1000) {
			e.setGrade('D');
		} else if(sal>1000 && sal<2000){
            e.setGrade('C');
		}else if(sal>2000 && sal<3000) {
			e.setGrade('B');
		}else{
			e.setGrade('A');
		}
		return dao.saveEmployee(e);
	}
	
//.................................................................
	public Employee fetchEmployee(int id) {
		return dao.findEmployee(id);
	}
//..................................................................
  public Employee deleteEmployee(int id) {
	  Employee e=dao.findEmployee(id);
	  if(e!=null) {
		  return dao.deleteEmployee(e);
	  }
	  return null;
  }
 //........................................................................
  public Employee updateEmployee(int id,Employee e) {
	  Employee emp=dao.findEmployee(id);
	  if(emp!=null) {
		 e.setId(id);
		 double sal=e.getSalary();
			if (sal<1000) {
				e.setGrade('D');
			} else if(sal>1000 && sal<2000){
	            e.setGrade('C');
			}else if(sal>2000 && sal<3000) {
				e.setGrade('B');
			}else{
				e.setGrade('A');
			}
			return dao.saveEmployee(emp);
	  }	  
  return null;
  }
//............................................................................
  
//  public List<Employee> saveAllEmployee(List<Employee> list) {
//	  for(Employee e :list) {
//		  double sal=e.getSalary();
//		  if (sal<1000) {
//				e.setGrade('D');
//			} else if(sal>1000 && sal<2000){
//	            e.setGrade('C');
//			}else if(sal>2000 && sal<3000) {
//				e.setGrade('B');
//			}else{
//				e.setGrade('A');
//			}
//	  }
//	  return dao.saveEmployee(list);
//  }
}
