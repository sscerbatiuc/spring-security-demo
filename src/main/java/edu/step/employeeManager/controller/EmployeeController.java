package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.EmployeeDTO;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.repository.EmployeeRepository;
import edu.step.employeeManager.service.EmployeeDTOService;
import edu.step.employeeManager.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired // To remove
    private EmployeeManager manager;
    @Autowired
    private EmployeeDTOService dtoService;


    @RolesAllowed({"ROLE_ADMIN", "ROLE_OPERATOR"})
    @GetMapping
    public List<EmployeeDTO> getAll(){
        return dtoService.getAll();
    }

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping
    public List<EmployeeDTO> getSecured(){
        return dtoService.getAll();
    }


    @PostMapping
    public void create(@RequestBody EmployeeDTO emp){
        dtoService.create(emp);
    }

    // TODO implement role based security
//    @PostMapping
//    public void updateSalary(@RequestBody Double emp){
//
//
//
//    }

//    @GetMapping
//    @RequestMapping("/salary-filter")
//    public List<Employee> filter() {
//        return manager.filterBySalary(800.0);
//    }


    @PutMapping
    public ResponseEntity<String> edit(@RequestBody EmployeeDTO emp) {
       try{
           dtoService.update(emp);
           return ResponseEntity.ok().build();
       } catch (EntityNotFoundException ex) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        boolean result = manager.delete(id);
        if(result){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
