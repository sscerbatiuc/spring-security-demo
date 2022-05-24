package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.EmployeeDTO;
import edu.step.employeeManager.exceptions.EntityNotFoundException;
import edu.step.employeeManager.service.EmployeeDTOService;
import edu.step.employeeManager.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired // To remove
    private EmployeeManager manager;
    @Autowired
    private EmployeeDTOService dtoService;


    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/public")
    public List<EmployeeDTO> getAll(){
        return dtoService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/secured")
    public List<EmployeeDTO> getSecured(){
        return dtoService.getAll();
    }


    @PostMapping
    public void create(@RequestBody EmployeeDTO emp){
        dtoService.create(emp);
    }



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
