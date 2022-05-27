package com.test.springboot.controller;

import com.test.springboot.exception.EmployeeException;
import com.test.springboot.model.Employee;
import com.test.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Value("${spring.datasource.jdbcUrl}")
    private String url;

//    @GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getEmployee(@PathVariable Integer id){
//        return "My employee id is %s".formatted(id);
//    }

    @GetMapping
    public List<Employee> getEmployees(){
        System.out.println("DB2-URL:::::::::::" + url);
        return employeeService.getEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee e){
        return employeeService.addEmployee(e);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Employee updateEmployee(@RequestBody Employee e){
        if(true)throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return employeeService.addEmployee(e);
    }
}
