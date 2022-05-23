package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.CompanyDTO;
import edu.step.employeeManager.model.Company;
import edu.step.employeeManager.repository.CompanyRepository;
import edu.step.employeeManager.service.CompanyDTOService;
import edu.step.employeeManager.service.CompanyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyManager companyManager;
    @Autowired
    private CompanyDTOService dtoService;

    @Autowired
    private CompanyRepository repository;

    @GetMapping("/filtered")
    public List<CompanyDTO> getAllFiltered(){

        repository.findByNameLike("Goo%");
        return new ArrayList<>();
    }


    @PostMapping
    public void create(@RequestBody Company emp){
        companyManager.create(emp);
    }

    @PutMapping
    public void edit(@RequestBody Company emp) {
        companyManager.update(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        boolean result = companyManager.delete(id);
        if(result){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<CompanyDTO> getAll(){
        return dtoService.getAll();
    }


}
