package com.shima.section4_rest_crud_api.dao;

import com.shima.section4_rest_crud_api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int field);
    Employee save(Employee theEmployee);
    void delete(int field);
}
