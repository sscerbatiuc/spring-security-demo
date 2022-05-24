package edu.step.employeeManager.config;

import edu.step.employeeManager.model.AppUser;
import edu.step.employeeManager.model.Role;
import edu.step.employeeManager.repository.AppUserRepository;
import edu.step.employeeManager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Configuration
public class UsersConfigurator {

    @Autowired
    private RoleRepository rolesRepository;
    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Role setUpAdminRole() {
        return rolesRepository.save(new Role(Role.USER_ADMIN));
    }

    public Role setUpBasicRole() {
        return rolesRepository.save(new Role(Role.USER));
    }

    @PostConstruct
    public void setUpUsers() {
        if (userRepository.findAll().isEmpty()) {
            Role adminRole = setUpAdminRole();
            Role userRole = setUpBasicRole();
            HashSet<Role> fullRoles = new HashSet<>();
            fullRoles.add(adminRole);
            fullRoles.add(userRole);
            userRepository.save(new AppUser("admin", passwordEncoder.encode("admin"), "John Smith Admin", fullRoles));

            HashSet<Role> basicRoles = new HashSet<>();
            basicRoles.add(userRole);
            userRepository.save(new AppUser("user", passwordEncoder.encode("pwd"), "Regular user", basicRoles));
        }
    }
}
