package edu.step.employeeManager.controller;

import edu.step.employeeManager.dto.LoginRequestDTO;
import edu.step.employeeManager.dto.LoginResponseDTO;
import edu.step.employeeManager.service.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private JwtTokenUtil tokenUtil;

    @PostMapping
    @RequestMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody LoginRequestDTO request){
        String token = tokenUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
