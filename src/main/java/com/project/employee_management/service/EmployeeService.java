package com.project.employee_management.service;

import com.project.employee_management.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(Long departmentId, EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long departmentId,Long employeeId);
    List<EmployeeDto> getAllEmployees(Long departmentId);
    EmployeeDto updateEmployee(Long departmentId,Long employeeId,EmployeeDto employeeDto);
    void deleteEmployee(Long departmentId,Long employeeId);
}
