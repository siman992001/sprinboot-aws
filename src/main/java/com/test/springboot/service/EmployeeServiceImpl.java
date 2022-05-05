package com.test.springboot.service;

import com.test.springboot.model.Employee;
import com.test.springboot.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    @Override
    public Employee addEmployee(Employee e) {
        return employeeRepo.save(e);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
    @Override
    public Employee getEmployee(Long id){
        Optional<Employee> oe = employeeRepo.findById(id);
        return oe.get();
    }
}
