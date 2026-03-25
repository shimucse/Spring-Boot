package com.shima.section4_rest_crud_api.controller;

import com.shima.section4_rest_crud_api.entity.Employee;
import com.shima.section4_rest_crud_api.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService =theEmployeeService;
    }
    @GetMapping("/list")
    public  String listEmployee(Model theModel){
        //get the employees from db

        List<Employee> dbEmployees = employeeService.findAll();

        // 2️⃣ Create some manual employees
        List<Employee> demoEmployees = List.of(
                new Employee("John", "Doe", "john@example.com", "Germany","java"),
                new Employee("Susan", "Smith", "susan@example.com", "India","go"),
                new Employee("Alice", "Brown", "alice@example.com", "Bangladesh","python")
        );

        // 3️⃣ Combine both lists
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.addAll(dbEmployees);
        allEmployees.addAll(demoEmployees);


        theModel.addAttribute("employees",allEmployees);
        return "employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        //set employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);
        //send over to our form
        return "employees/employee-form";

    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
          //save the employee
            employeeService.save(theEmployee);
          //use a redirect to prevent duplicate submissions
          return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("employeeId") int theId){

        employeeService.delete(theId);
        return "redirect:/employees/list";
    }
}
