package edu.step.employeeManager.service;

import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Address;
import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeManager { // CRUD

    @Autowired
    private EmployeeRepository employeeRepository;

    public void create(Employee emp) {
        employeeRepository.save(emp);
    }

    public List<Employee> read(){
       return employeeRepository.findAll();
    }

    // edit
    public boolean update(Employee updatedEmployee) throws EntityNotFoundException{
        Optional<Employee> optionalEmployee = employeeRepository.findById(updatedEmployee.getId());
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastname(updatedEmployee.getLastname());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setCompany(updatedEmployee.getCompany());
            if(employee.getAddress() != null) {
                if(updatedEmployee.getAddress() != null) {
                    employee.getAddress().setStreetInfo(updatedEmployee.getAddress().getStreetInfo());
                }
            } else {
                employee.setAddress(updatedEmployee.getAddress());
            }
            employeeRepository.save(employee);
            return true;
        }
        throw new EntityNotFoundException(updatedEmployee.getId());
    }


    public boolean delete(Integer id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        }
        return false;
    }
    // delete
}
