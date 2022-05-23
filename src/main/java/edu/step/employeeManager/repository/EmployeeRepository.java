package edu.step.employeeManager.repository;

import edu.step.employeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//
//    List<Employee> findEmployeesBySalaryIsGreaterThan(Double salary);
//
//    Employee countBySalaryGreaterThan(Double salary);
//
//    long countByCompanyNameLike()
}
