package com.test.springboot.repo;

import com.test.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query(value="select * from dbo.employee", nativeQuery=true)
    List<Employee> getAllEmployees();
}
