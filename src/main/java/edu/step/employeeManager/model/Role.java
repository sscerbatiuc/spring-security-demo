package edu.step.employeeManager.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {

  public static final String USER_ADMIN = "ADMIN";
  public static final String USER = "USER";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String authority;

  @ManyToMany(mappedBy = "authorities")
  private Set<AppUser> users;

  public Role() {
  }

  public Role(String authority) {
    this.authority = authority;
  }

  @Override
  public String getAuthority() {
    return authority;
  }
}
