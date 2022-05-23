package edu.step.employeeManager.exceptions;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(Integer id) {
        super("Cannot find entity with id=" + id);
    }
}
