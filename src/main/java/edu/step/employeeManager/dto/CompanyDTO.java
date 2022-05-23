package edu.step.employeeManager.dto;

import edu.step.employeeManager.model.Employee;

import java.util.Set;

public class CompanyDTO {

    private Integer id;
    private String name;
    private Set<Integer> employees;

    public CompanyDTO() {
    }

    public CompanyDTO(Integer id, String name, Set<Integer> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Integer> employees) {
        this.employees = employees;
    }
}
