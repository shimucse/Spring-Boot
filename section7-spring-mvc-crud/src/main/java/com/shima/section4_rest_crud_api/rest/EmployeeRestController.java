package com.shima.section4_rest_crud_api.rest;

import com.shima.section4_rest_crud_api.entity.Employee;
import com.shima.section4_rest_crud_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api")
public class EmployeeRestController {
   /* private EmployeeService employeeService;
    // You only need JsonMapper if you implement PATCH (partial update).
    private JsonMapper josonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper){
        employeeService = theEmployeeService;
        josonMapper = theJsonMapper;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public  Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee ==null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    //@RequestBody: “Take the body of the HTTP request and map it to this Java object.
    public  Employee addEmployee(@RequestBody  Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PatchMapping("/employees/{employeeId}")
    public  Employee patchEmployee(@PathVariable int employeeId,@RequestBody Map<String, Object> patchPayload){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body -"+employeeId);
        }
        Employee patchedEmployee = josonMapper.updateValue(tempEmployee, patchPayload);
        Employee dbEmployee = employeeService.save(patchedEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
         Employee theEmployee = employeeService.findById(employeeId);
         if(theEmployee==null){
             throw new RuntimeException("Employee if not found -"+employeeId);
         }
         employeeService.delete(employeeId);
         return "Deleted employee id -"+employeeId;
    }*/

}
