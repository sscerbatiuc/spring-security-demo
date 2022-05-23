package edu.step.employeeManager.service;

import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.repository.CompanyRepository;
import edu.step.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyManager { // CRUD

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> read() {
        return companyRepository.findAll();
    }

    public Company findById(Integer id) {
        Optional<Company> company = this.companyRepository.findById(id);
        if(company.isPresent()){
            return company.get();
        }
        return null; //// !!!!!
    }

    public void create(Company company) {
        this.companyRepository.save(company);
    }

    public void update(Company emp) {
        Optional<Company> byId = this.companyRepository.findById(emp.getId());
        this.companyRepository.save(emp);
    }

    public boolean delete(Integer id) {
        Optional<Company> optionalCompany = this.companyRepository.findById(id);
        if(optionalCompany.isPresent()) {
            this.companyRepository.delete(optionalCompany.get());
            return true;
        }
        return false;
    }
}
