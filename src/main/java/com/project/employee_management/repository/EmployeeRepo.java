package com.project.employee_management.repository;

import com.project.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByDepartmentId(Long departmentId);
}
