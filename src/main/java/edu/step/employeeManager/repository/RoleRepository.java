package edu.step.employeeManager.repository;

import edu.step.employeeManager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
