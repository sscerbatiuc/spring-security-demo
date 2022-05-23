package edu.step.employeeManager.repository;

import edu.step.employeeManager.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // findBy, getBy, readBy

    Company findByNameLike(String name);

//    public void findByNameLikeAnd(Em)

}
