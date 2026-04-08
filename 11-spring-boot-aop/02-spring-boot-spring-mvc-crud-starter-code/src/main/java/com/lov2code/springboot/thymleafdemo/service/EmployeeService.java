package com.lov2code.springboot.thymleafdemo.service;

import com.lov2code.springboot.thymleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
