package edu.step.employeeManager.service;

import edu.step.employeeManager.dto.CompanyDTO;
import edu.step.employeeManager.dto.EmployeeDTO;
import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CompanyDTOService {

    @Autowired
    private CompanyManager companyManager;

    public List<CompanyDTO> getAll() {
        List<Company> companies = companyManager.read();
        return companies.stream()
                .map(company -> {
                    Set<Integer> ids = company.getEmployees().stream().map(emp -> emp.getId()).collect(Collectors.toSet());
                    return new CompanyDTO(company.getId(), company.getName(), ids);
                })
                .collect(Collectors.toList());
    }

//    public void create(EmployeeDTO dto) {
//        Employee employee = new Employee();
//        employee.setFirstName(dto.getFirstName());
//        employee.setLastname(dto.getLastname());
//        employee.setCompany(companyManager.findById(dto.getCompany())); // 1
//        manager.create(employee);
//    }
}
