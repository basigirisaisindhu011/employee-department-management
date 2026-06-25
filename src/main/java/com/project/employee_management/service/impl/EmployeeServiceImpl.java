package com.project.employee_management.service.impl;

import com.project.employee_management.dto.EmployeeDto;
import com.project.employee_management.entity.Department;
import com.project.employee_management.entity.Employee;
import com.project.employee_management.exception.BadRequestException;
import com.project.employee_management.exception.ResourceNotFoundException;
import com.project.employee_management.repository.DepartmentRepo;
import com.project.employee_management.repository.EmployeeRepo;
import com.project.employee_management.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    private DepartmentRepo departmentRepo;
    private ModelMapper modelMapper;
    public EmployeeServiceImpl(EmployeeRepo employeeRepo,DepartmentRepo departmentRepo,ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo=departmentRepo;
        this.modelMapper=modelMapper;
    }

    @Override
    public EmployeeDto addEmployee(Long departmentId, EmployeeDto employeeDto) {
       Department department=departmentRepo.findById(departmentId)
               .orElseThrow(()->new ResourceNotFoundException("Department not found with id"+departmentId));
       Employee employee=modelMapper.map(employeeDto,Employee.class);

        employee.setDepartment(department);
        Employee savedEmployee=employeeRepo.save(employee);
        EmployeeDto savedEmployeeDto=modelMapper.map(savedEmployee, EmployeeDto.class);
        savedEmployeeDto.setDepartmentId(departmentId);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long departmentId, Long employeeId) {
        Department department=departmentRepo.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found with id:"+departmentId));
        Employee employee=employeeRepo.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id:"+employeeId));
       if(!employee.getDepartment().getId().equals(department.getId())){
           throw new BadRequestException(("This employee does not belong to the department with id:"+departmentId));
       }
       EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);
       employeeDto.setDepartmentId(employee.getDepartment().getId());

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees(Long departmentId) {
        Department department=departmentRepo.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found with id:"+departmentId));

        List<Employee> employees=employeeRepo.findByDepartmentId(departmentId);

        return employees.stream().map((employee)-> modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long departmentId, Long employeeId, EmployeeDto employeeDto) {
        Department department=departmentRepo.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found with id:"+departmentId));
        Employee employee=employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not found with id:"+employeeId));
        if(!employee.getDepartment().getId().equals(department.getId())){
            throw new BadRequestException(("This employee does not belong to the department with id:"+departmentId));
        }
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        employeeRepo.save(employee);

        EmployeeDto savedEmployeeDto=modelMapper.map(employee,EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public void deleteEmployee(Long departmentId, Long employeeId) {
        Department department=departmentRepo.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department not found with id:"+departmentId));
        Employee employee=employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not found with id:"+employeeId));
        if(!employee.getDepartment().getId().equals(department.getId())){
            throw new BadRequestException(("This employee does not belong to the department with id:"+departmentId));
        }
        employeeRepo.delete(employee);
    }
}
