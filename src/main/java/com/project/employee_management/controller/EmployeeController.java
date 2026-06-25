package com.project.employee_management.controller;

import com.project.employee_management.dto.EmployeeDto;
import com.project.employee_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/departments")
@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/{departmentId}/employees")
    public ResponseEntity<EmployeeDto> addEmployee(@PathVariable Long departmentId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.addEmployee(departmentId, employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/{departmentId}/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long departmentId, @PathVariable("id") Long employeeId ){
        EmployeeDto employee=employeeService.getEmployeeById(departmentId, employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@PathVariable Long departmentId ){
        List<EmployeeDto> employees=employeeService.getAllEmployees(departmentId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{departmentId}/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long departmentId, @PathVariable("id") Long employeeId ,@RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedemployee=employeeService.updateEmployee(departmentId, employeeId,employeeDto);
        return new ResponseEntity<>(updatedemployee, HttpStatus.OK);
    }
    @DeleteMapping("/{departmentId}/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long departmentId, @PathVariable Long employeeId){
        employeeService.deleteEmployee(departmentId, employeeId);
        return  ResponseEntity.ok("Employee deleted successfully");
    }


}
