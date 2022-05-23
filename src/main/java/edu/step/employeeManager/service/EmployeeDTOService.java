package edu.step.employeeManager.service;

import edu.step.employeeManager.dto.AddressDTO;
import edu.step.employeeManager.dto.EmployeeDTO;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Address;
import edu.step.employeeManager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDTOService {

    @Autowired
    private EmployeeManager manager;
    @Autowired
    private CompanyManager companyManager;

    public List<EmployeeDTO> getAll() {
        List<Employee> employees = manager.read();
        return employees.stream()
                .map(e -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO(e.getId(), e.getFirstName(), e.getLastname(), e.getCompany() != null ? e.getCompany().getId() : null);
                    if(e.getAddress() != null){
                        AddressDTO addressDTO = new AddressDTO();
                        addressDTO.setStreet(e.getAddress().getStreetInfo());
                        employeeDTO.setAddress(addressDTO);
                    }
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    public void create(EmployeeDTO employeeDTO) {
        // Undeva aici se intampla vreo eroare!
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastname(employeeDTO.getLastname());
        employee.setCompany(companyManager.findById(employeeDTO.getCompany())); // 1
        Address address = new Address();
        address.setStreetInfo(employeeDTO.getAddress().getStreet());
        employee.setAddress(address);
        manager.create(employee);
    }

    public void update(EmployeeDTO dto) throws EntityNotFoundException {
        Employee editedEmployee = new Employee();
        editedEmployee.setId(dto.getId());
        editedEmployee.setFirstName(dto.getFirstName());
        editedEmployee.setLastname(dto.getLastname());
        editedEmployee.setCompany(companyManager.findById(dto.getCompany()));
        if(dto.getAddress()!= null){
            Address address = new Address();
            address.setStreetInfo(dto.getAddress().getStreet());
            editedEmployee.setAddress(address);
        }
        manager.update(editedEmployee);
    }
}
