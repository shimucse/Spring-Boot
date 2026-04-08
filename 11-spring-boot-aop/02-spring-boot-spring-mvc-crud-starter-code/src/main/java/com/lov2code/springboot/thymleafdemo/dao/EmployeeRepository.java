package com.lov2code.springboot.thymleafdemo.dao;

import com.lov2code.springboot.thymleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
    //no code ;
    //add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
