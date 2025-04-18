package com.qsp.employee_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{


	List<Employee> findEmployeesBySalaryLessThan(double salary);

	@Query("select s from Employee s where s.salary between ?1 and ?2")
	List<Employee> findEmployeeBySalaryBetween(double s1,double s2);
}
