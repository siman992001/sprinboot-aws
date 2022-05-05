package com.test.springboot.service;

import com.test.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee addEmployee(Employee e);

    void deleteEmployee(Long id);

    Employee getEmployee(Long id);
}
