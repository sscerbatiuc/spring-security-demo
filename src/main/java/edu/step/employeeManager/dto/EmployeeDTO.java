package edu.step.employeeManager.dto;

public class EmployeeDTO {

    private Integer id;
    private String firstName;
    private String lastname;
    private Integer company;
    private Double salary;
    private AddressDTO address;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String firstName, String lastname, Integer company) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
